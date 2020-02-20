package by.levkovets.usermanagement.mapper;

import by.levkovets.usermanagement.damain.UserAccount;
import by.levkovets.usermanagement.dto.UserDTO;

public interface UserAccountMapper {

        UserDTO userToUserDTO(UserAccount user);

        UserAccount UserDTOToUser(UserDTO userDTO);

}
