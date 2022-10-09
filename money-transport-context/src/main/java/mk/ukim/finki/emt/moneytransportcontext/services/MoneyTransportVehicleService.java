package mk.ukim.finki.emt.moneytransportcontext.services;

import mk.ukim.finki.emt.moneytransportcontext.domain.models.MoneyTransportVehicle;
import mk.ukim.finki.emt.moneytransportcontext.domain.valueobjects.BankId;

import java.util.List;

public interface MoneyTransportVehicleService {
    List<MoneyTransportVehicle> findAll();
    void refill(String atm);
    void save(String location, BankId bankId);
}
