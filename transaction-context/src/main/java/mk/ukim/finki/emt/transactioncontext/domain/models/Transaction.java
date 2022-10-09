package mk.ukim.finki.emt.transactioncontext.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.Entity;
import java.time.Instant;

@Entity
@Getter
public class Transaction extends AbstractEntity<TransactionId> {
    private Instant processedOn;
    private Money amount;

    public Transaction(Instant processedOn, Double amount) {
        super(TransactionId.randomId(TransactionId.class));
        this.processedOn = processedOn;
        this.amount = new Money(Currency.USD, amount);
    }

    public Transaction() {
        super(TransactionId.randomId(TransactionId.class));
    }
}
