package mk.ukim.finki.emt.bankcontext.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.bankcontext.domain.dto.CreateUserDto;
import mk.ukim.finki.emt.bankcontext.domain.model.Bank;
import mk.ukim.finki.emt.bankcontext.domain.model.BankId;
import mk.ukim.finki.emt.bankcontext.domain.model.User;
import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;
import mk.ukim.finki.emt.bankcontext.domain.repository.BankRepository;
import mk.ukim.finki.emt.bankcontext.services.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/bank")
@AllArgsConstructor
public class BankController {

    private final BankService bankService;
    private final BankRepository bankRepository;

    @GetMapping("/test")
    public void test(){
        bankRepository.save(new Bank(BankId.randomId(BankId.class), "Bank Name test " + bankRepository.findAll().size()));
    }

    @GetMapping("/{bankIdString}")
    public ResponseEntity<Bank> getBank(@PathVariable String bankIdString){
        BankId bankId = new BankId(bankIdString);
        return bankRepository.findById(bankId).map(x->ResponseEntity.ok().body(x)).orElseGet(()->ResponseEntity.notFound().build());
    }


    @GetMapping("/getBankUsers/{id}")
    public List<User> getBankUsers(@PathVariable String id){
        BankId bankId = new BankId(id);
        return bankRepository.findById(bankId).get().getUsers().stream().toList();
    }

    @GetMapping("/getAll")
    public List<Bank> getAll() {
        return bankService.getAll();
    }


    @PostMapping("/user")
    public void createUser(@RequestBody CreateUserDto createUserDto) {
        bankService.createUserInBank(createUserDto.bankIdString, createUserDto.name, createUserDto.surname, createUserDto.location, createUserDto.type);
    }

    @PostMapping("/userParams")
    public void createUser(@RequestParam String bankIdString,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String location,
                           @RequestParam UserType type) {
        bankService.createUserInBank(bankIdString, name, surname, location, type);
    }

    @PostMapping("/account")
    public void createUserAccount(@RequestParam String bankIdString,
                                  @RequestParam String userIdString) {
        bankService.createUserAccountInBank(bankIdString, userIdString);
    }

}
