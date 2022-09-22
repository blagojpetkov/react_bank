package mk.ukim.finki.emt.transactioncontext.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;
@Embeddable
public class BankId extends DomainObjectId {

    private BankId() {
        super(BankId.randomId(BankId.class).getId());
    }

    public BankId(String uuid) {
        super(uuid);
    }
}
