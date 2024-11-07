package com.spartan.esports.mess_comm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // Custom query method to check for duplicate messages based on title and authorId
    boolean existsByTitleAndAuthorId(String title, Long authorId);
}
