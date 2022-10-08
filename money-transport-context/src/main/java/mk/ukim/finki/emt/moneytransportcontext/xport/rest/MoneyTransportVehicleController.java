package mk.ukim.finki.emt.moneytransportcontext.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.moneytransportcontext.domain.models.MoneyTransportVehicle;
import mk.ukim.finki.emt.moneytransportcontext.domain.repository.MoneyTransportVehicleRepository;
import mk.ukim.finki.emt.moneytransportcontext.domain.valueobjects.BankId;
import mk.ukim.finki.emt.moneytransportcontext.services.MoneyTransportVehicleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/moneytransport")
@CrossOrigin
@AllArgsConstructor
public class MoneyTransportVehicleController {

    private final MoneyTransportVehicleService service;
    private final MoneyTransportVehicleRepository repository;
    @GetMapping("/test")
    public void test(){
        BankId bankId = new BankId("3f6f173b-009a-410a-8188-9effa8327ce6");
        repository.save(new MoneyTransportVehicle(bankId, "Some location"));
    }

    @GetMapping("/getAll")
    public List<MoneyTransportVehicle> getAllVehicles(){
        return service.findAll();
    }

}
