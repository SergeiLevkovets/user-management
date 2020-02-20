package by.levkovets.usermanagement.services;

import by.levkovets.usermanagement.damain.Role;
import by.levkovets.usermanagement.damain.UserAccount;
import by.levkovets.usermanagement.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDTO findByUserName(String userName);

    UserDTO findById(Long id);

    Page<UserAccount> filterByRoleAndUserName(Role role, String userName, Pageable pageable);

    Page<UserAccount> filterByUserName(String userName, Pageable pageable);

    Page<UserAccount> filterByRole(Role role, Pageable pageable);

    Page<UserAccount> getAllUsers(Pageable pageable);

    void saveUser(UserDTO userAccount);
}
