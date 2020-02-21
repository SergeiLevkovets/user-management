package by.levkovets.usermanagement.mapper;

import by.levkovets.usermanagement.damain.Role;
import by.levkovets.usermanagement.damain.UserAccount;
import by.levkovets.usermanagement.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Mapper class for {@link UserAccount} and {@link UserDTO}
 */

@Service
public class UserAccountMapperImpl implements UserAccountMapper {

    @Override
    public UserDTO userToUserDTO(UserAccount user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        if (user.getRole() != null) {
            userDTO.setRole(user.getRole().name());
        }
        userDTO.setActive(user.isActive());

        if (user.getCreatedAt() != null) {
            userDTO.setCreatedAt(new SimpleDateFormat().format(user.getCreatedAt()));
        }

        return userDTO;
    }

    @Override
    public UserAccount UserDTOToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        UserAccount userAccount = new UserAccount();
        userAccount.setId(userDTO.getId());
        userAccount.setUserName(userDTO.getUserName());
        userAccount.setPassword(userDTO.getPassword());
        userAccount.setFirstName(userDTO.getFirstName());
        userAccount.setLastName(userDTO.getLastName());
        if (userDTO.getRole() != null) {
            userAccount.setRole(Enum.valueOf(Role.class, userDTO.getRole()));
        }
        userAccount.setActive(userDTO.isActive());
        try {
            if (!userDTO.getCreatedAt().isEmpty() && userDTO.getCreatedAt() != null) {
                userAccount.setCreatedAt(new SimpleDateFormat().parse(userDTO.getCreatedAt()));
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return userAccount;
    }
}
