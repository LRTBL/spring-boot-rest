package com.lrtbl.helloworld.rest.controllers;

import com.lrtbl.helloworld.rest.dto.UserDTO;
import com.lrtbl.helloworld.rest.dto.UserResponseDTO;
import com.lrtbl.helloworld.rest.entities.User;
import com.lrtbl.helloworld.rest.services.UserService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final ModelMapper modelMapper;


  @GetMapping()
  @Timed("get.users")
  public ResponseEntity<Page<User>> getUsers(
          @RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
          @RequestParam(required = false, value = "size", defaultValue = "10000") Integer size) {
    return new ResponseEntity<>(userService.getUsers(page, size), HttpStatus.OK);
  }
  @GetMapping("/usernames")
    public ResponseEntity<Page<UserResponseDTO>> getUsernames (
      @RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
      @RequestParam(required = false, value = "size", defaultValue = "10000") Integer size
    ) {
      Page<User> user = userService.getUsernames(page, size);
      Page<UserResponseDTO> userDTOS = user.map(this::convertToDTO);
      return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById  (@PathVariable("userId") Integer userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername (@PathVariable("username") String username) {
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> authenticate (@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.getUserByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword()), HttpStatus.OK);
    }

    private UserResponseDTO convertToDTO(User user) {
        return modelMapper.map(user, UserResponseDTO.class);
    }
}
