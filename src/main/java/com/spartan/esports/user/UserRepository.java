package com.spartan.esports.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :hashedPassword")
    Optional<User> findByEmailAndHashedPassword(@Param("email") String email, @Param("hashedPassword") String hashedPassword);


    Page<User> findByAccountStatus(AccountStatus accountStatus, Pageable pageable);


    Page<User> findAllByEmailContaining(String email, Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.name = :name, u.email = :email, u.major = :major WHERE u.userId = :userId")
    void updateUser(@Param("userId") int userId, @Param("name") String name, @Param("email") String email, @Param("major") String major);

    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.email = :email")
    void deleteByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u JOIN u.events e WHERE e = :eventId")
    List<User> findUsersByEventId(@Param("eventId") String eventId);
}
