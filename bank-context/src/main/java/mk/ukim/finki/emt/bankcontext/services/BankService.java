package mk.ukim.finki.emt.bankcontext.services;

import mk.ukim.finki.emt.bankcontext.domain.model.Bank;
import mk.ukim.finki.emt.bankcontext.domain.model.BankId;
import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;

import java.util.List;
import java.util.Optional;

public interface BankService {
    void createUserInBank(String bankIdString, String name, String surname, String location, UserType type);
    void createUserAccountInBank(String bankIdString, String userIdString, String password);
    Optional<Bank> findById(BankId bankId);
    void save(Bank bank);
    List<Bank> getAll();
}
