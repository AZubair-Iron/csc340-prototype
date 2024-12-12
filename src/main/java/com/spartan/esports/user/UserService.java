package com.spartan.esports.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public User getUserById(int userId) {
        return userRepo.findById(userId).orElse(null);
    }

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
            return userRepo.save(user);
        }
    }

    public User authenticate(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password).orElse(null);
    }
}
