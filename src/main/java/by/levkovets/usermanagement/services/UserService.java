package by.levkovets.usermanagement.services;

import by.levkovets.usermanagement.damain.Role;
import by.levkovets.usermanagement.damain.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserAccount findByUserName(String userName);

    UserAccount findById(Long id);

    void saveUser(UserAccount userAccount);

    Page<UserAccount> filterByRoleAndUserName(Role role, String userName, Pageable pageable);

    Page<UserAccount> filterByUserName(String userName, Pageable pageable);

    Page<UserAccount> filterByRole(Role role, Pageable pageable);

    Page<UserAccount> getAllUsers(Pageable pageable);

}
