package mk.ukim.finki.emt.transactioncontext.services;

import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;
import mk.ukim.finki.emt.transactioncontext.domain.models.ATMId;
import mk.ukim.finki.emt.transactioncontext.domain.models.AccountId;

public interface ATMService {
    void createAccount(String bankIdString, Long accountNumber, String password, UserType type);
    void refill(ATMId atmId);

    void withdrawMoney(String ATMIdString, Long accountNumber, String password, Double amount);

    void depositMoney(String ATMIdString, Long accountNumber, String password, Double amount);

    void login(String atmIdString, Long accountNumber, String password);
}
