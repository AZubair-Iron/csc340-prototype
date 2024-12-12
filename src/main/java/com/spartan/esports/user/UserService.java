package com.spartan.esports.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public User registerUser(String name, String email, String password){
        if (email == null || password == null) {
            return null;
        } else {
            if (userRepo.findFirstByEmail(email).isPresent()) {
                System.out.println("Duplicate Email");
                return null;
            }
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setStatus("PENDING");
            return userRepo.save(user);
        }
    }

    public User authenticate(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password).orElse(null);
    }

    public User getUserById(int userId){ return userRepo.findById(userId).orElse(null); }

    public List<User> getUserByStatus(String status) { return userRepo.findByStatus(status); }

    public List<User> getAllUsers() { return userRepo.findAll(); }

    public void updateUserStatus(Integer userId, String status) {
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + userId));
        user.setStatus(status);
        userRepo.save(user);
    }

    public void deleteUserById(Integer userId) {
        userRepo.deleteById(userId);
    }
}
