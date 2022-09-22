package mk.ukim.finki.emt.moneytransportcontext.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.moneytransportcontext.domain.models.MoneyTransportVehicle;
import mk.ukim.finki.emt.moneytransportcontext.domain.repository.MoneyTransportVehicleRepository;
import mk.ukim.finki.emt.moneytransportcontext.services.MoneyTransportVehicleService;
import mk.ukim.finki.emt.moneytransportcontext.valueobjects.BankId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/moneytransport")
@AllArgsConstructor
public class MoneyTransportVehicleController {

    private final MoneyTransportVehicleRepository repository;
    @GetMapping("/test")
    public void test(){
        BankId bankId = new BankId("3f6f173b-009a-410a-8188-9effa8327ce6");
        repository.save(new MoneyTransportVehicle(bankId, "Some location"));
    }

}
