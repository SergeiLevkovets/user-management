package by.levkovets.usermanagement.services;

import by.levkovets.usermanagement.damain.Role;
import by.levkovets.usermanagement.damain.UserAccount;
import by.levkovets.usermanagement.dto.UserDTO;
import by.levkovets.usermanagement.mapper.UserAccountMapper;
import by.levkovets.usermanagement.repository.UserAccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        UserAccount userAccount = userAccountRepository.findByUserName(userName);
        UserDTO userDTO = userAccountMapper.userToUserDTO(userAccount);
        return userDTO;
    }

    @Override
    public UserDTO findById(Long id) {
        UserAccount userAccount = userAccountRepository.findById(id).get();
        UserDTO userDTO = userAccountMapper.userToUserDTO(userAccount);
        return userDTO;
    }

    @Override
    public Page<UserAccount> filterByUserName(String userName, Pageable pageable) {
        Page<UserAccount> list = userAccountRepository.findAllByUserNameIsContaining(userName, pageable);
        return list;
    }

    @Override
    public Page<UserAccount> filterByRole(Role role, Pageable pageable) {
        Page<UserAccount> list = userAccountRepository.findAllByRole(role, pageable);
        return list;
    }

    @Override
    public Page<UserAccount> filterByRoleAndUserName(Role role, String userName, Pageable pageable) {
        Page<UserAccount> list = userAccountRepository.findAllByRoleAndUserNameIsContaining(role, userName, pageable);
        return list;
    }

    @Override
    public Page<UserAccount> getAllUsers(Pageable pageable) {
        return userAccountRepository.findAll(pageable);
    }

    @Override
    public void saveUser(UserDTO userDTO){

        UserAccount userAccount = userAccountMapper.UserDTOToUser(userDTO);

        if (passwordEncoder.upgradeEncoding(userAccount.getPassword())) {
            userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        }

        userAccountRepository.save(userAccount);
    }

}
