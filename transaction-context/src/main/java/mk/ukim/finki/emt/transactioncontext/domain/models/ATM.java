package mk.ukim.finki.emt.transactioncontext.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;
import mk.ukim.finki.emt.transactioncontext.valueobjects.BankId;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class ATM extends AbstractEntity<ATMId> {

    public ATM(){
        super(ATMId.randomId(ATMId.class));
        this.balance = 0.0;
        this.location = "Test location";
        this.bankId = new BankId("3f6f173b-009a-410a-8188-9effa8327ce6");
    }

    @AttributeOverride(name = "id", column = @Column(name = "bank_id", nullable = false))
    private BankId bankId;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Transaction> transactions = new HashSet<>();

    private Double balance;
    private String location;

    public boolean withdrawMoney(Account account, Double amount) {
        if(amount>balance) return false;
        if(amount>account.getAccountBalance()) return false;
        if(account.getType().equals(UserType.NORMAL_USER) && amount>15000.0) return false;
        if(account.getType().equals(UserType.VIP) && amount>40000.0) return false;
        this.balance-=amount;
        account.withdraw(amount);
        transactions.add(new Transaction(Instant.now(), -amount));
        return true;

    }

    public boolean depositMoney(Account account, Double amount) {
        this.balance+=amount;
        account.deposit(amount);
        transactions.add(new Transaction(Instant.now(), amount));
        return true;
    }
    public void refill(){
        this.balance+=50000;
    }
}
