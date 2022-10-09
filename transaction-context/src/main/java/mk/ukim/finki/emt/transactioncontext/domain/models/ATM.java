package mk.ukim.finki.emt.transactioncontext.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.transactioncontext.domain.valueobjects.BankId;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class ATM extends AbstractEntity<ATMId> {

    public ATM(){
        super(ATMId.randomId(ATMId.class));
        this.balance = new Money(Currency.USD, 0.0);
        this.location = "Test location";
        this.bankId = new BankId("3f6f173b-009a-410a-8188-9effa8327ce6");
    }

    public ATM(String location, BankId bankId){
        super(ATMId.randomId(ATMId.class));
        this.location = location;
        this.bankId = bankId;
        this.balance = new Money(Currency.USD, 100000.0);
    }

    @AttributeOverride(name = "id", column = @Column(name = "bank_id", nullable = false))
    private BankId bankId;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Transaction> transactions = new HashSet<>();

    private Money balance;
    private String location;

    public boolean withdrawMoney(Account account, Money amount) {
        if(!this.bankId.getId().equals(account.getBankId().getId())) throw new RuntimeException("Account belongs to another bank");
        if(amount.getAmount()>balance.getAmount()) throw new RuntimeException("The amount you are trying to withdraw is larger than the ATM's balance");
        if(amount.getAmount()>account.getAccountBalance().getAmount()) throw new RuntimeException("The amount you are trying to withdraw is larger than the account's balance");
        if(account.getType().equals(UserType.NORMAL_USER) && amount.getAmount()>15000.0) throw new RuntimeException("Normal users can't withdraw more than 15000");
        if(account.getType().equals(UserType.VIP) && amount.getAmount()>40000.0) throw new RuntimeException("VIP users can't withdraw more than 40000");
        this.balance = this.balance.subtract(amount);
        account.withdraw(amount);
        Transaction transaction = new Transaction(Instant.now(), -amount.getAmount());
        transactions.add(transaction);
        account.getTransactions().add(transaction);
        return true;

    }

    public boolean depositMoney(Account account, Money amount) {
        this.balance = this.balance.add(amount);
        account.deposit(amount);
        Transaction transaction = new Transaction(Instant.now(), amount.getAmount());
        transactions.add(transaction);
        account.getTransactions().add(transaction);
        return true;
    }
    public void refill(){
        this.balance = this.balance.add(new Money(Currency.USD, 50000));
    }
}
