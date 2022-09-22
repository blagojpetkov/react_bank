package mk.ukim.finki.emt.transactioncontext.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class TransactionId extends DomainObjectId {
    private TransactionId() {
        super(TransactionId.randomId(TransactionId.class).getId());
    }

    public TransactionId(@NonNull String uuid) {
        super(uuid);
    }
}
