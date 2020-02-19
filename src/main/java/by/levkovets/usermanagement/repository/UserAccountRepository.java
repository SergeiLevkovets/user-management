package by.levkovets.usermanagement.repository;

import by.levkovets.usermanagement.damain.Role;
import by.levkovets.usermanagement.damain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByUserName(String userName);

    List<UserAccount> findAllByUserNameIsContaining(String userName);

    List<UserAccount> findAllByRole(Role role);


}
