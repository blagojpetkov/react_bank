package mk.ukim.finki.emt.transactioncontext.domain.repository;

import mk.ukim.finki.emt.transactioncontext.domain.models.Account;
import mk.ukim.finki.emt.transactioncontext.domain.models.AccountId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, AccountId> {
    Optional<Account> findByAccountNumber(Long accountNumber);
}
