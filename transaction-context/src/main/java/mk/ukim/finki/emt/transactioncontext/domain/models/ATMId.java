package mk.ukim.finki.emt.transactioncontext.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class ATMId extends DomainObjectId {
    private ATMId() {
        super(ATMId.randomId(ATMId.class).getId());
    }

    public ATMId(@NonNull String uuid) {
        super(uuid);
    }
}
