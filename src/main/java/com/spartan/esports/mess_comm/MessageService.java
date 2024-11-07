package com.spartan.esports.mess_comm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(Long messId) {
        return messageRepository.findById(messId).orElse(null);
    }

    public Message createMessage(Message message) {
        // Check if the message with the same title and author already exists
        if (messageRepository.existsByTitleAndAuthorId(message.getTitle(), message.getAuthorId())) {
            return null; // Or handle as needed
        }
        message.setTimePosted(LocalDateTime.now()); // Automatically set the timestamp
        return messageRepository.save(message);
    }

    public Message updateMessage(Long messId, Message message) {
        Message existingMessage = messageRepository.findById(messId).orElse(null);
        if (existingMessage != null) {
            existingMessage.setTitle(message.getTitle());
            existingMessage.setDescription(message.getDescription());
            existingMessage.setAuthorId(message.getAuthorId());
            return messageRepository.save(existingMessage);
        }
        return null;
    }

    public void deleteMessage(Long messId) {
        messageRepository.deleteById(messId);
    }
}
