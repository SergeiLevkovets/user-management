package by.levkovets.usermanagement.services;

import by.levkovets.usermanagement.damain.Role;
import by.levkovets.usermanagement.damain.UserAccount;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {

    UserAccount findByUserName(String userName);

    UserAccount findById(Long id);

    List<UserAccount> filterByRoleAndUserName(Role role, String userName);

    void saveUser(UserAccount userAccount);

    List<UserAccount> filterByUserName(String userName);

    List<UserAccount> filterByRole(Role role);

    List<UserAccount> getAllUsers();

}
