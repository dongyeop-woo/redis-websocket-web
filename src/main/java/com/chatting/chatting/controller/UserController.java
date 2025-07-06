package com.chatting.chatting.controller;

import com.chatting.chatting.dto.UserDTO;
import com.chatting.chatting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.setUser(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAllUser() {
        List<UserDTO> userDTOList = userService.findAllUser();
        return ResponseEntity.ok(userDTOList);
    }

    @GetMapping("/{nickname}")
    public ResponseEntity<UserDTO> findUserByNickname(@PathVariable String nickname) {
        Optional<UserDTO> userDTOOptional = userService.findUserByName(nickname);
        return userDTOOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
