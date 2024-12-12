package com.spartan.esports.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);  // login

    Optional<User> findFirstByEmail(String email);// prevent duplicated email registered

    List<User> findByStatus(String status);
}
