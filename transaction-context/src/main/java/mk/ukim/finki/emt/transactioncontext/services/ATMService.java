package mk.ukim.finki.emt.transactioncontext.services;

import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;
import mk.ukim.finki.emt.transactioncontext.domain.models.ATM;
import mk.ukim.finki.emt.transactioncontext.domain.models.ATMId;
import mk.ukim.finki.emt.transactioncontext.domain.valueobjects.BankId;

import java.util.List;
import java.util.Optional;

public interface ATMService {
    void createAccount(String bankIdString, Long accountNumber, String password, UserType type);
    void refill(ATMId atmId);

    void withdrawMoney(String ATMIdString, Long accountNumber, String password, Double amount);

    void depositMoney(String ATMIdString, Long accountNumber, String password, Double amount);

    void login(String atmIdString, Long accountNumber, String password);
    void save(String location, BankId bankId);
    List<ATM> findAll();
    Optional<ATM> findById(ATMId atmId);
}
