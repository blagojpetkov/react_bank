package mk.ukim.finki.emt.moneytransportcontext.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.moneytransportcontext.domain.models.MoneyTransportVehicle;
import mk.ukim.finki.emt.moneytransportcontext.domain.repository.MoneyTransportVehicleRepository;
import mk.ukim.finki.emt.moneytransportcontext.domain.valueobjects.BankId;
import mk.ukim.finki.emt.moneytransportcontext.services.MoneyTransportVehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moneytransport")
@CrossOrigin
@AllArgsConstructor
public class MoneyTransportVehicleController {

    private final MoneyTransportVehicleService service;

    @GetMapping("/addVehicle")
    public void addVehicle(@RequestParam String location, @RequestParam String bankIdString){
        service.save(location, new BankId(bankIdString));
    }

    @GetMapping("/getAll")
    public List<MoneyTransportVehicle> getAllVehicles(){
        return service.findAll();
    }

}
