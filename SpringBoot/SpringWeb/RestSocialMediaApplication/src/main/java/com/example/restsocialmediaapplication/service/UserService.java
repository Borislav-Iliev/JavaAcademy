package com.example.restsocialmediaapplication.service;

import com.example.restsocialmediaapplication.model.dto.UserDto;
import com.example.restsocialmediaapplication.model.entity.User;
import com.example.restsocialmediaapplication.model.error.ObjectNotFoundException;
import com.example.restsocialmediaapplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUserById(Long id) {
        return this.userRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User with id: " + id + " not found!"));
    }

    public User createUser(UserDto userDto) {
        User user = new User();

        user.setName(userDto.getName());
        user.setBirthDate(userDto.getBirthDate());

        this.userRepository.save(user);

        return user;
    }

    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }
}
