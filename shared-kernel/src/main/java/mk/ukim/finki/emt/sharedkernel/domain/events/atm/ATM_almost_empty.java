package mk.ukim.finki.emt.sharedkernel.domain.events.atm;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

@Getter
public class ATM_almost_empty extends DomainEvent {

    private String atmIdString;
    public ATM_almost_empty() {
        super(TopicHolder.TOPIC_ATM_ALMOST_EMPTY);
    }

    public ATM_almost_empty(String atmIdString) {
        super(TopicHolder.TOPIC_ATM_ALMOST_EMPTY);
        this.atmIdString = atmIdString;
    }


}
