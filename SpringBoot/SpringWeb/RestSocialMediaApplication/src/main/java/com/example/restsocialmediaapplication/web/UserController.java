package com.example.restsocialmediaapplication.web;

import com.example.restsocialmediaapplication.model.dto.UserDto;
import com.example.restsocialmediaapplication.model.entity.User;
import com.example.restsocialmediaapplication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity
                .ok(this.userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return ResponseEntity
                .ok(this.userService.getUserById(id));
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userDto) {
        User user = this.userService.createUser(userDto);

        return ResponseEntity
                .created(URI.create("/users/" + user.getId()))
                .body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
        UserDto deletedUser = this.userService.getUserById(id);

        this.userService.deleteById(id);

        return ResponseEntity.ok(deletedUser);
    }
}
