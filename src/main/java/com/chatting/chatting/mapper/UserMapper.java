package com.chatting.chatting.mapper;

import com.chatting.chatting.dto.UserDTO;
import com.chatting.chatting.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);
}
