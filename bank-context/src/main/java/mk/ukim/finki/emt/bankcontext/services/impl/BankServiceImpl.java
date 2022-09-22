package mk.ukim.finki.emt.bankcontext.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.bankcontext.domain.model.Bank;
import mk.ukim.finki.emt.bankcontext.domain.model.BankId;
import mk.ukim.finki.emt.bankcontext.domain.model.UserId;
import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;
import mk.ukim.finki.emt.bankcontext.domain.repository.BankRepository;
import mk.ukim.finki.emt.bankcontext.services.BankService;
import mk.ukim.finki.emt.sharedkernel.domain.events.account.AccountCreated;
import mk.ukim.finki.emt.sharedkernel.infra.DomainEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;
    private final DomainEventPublisher domainEventPublisher;

    @Override
    public void createUserInBank(String bankIdString, String name, String surname, String location, UserType type) {
        BankId bankId = new BankId(bankIdString);
        Bank bank = bankRepository.findById(bankId).orElseThrow(()->new RuntimeException("Bank doesn't exist"));
        bank.createNewUser(name, surname, location, type);
        bankRepository.save(bank);
    }

    @Override
    public void createUserAccountInBank(String bankIdString, String userIdString) {
        BankId bankId = new BankId(bankIdString);
        UserId userId = new UserId(userIdString);
        Bank bank = bankRepository.findById(bankId).orElseThrow(()->new RuntimeException("Bank doesn't exist"));
        Random random = new Random();
        Long accountNumber = Math.abs(random.nextLong());
        if(!bank.createNewUserAccount(userId, accountNumber)) return;
        String password = "password";
        domainEventPublisher.publish(new AccountCreated(accountNumber, password, UserType.NORMAL_USER));
        bankRepository.save(bank);
    }

    @Override
    public Bank findById(BankId bankId) {
        return bankRepository.findById(bankId).orElseThrow(()->new RuntimeException("Bank doesn't exist"));
    }

    @Override
    public void save(Bank bank) {
        bankRepository.save(bank);
    }

    @Override
    public List<Bank> getAll() {
        return bankRepository.findAll();
    }
}
