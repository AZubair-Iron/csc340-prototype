package com.spartan.esports.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
        User user = userService.login(email, password);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable int userId, @Valid @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(userId, userDetails.getName(), userDetails.getEmail(), userDetails.getMajor());
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserProfile(@PathVariable int userId) {
        User user = userService.getUserProfile(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
