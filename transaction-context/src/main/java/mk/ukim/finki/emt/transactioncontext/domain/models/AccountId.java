package mk.ukim.finki.emt.transactioncontext.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class AccountId extends DomainObjectId {
    private AccountId() {
        super(AccountId.randomId(AccountId.class).getId());
    }

    public AccountId(@NonNull String uuid) {
        super(uuid);
    }
}
