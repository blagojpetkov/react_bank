package mk.ukim.finki.emt.bankcontext.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class BankId extends DomainObjectId {
    private BankId() {
        super(BankId.randomId(BankId.class).getId());
    }

    public BankId(@NonNull String uuid) {
        super(uuid);
    }
}
