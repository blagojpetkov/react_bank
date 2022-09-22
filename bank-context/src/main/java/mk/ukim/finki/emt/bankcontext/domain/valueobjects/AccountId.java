package mk.ukim.finki.emt.bankcontext.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

public class AccountId extends DomainObjectId {

    private AccountId() {
        super(AccountId.randomId(AccountId.class).getId());
    }

    public AccountId(String uuid) {
        super(uuid);
    }
}
