package by.levkovets.usermanagement.services;

import by.levkovets.usermanagement.damain.Role;
import by.levkovets.usermanagement.damain.UserAccount;
import by.levkovets.usermanagement.repository.UserAccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserAccountRepository userAccountRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserAccountRepository userAccountRepository, PasswordEncoder passwordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public UserAccount findByUserName(String userName) {
        UserAccount byUserAccountName = userAccountRepository.findByUserName(userName);
        return byUserAccountName;
    }

    @Override
    public UserAccount findById(Long id) {
        UserAccount userAccount = userAccountRepository.findById(id).get();
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        return userAccount;
    }

    @Override
    public List<UserAccount> filterByUserName(String userName) {
        List<UserAccount> list = userAccountRepository.findAllByUserNameIsContaining(userName);
        return list;
    }

    @Override
    public List<UserAccount> filterByRole(Role role) {
        List<UserAccount> list = userAccountRepository.findAllByRole(role);
        return list;
    }

    @Override
    public void saveUser(UserAccount userAccount){

        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));

        userAccountRepository.save(userAccount);
    }

    @Override
    public void updateUser(UserAccount userAccount){
        userAccountRepository.save(userAccount);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }

    @Override
    public void registerUser(UserAccount userAccount){

        userAccount.setActive(true);

        userAccount.setRole(Role.ROLE_USER);

        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));

        userAccountRepository.save(userAccount);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findByUserName(username);

        if (userAccount == null){
            throw new UsernameNotFoundException("User not fount");
        }

        return new org.springframework.security.core.userdetails.User(userAccount.getUsername(),
                userAccount.getPassword(), userAccount.getAuthorities());
    }
}
