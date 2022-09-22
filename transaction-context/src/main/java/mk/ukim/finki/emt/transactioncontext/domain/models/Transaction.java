package mk.ukim.finki.emt.transactioncontext.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import java.time.Instant;

@Entity
@Getter
public class Transaction extends AbstractEntity<TransactionId> {
    private Instant processedOn;
    private Double amount;

    public Transaction(Instant processedOn, Double amount) {
        super(TransactionId.randomId(TransactionId.class));
        this.processedOn = processedOn;
        this.amount = amount;
    }

    public Transaction() {
        super(TransactionId.randomId(TransactionId.class));
    }
}
