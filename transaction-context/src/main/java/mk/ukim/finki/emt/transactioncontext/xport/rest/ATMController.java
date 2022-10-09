package mk.ukim.finki.emt.transactioncontext.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.transactioncontext.domain.models.ATM;
import mk.ukim.finki.emt.transactioncontext.domain.models.ATMId;
import mk.ukim.finki.emt.transactioncontext.domain.models.Account;
import mk.ukim.finki.emt.transactioncontext.domain.repository.ATMRepository;
import mk.ukim.finki.emt.transactioncontext.domain.repository.AccountRepository;
import mk.ukim.finki.emt.transactioncontext.domain.valueobjects.BankId;
import mk.ukim.finki.emt.transactioncontext.services.ATMService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/atm")
@AllArgsConstructor
public class ATMController {
    private final ATMService atmService;
    private final AccountRepository accountRepository;



    @GetMapping("/addATM")
    public void addATM(@RequestParam String location, @RequestParam String bankIdString){
        atmService.save(location, new BankId(bankIdString));
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String ATMIdString,
            @RequestParam Long accountNumber,
            @RequestParam String password
    ){
        try{
            atmService.login(ATMIdString, accountNumber, password);
        }
        catch (RuntimeException exception){
            return ResponseEntity.ok().body(exception.getMessage());
        }
        return ResponseEntity.ok().body("Success");

    }

    @GetMapping("/balance")
    public ResponseEntity<Double> getBalance(@RequestParam Long accountNumber){
        return accountRepository.findByAccountNumber(accountNumber)
                .map(x->ResponseEntity.ok().body(x.getAccountBalance().getAmount())).orElseGet(()->ResponseEntity.notFound().build());

    }

    @GetMapping("/getAll")
    public List<ATM> getAll(){
        return atmService.findAll();
    }

    @GetMapping("/get/{atmIdString}")
    public ResponseEntity<ATM> get(@PathVariable String atmIdString){
        ATMId atmId = new ATMId(atmIdString);
        return atmService.findById(atmId).map(x->ResponseEntity.ok().body(x)).orElseGet(()->ResponseEntity.notFound().build());
    }


    @GetMapping("/withdraw")
    public ResponseEntity<String> withdrawMoney(@RequestParam String ATMIdString,
                              @RequestParam Long accountNumber,
                              @RequestParam String password,
                              @RequestParam Double amount){
        try{
            atmService.withdrawMoney(ATMIdString, accountNumber, password, amount);
        }
        catch (RuntimeException exception){
                return ResponseEntity.ok().body(exception.getMessage());
        }
        return ResponseEntity.ok().body("Money withdrawal is successful");
    }

    @GetMapping("/deposit")
    public ResponseEntity<String> depositMoney(@RequestParam String ATMIdString,
                             @RequestParam Long accountNumber,
                             @RequestParam String password,
                             @RequestParam Double amount){
        try{
            atmService.depositMoney(ATMIdString, accountNumber, password, amount);
        }
            catch (RuntimeException exception){
            return ResponseEntity.ok().body(exception.getMessage());
        }
            return ResponseEntity.ok().body("Money deposit is successful");
        }
}
