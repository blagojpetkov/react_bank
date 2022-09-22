package mk.ukim.finki.emt.bankcontext.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.bankcontext.domain.valueobjects.AccountId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
public class Bank extends AbstractEntity<BankId> {
    private String name;
    private int transactionCount;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

    public Bank(BankId id, String name) {
        super(id);
        this.name = name;
        this.transactionCount = 0;
    }

    public Bank() {
        super(BankId.randomId(BankId.class));
        this.name = "Test name bank";
        this.transactionCount = 0;
    }

    public void updateTransactionCount(){
        this.transactionCount++;
    }

    public User createNewUser(String name, String surname, String location, UserType type){
        User user = new User(name, surname, location, type);
        users.add(user);
        return user;
    }

    public boolean createNewUserAccount(UserId userId, Long accountNumber){
        User user = users.stream().filter(x->x.getId().getId().equals(userId.getId())).findFirst().orElseThrow(() -> new RuntimeException("UserId does not exist in this bank"));
        if(user.accountNumbers.size()<5){
            user.accountNumbers.add(accountNumber);
            return true;
        }
        return false;
    }

}
