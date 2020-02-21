package by.levkovets.usermanagement.services;

import by.levkovets.usermanagement.domain.Role;
import by.levkovets.usermanagement.domain.UserAccount;
import by.levkovets.usermanagement.dto.UserDTO;
import by.levkovets.usermanagement.mapper.UserAccountMapper;
import by.levkovets.usermanagement.repository.UserAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service class for User
 * */

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserAccountRepository userAccountRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserAccountMapper userAccountMapper;

    public UserServiceImpl(UserAccountRepository userAccountRepository, PasswordEncoder passwordEncoder, UserAccountMapper userAccountMapper) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
        this.userAccountMapper = userAccountMapper;
    }

    @Override
    public UserDTO findByUserName(String userName) {
        log.info("UserDto loading by userName...");

        UserAccount userAccount = userAccountRepository.findByUserName(userName);
        UserDTO userDTO = userAccountMapper.userToUserDTO(userAccount);

        log.info("In UserServiceImpl loaded By UserName {}", userName);

        return userDTO;
    }

    @Override
    public UserDTO findById(Long id) {
        log.info("UserDto loading by id...");

        UserAccount userAccount = userAccountRepository.findById(id).get();
        UserDTO userDTO = userAccountMapper.userToUserDTO(userAccount);

        log.info("In UserServiceImpl loaded By Id {}", id);

        return userDTO;
    }

    @Override
    public Page<UserAccount> filterByUserName(String userName, Pageable pageable) {
        log.info("UserAccount filtering by userName");

        Page<UserAccount> list = userAccountRepository.findAllByUserNameIsContaining(userName, pageable);

        log.info("In UserServiceImpl filtered by userName", userName);

        return list;
    }

    @Override
    public Page<UserAccount> filterByRole(Role role, Pageable pageable) {
        log.info("UserAccount filtering by Role");

        Page<UserAccount> list = userAccountRepository.findAllByRole(role, pageable);

        log.info("In UserServiceImpl filtered by role", role);

        return list;
    }

    @Override
    public Page<UserAccount> filterByRoleAndUserName(Role role, String userName, Pageable pageable) {
        log.info("UserAccount filtering by Role and userName");

        Page<UserAccount> list = userAccountRepository.findAllByRoleAndUserNameIsContaining(role, userName, pageable);

        log.info("In UserServiceImpl filtered by role and userName", role, userName);

        return list;
    }

    @Override
    public Page<UserAccount> getAllUsers(Pageable pageable) {
        log.info("UserAccount loading AllUsers...");

        Page<UserAccount> page = userAccountRepository.findAll(pageable);

        log.info("In UserServiceImpl loaded AllUsers");

        return page;
    }

    @Override
    public void saveUser(UserDTO userDTO){
        log.info("UserDto saving {}");

        UserAccount userAccount = userAccountMapper.UserDTOToUser(userDTO);

        if (passwordEncoder.upgradeEncoding(userAccount.getPassword())) {
            userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        }

        userAccountRepository.save(userAccount);

        log.info("In UserServiceImpl User saved ", userAccount);
    }

}
