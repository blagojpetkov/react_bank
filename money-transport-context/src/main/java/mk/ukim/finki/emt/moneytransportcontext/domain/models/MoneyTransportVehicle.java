package mk.ukim.finki.emt.moneytransportcontext.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.moneytransportcontext.domain.valueobjects.BankId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
public class MoneyTransportVehicle extends AbstractEntity<MoneyTransportVehicleId> {

    @AttributeOverride(name = "id", column = @Column(name = "bank_id", nullable = false))
    private BankId bankId;
    private String location;

    public MoneyTransportVehicle(BankId bankId, String location) {
        super(MoneyTransportVehicleId.randomId(MoneyTransportVehicleId.class));
        this.bankId = bankId;
        this.location = location;
    }

    public MoneyTransportVehicle() {
        super(MoneyTransportVehicleId.randomId(MoneyTransportVehicleId.class));
    }
}
