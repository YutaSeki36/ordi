package app.ysek.note.ordi.service;

import app.ysek.note.ordi.domain.Account;
import app.ysek.note.ordi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Account create(Account account, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        account.setPassword(encodedPassword);
        return accountRepository.save(account);
    }
}
