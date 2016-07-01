package co.za.codecol.emusic.service;


import co.za.codecol.emusic.domain.Account;
import co.za.codecol.emusic.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Collections;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Account save(Account account) {
            account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.save(account);
        return account;
    }

    @Transactional
    public Account updateAccount(Account account) {
        Account accountFromView = account;
        account = findOneByEmail(account.getEmail());
        if(account == null){
            throw new UsernameNotFoundException("email does not found");
        }
        accountFromView.setId(account.getId());
        accountFromView.setPassword(account.getPassword());
        accountFromView.setCreated(account.getCreated());
        accountRepository.save(accountFromView);
        return account;
    }

    @Transactional
    public Account updatePassword(Account account, String oldPaas,String newPassword) {
        account = findOneByEmail(account.getEmail());
        if(account == null){
            throw new UsernameNotFoundException("email does not found");
        }

        if(isOldPasswordCorrect(oldPaas, account.getId())){
            account.setPassword(passwordEncoder.encode(newPassword));
            accountRepository.save(account);
        }
        return account;
    }

    private boolean isOldPasswordCorrect(String oldPassword, Long userId){
        Account account = findOne(userId);
        if(account != null){
            account.getPassword().equals(passwordEncoder.encode(oldPassword));
            return true;
        }
        return false;
    }

    public Account findOneByEmail(String email) {
        return accountRepository.findOneByEmail(email);
    }

    public Account findOne(Long id) {
        return accountRepository.findOne(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findOneByEmail(username);
        if (account == null) {
            throw new UsernameNotFoundException("user not found");
        }
        return createUser(account);
    }

    public void signin(Account account) {
        SecurityContextHolder.getContext().setAuthentication(authenticate(account));
    }

    private Authentication authenticate(Account account) {
        return new UsernamePasswordAuthenticationToken(createUser(account), null, Collections.singleton(createAuthority(account)));
    }

    private User createUser(Account account) {
        return new User(account.getEmail(), account.getPassword(), Collections.singleton(createAuthority(account)));
    }

    private GrantedAuthority createAuthority(Account account) {
        return new SimpleGrantedAuthority(account.getRole());
    }

}
