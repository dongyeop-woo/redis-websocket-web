package com.chatting.chatting.service;

import com.chatting.chatting.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO setUser(UserDTO userDTO);
    List<UserDTO> findAllUser();
    Optional<UserDTO> findUserByName(String nickname);
}
