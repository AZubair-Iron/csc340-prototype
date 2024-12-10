package com.spartan.esports.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);  // login

    Optional<User> findFirstByEmail(String email);  // prevent duplicated email registered
}
