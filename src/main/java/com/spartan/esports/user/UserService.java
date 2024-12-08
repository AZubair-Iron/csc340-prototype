package com.spartan.esports.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;

import jakarta.validation.Valid;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public User registerUser(@Valid User user) {
        logger.info("Attempting to register user with email: {}", user.getEmail());

        // Check for email uniqueness
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            logger.warn("Email {} already exists", user.getEmail());
            throw new RuntimeException("Email already exists");
        }

        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAccountStatus(AccountStatus.ACTIVE); // Or set a default status

        return userRepository.save(user);
    }


    @Transactional(readOnly = true)
    public User login(String email, String password) {
        logger.info("Attempting to login with email: {}", email);

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            logger.warn("Login attempt failed for email: {}", email);
            throw new AuthenticationException("User not found");
        }

        User user = optionalUser.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            logger.warn("Invalid password for email: {}", email);
            throw new AuthenticationException("Invalid credentials");
        }

        return user;
    }


    @Transactional
    public User updateUser(int userId, String name, String email, String major) {
        logger.info("Attempting to update user with ID: {}", userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(name);
        user.setEmail(email);
        user.setMajor(major);

        return userRepository.save(user);
    }


    @Transactional
    public void deleteUser(int userId) {
        logger.info("Attempting to delete user with ID: {}", userId);

        userRepository.deleteById(userId);
    }


    @Transactional(readOnly = true)
    public User getUserProfile(int userId) {
        logger.info("Fetching profile for user with ID: {}", userId);

        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
