package mk.ukim.finki.emt.sharedkernel.domain.events.transaction;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

@Getter
public class TransactionCreated extends DomainEvent {

    private String bankIdString;

    public TransactionCreated() {
        super(TopicHolder.TOPIC_TRANSACTION_CREATED);
    }

    public TransactionCreated(String bankIdString) {
        super(TopicHolder.TOPIC_TRANSACTION_CREATED);
        this.bankIdString = bankIdString;
    }
}
