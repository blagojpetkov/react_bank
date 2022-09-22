package mk.ukim.finki.emt.sharedkernel.domain.events.atm;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

@Getter
public class ATM_refilled extends DomainEvent {

    private String atmIdString;
    public ATM_refilled() {
        super(TopicHolder.TOPIC_ATM_REFILLED);
    }

    public ATM_refilled(String atmIdString) {
        super(TopicHolder.TOPIC_ATM_REFILLED);
        this.atmIdString = atmIdString;
    }


}
