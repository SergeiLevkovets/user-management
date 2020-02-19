package by.levkovets.usermanagement.services;

import by.levkovets.usermanagement.damain.Role;
import by.levkovets.usermanagement.damain.UserAccount;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserAccount findByUserName(String userName);

    UserAccount findById(Long id);

    void saveUser(UserAccount userAccount);

    List<UserAccount> filterByUserName(String userName);

    List<UserAccount> filterByRole(Role role);

    List<UserAccount> getAllUsers();

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
