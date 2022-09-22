package mk.ukim.finki.emt.moneytransportcontext.domain.repository;

import mk.ukim.finki.emt.moneytransportcontext.domain.models.MoneyTransportVehicle;
import mk.ukim.finki.emt.moneytransportcontext.domain.models.MoneyTransportVehicleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyTransportVehicleRepository extends JpaRepository<MoneyTransportVehicle, MoneyTransportVehicleId> {
}
