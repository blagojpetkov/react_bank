package mk.ukim.finki.emt.sharedkernel.domain.events.account;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
@Getter
public class AccountCreated extends DomainEvent {
    private String bankIdString;
    private Long accountNumber;
    private String password;
    private UserType type;

    public AccountCreated() {
        super(TopicHolder.TOPIC_USER_ACCOUNT_CREATED);
    }

    public AccountCreated(String bankIdString, Long accountNumber, String password, UserType type) {
        super(TopicHolder.TOPIC_USER_ACCOUNT_CREATED);
        this.bankIdString = bankIdString;
        this.accountNumber = accountNumber;
        this.password = password;
        this.type = type;
    }
}
