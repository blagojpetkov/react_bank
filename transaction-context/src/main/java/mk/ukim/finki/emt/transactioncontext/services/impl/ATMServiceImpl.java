package mk.ukim.finki.emt.transactioncontext.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.atm.ATM_almost_empty;
import mk.ukim.finki.emt.sharedkernel.domain.events.transaction.TransactionCreated;
import mk.ukim.finki.emt.sharedkernel.infra.DomainEventPublisher;
import mk.ukim.finki.emt.transactioncontext.domain.models.ATM;
import mk.ukim.finki.emt.transactioncontext.domain.models.ATMId;
import mk.ukim.finki.emt.transactioncontext.domain.models.Account;
import mk.ukim.finki.emt.transactioncontext.domain.models.AccountId;
import mk.ukim.finki.emt.transactioncontext.domain.repository.ATMRepository;
import mk.ukim.finki.emt.transactioncontext.domain.repository.AccountRepository;
import mk.ukim.finki.emt.transactioncontext.services.ATMService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ATMServiceImpl implements ATMService {

    private final ATMRepository atmRepository;
    private final AccountRepository accountRepository;
    private final DomainEventPublisher domainEventPublisher;

    @Override
    public void createAccount(Long accountNumber, String password, UserType type) {
        Account account = new Account(accountNumber, password, 0.0, type);
        accountRepository.save(account);
    }

    @Override
    public void withdrawMoney(String accountIdString, String ATMIdString, Double amount) {
        AccountId accountId = new AccountId(accountIdString);
        ATMId atmId = new ATMId(ATMIdString);
        Account account = accountRepository.findById(accountId).orElseThrow(()->new RuntimeException("Account id does not exist"));
        ATM atm = atmRepository.findById(atmId).orElseThrow(()->new RuntimeException("ATM id does not exist"));;
        atm.withdrawMoney(account, amount);
        if(atm.getBalance()<15000)
            domainEventPublisher.publish(new ATM_almost_empty(atm.getId().getId()));
        domainEventPublisher.publish(new TransactionCreated(atm.getBankId().getId()));
        atmRepository.save(atm);
        accountRepository.save(account);
    }

    @Override
    public void depositMoney(String accountIdString, String ATMIdString, Double amount) {
        AccountId accountId = new AccountId(accountIdString);
        ATMId atmId = new ATMId(ATMIdString);
        Account account = accountRepository.findById(accountId).orElseThrow(()->new RuntimeException("Account id does not exist"));
        ATM atm = atmRepository.findById(atmId).orElseThrow(()->new RuntimeException("ATM id does not exist"));;
        atm.depositMoney(account, amount);
        domainEventPublisher.publish(new TransactionCreated(atm.getBankId().getId()));
        atmRepository.save(atm);
        accountRepository.save(account);
    }

    @Override
    public void refill(ATMId atmId) {
        ATM atm = atmRepository.findById(atmId).orElseThrow(()->new RuntimeException("ATM id does not exist"));;
        atm.refill();
        atmRepository.save(atm);
    }
}
