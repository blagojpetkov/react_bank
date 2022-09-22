package mk.ukim.finki.emt.bankcontext.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.bankcontext.domain.valueobjects.AccountId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Table(name = "bank_users")
public class User extends AbstractEntity<UserId> {
    private String name;
    private String surname;
    private String location;
    private UserType type;

    @ElementCollection(fetch = FetchType.EAGER)
//    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    Set<Long> accountNumbers = new HashSet<>();

    public User(String name, String surname, String location, UserType type) {
        super(UserId.randomId(UserId.class));
        this.name = name;
        this.surname = surname;
        this.location = location;
        this.type = type;
    }

    public User() {
        super(UserId.randomId(UserId.class));
    }
}
