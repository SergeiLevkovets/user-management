package by.levkovets.usermanagement.repository;

import by.levkovets.usermanagement.domain.Role;
import by.levkovets.usermanagement.domain.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO interface for {@link UserAccount} class.
 * */

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByUserName(String userName);

    Page<UserAccount> findAllByUserNameIsContaining(String userName, Pageable pageable);

    Page<UserAccount> findAllByRoleAndUserNameIsContaining(Role role, String userName, Pageable pageable);

    Page<UserAccount> findAllByRole(Role role, Pageable pageable);

}
