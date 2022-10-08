package mk.ukim.finki.emt.transactioncontext.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;
import mk.ukim.finki.emt.transactioncontext.domain.valueobjects.BankId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class Account extends AbstractEntity<AccountId> {
    @AttributeOverride(name = "id", column = @Column(name = "bank_id", nullable = true))
    private BankId bankId;

    private Long accountNumber;
    private String accountPassword;
    private Double accountBalance;
    private UserType type;

    public Account(String bankIdString, Long accountNumber, String accountPassword, Double accountBalance, UserType type) {
        super(AccountId.randomId(AccountId.class));
        this.bankId = new BankId(bankIdString);
        this.accountNumber = accountNumber;
        this.accountPassword = accountPassword;
        this.accountBalance = accountBalance;
        this.type = type;
    }

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Transaction> transactions = new HashSet<>();

    public Account() {
        super(AccountId.randomId(AccountId.class));
    }

    public void withdraw(Double amount) {
        this.accountBalance-=amount;
    }

    public void deposit(Double amount) {
        this.accountBalance+=amount;
    }
}
