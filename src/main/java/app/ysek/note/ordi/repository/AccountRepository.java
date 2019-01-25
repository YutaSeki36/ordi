package app.ysek.note.ordi.repository;

import app.ysek.note.ordi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByEmail(String email);
}
