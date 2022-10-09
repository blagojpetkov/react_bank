package mk.ukim.finki.emt.transactioncontext.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.atm.ATM_almost_empty;
import mk.ukim.finki.emt.sharedkernel.domain.events.transaction.TransactionCreated;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.sharedkernel.infra.DomainEventPublisher;
import mk.ukim.finki.emt.transactioncontext.domain.models.ATM;
import mk.ukim.finki.emt.transactioncontext.domain.models.ATMId;
import mk.ukim.finki.emt.transactioncontext.domain.models.Account;
import mk.ukim.finki.emt.transactioncontext.domain.models.AccountId;
import mk.ukim.finki.emt.transactioncontext.domain.repository.ATMRepository;
import mk.ukim.finki.emt.transactioncontext.domain.repository.AccountRepository;
import mk.ukim.finki.emt.transactioncontext.domain.valueobjects.BankId;
import mk.ukim.finki.emt.transactioncontext.services.ATMService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ATMServiceImpl implements ATMService {

    private final ATMRepository atmRepository;
    private final AccountRepository accountRepository;
    private final DomainEventPublisher domainEventPublisher;

    @Override
    public void createAccount(String bankIdString, Long accountNumber, String password, UserType type) {
        Account account = new Account(bankIdString, accountNumber, password, 0.0, type);
        accountRepository.save(account);
    }


    @Override
    public void refill(ATMId atmId) {
        ATM atm = atmRepository.findById(atmId).orElseThrow(()->new RuntimeException("ATM id does not exist"));;
        atm.refill();
        atmRepository.save(atm);
    }

    @Override
    public void withdrawMoney(String ATMIdString, Long accountNumber, String password, Double amount1) {

        Money amount = new Money(Currency.USD, amount1);
        ATMId atmId = new ATMId(ATMIdString);
        Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow(()->new RuntimeException("Account number does not exist"));
        ATM atm = atmRepository.findById(atmId).orElseThrow(()->new RuntimeException("ATM id does not exist"));;
        if(atm.withdrawMoney(account, amount))
            domainEventPublisher.publish(new TransactionCreated(atm.getBankId().getId()));
        else throw new RuntimeException("Not enough balance on account or ATM");

        if(atm.getBalance().getAmount()<15000)
            domainEventPublisher.publish(new ATM_almost_empty(atm.getId().getId()));
        atmRepository.save(atm);
        accountRepository.save(account);

    }

    @Override
    public void depositMoney(String ATMIdString, Long accountNumber, String password, Double amount1) {
        Money amount = new Money(Currency.USD, amount1);
        ATMId atmId = new ATMId(ATMIdString);
        Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow(()->new RuntimeException("Account number does not exist"));
        ATM atm = atmRepository.findById(atmId).orElseThrow(()->new RuntimeException("ATM id does not exist"));;
        atm.depositMoney(account, amount);
        domainEventPublisher.publish(new TransactionCreated(atm.getBankId().getId()));
        atmRepository.save(atm);
        accountRepository.save(account);
    }

    @Override
    public void login(String atmIdString, Long accountNumber, String password) {
        ATMId atmId = new ATMId(atmIdString);
        Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow(()->new RuntimeException("Account number does not exist"));
        ATM atm = atmRepository.findById(atmId).orElseThrow(()->new RuntimeException("ATM id does not exist"));;
        if(!atm.getBankId().getId().equals(account.getBankId().getId()))
            throw new RuntimeException("Account belongs to another bank");
        if(!account.getAccountPassword().equals(password))
            throw new RuntimeException("Password is incorrect");
    }

    @Override
    public void save(String location, BankId bankId) {
        atmRepository.save(new ATM(location, bankId));
    }

    @Override
    public List<ATM> findAll() {
        return atmRepository.findAll();
    }

    @Override
    public Optional<ATM> findById(ATMId atmId) {
        return atmRepository.findById(atmId);
    }
}
