package by.levkovets.usermanagement.mapper;

import by.levkovets.usermanagement.domain.UserAccount;
import by.levkovets.usermanagement.dto.UserDTO;

/**
 * Mapper class for UserAccount and UserDto
 * */

public interface UserAccountMapper {

        UserDTO userToUserDTO(UserAccount user);

        UserAccount UserDTOToUser(UserDTO userDTO);

}
