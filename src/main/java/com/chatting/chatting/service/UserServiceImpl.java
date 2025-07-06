package com.chatting.chatting.service;

import com.chatting.chatting.dto.UserDTO;
import com.chatting.chatting.entity.User;
import com.chatting.chatting.mapper.UserMapper;
import com.chatting.chatting.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserDTO setUser(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        User savedUser = userRepository.save(user);

        return userMapper.toUserDTO(savedUser);
    }

    @Override
    public List<UserDTO> findAllUser() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findUserByName(String nickname) {
        return userRepository.findByNickname(nickname)
                .map(userMapper::toUserDTO);
    }

}
