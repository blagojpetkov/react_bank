package mk.ukim.finki.emt.transactioncontext.services;

import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;
import mk.ukim.finki.emt.transactioncontext.domain.models.ATMId;
import mk.ukim.finki.emt.transactioncontext.domain.models.AccountId;

public interface ATMService {
    void createAccount(Long accountNumber, String password, UserType type);
    void withdrawMoney(String accountIdString, String ATMIdString, Double amount);
    void depositMoney(String accountIdString, String ATMIdString, Double amount);
    void refill(ATMId atmId);
}
