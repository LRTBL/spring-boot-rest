package com.lrtbl.helloworld.rest.services;


import com.lrtbl.helloworld.rest.entities.User;
import com.lrtbl.helloworld.rest.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springfox.documentation.annotations.Cacheable;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public Page<User> getUsers (Integer page, Integer size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

    public User getUserById (Integer userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found", userId)));
    }

    @Cacheable("users")
    public User getUserByUsername (String username) {
        return userRepository.findByUsername(username).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not found", username)));
    }

    @CacheEvict("users")
    public void deleteUserByUsername (String username) {
        User user = getUserByUsername(username);
        userRepository.delete(user);
    }

    public User getUserByUsernameAndPassword (String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User by %s not found", username)));
    }

    public Page<User>   getUsernames(Integer page, Integer size) {
        return userRepository.findUsernames(PageRequest.of(page, size));
    }
}
