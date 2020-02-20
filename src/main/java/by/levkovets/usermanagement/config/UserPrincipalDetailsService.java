package by.levkovets.usermanagement.config;

import by.levkovets.usermanagement.config.UserPrincipal;
import by.levkovets.usermanagement.damain.UserAccount;
import by.levkovets.usermanagement.repository.UserAccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private final UserAccountRepository userAccountRepository;

    public UserPrincipalDetailsService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findByUserName(username);

        if (userAccount == null){
            throw new UsernameNotFoundException("User not fount");
        }

        UserPrincipal userPrincipal = new UserPrincipal(userAccount);

        return userPrincipal;
    }

}
