package com.example.ticket.mapper;


import com.example.ticket.dto.UserDTO;
import com.example.ticket.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserDTO toDtoUser(User user);

	User toModelUser(UserDTO userDTO);

	List<UserDTO> toDtoListUser(List<User> list);

	List<User> toUserList(List<UserDTO> list);
}
