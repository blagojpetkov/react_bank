package mk.ukim.finki.emt.moneytransportcontext.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class MoneyTransportVehicleId extends DomainObjectId {
    private MoneyTransportVehicleId() {
        super(MoneyTransportVehicleId.randomId(MoneyTransportVehicleId.class).getId());
    }

    public MoneyTransportVehicleId(@NonNull String uuid) {
        super(uuid);
    }
}
