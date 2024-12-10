package com.spartan.esports.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User registerUser(String name, String email, String password){
        if (email == null && password == null) {
            return null;
        } else {
            if (userRepo.findFirstByLogin(email).isPresent()) {
                System.out.println("Duplicate Login");
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
