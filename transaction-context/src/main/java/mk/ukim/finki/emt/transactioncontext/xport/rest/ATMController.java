package mk.ukim.finki.emt.transactioncontext.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.transactioncontext.domain.models.ATM;
import mk.ukim.finki.emt.transactioncontext.domain.repository.ATMRepository;
import mk.ukim.finki.emt.transactioncontext.services.ATMService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/atm")
@AllArgsConstructor
public class ATMController {
    private final ATMService atmService;
    private final ATMRepository atmRepository;


    @GetMapping("/test")
    public void test(){
        atmRepository.save(new ATM());
    }

    @GetMapping("/getAll")
    public List<ATM> getAll(){
        return atmRepository.findAll();
    }

    @GetMapping("/withdraw")
    public void withdrawMoney(@RequestParam String accountIdString,
                              @RequestParam String ATMIdString,
                              @RequestParam Double money){
        atmService.withdrawMoney(accountIdString, ATMIdString, money);
    }

    @GetMapping("/deposit")
    public void depositMoney(@RequestParam String accountIdString,
                             @RequestParam String ATMIdString,
                             @RequestParam Double money){
        atmService.depositMoney(accountIdString, ATMIdString, money);
    }
}
