package mk.ukim.finki.emt.moneytransportcontext.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.moneytransportcontext.domain.models.MoneyTransportVehicle;
import mk.ukim.finki.emt.moneytransportcontext.domain.repository.MoneyTransportVehicleRepository;
import mk.ukim.finki.emt.moneytransportcontext.domain.valueobjects.BankId;
import mk.ukim.finki.emt.moneytransportcontext.services.MoneyTransportVehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Transactional
@Service
public class MoneyTransportVehicleServiceImpl implements MoneyTransportVehicleService {
    private final MoneyTransportVehicleRepository repository;

    @Override
    public List<MoneyTransportVehicle> findAll() {
        return repository.findAll();
    }

    @Override
    public void refill(String atm) {
        Random random = new Random();
        int randomVehicleNumber = random.nextInt(repository.findAll().size());
        MoneyTransportVehicle vehicle = repository.findAll().get(randomVehicleNumber);
        //refilling atm with some vehicle
        System.out.println("Refilling ATM " + atm);
    }

    @Override
    public void save(String location, BankId bankId) {
        repository.save(new MoneyTransportVehicle(bankId, location));
    }
}
