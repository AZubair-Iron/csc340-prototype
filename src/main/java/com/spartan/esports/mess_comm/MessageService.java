package com.csc340.api_demo.mess_comm;

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

    public Message getMessageById(int messId) {
        return messageRepository.findById(messId).orElse(null);
    }

    public List<Message> getMessageByTitle(String title) {
        return messageRepository.getMessageByTitle(title);
    }

    public void addNewMessage(Message message) {
        messageRepository.save(message);
    }

    public void updateMessage(int messId, Message message) {
        Message existing = getMessageById(messId);
        existing.setTitle(message.getTitle());
        existing.setDescription(message.getDescription());
        existing.setAuthorId(message.getAuthorId());
        existing.setTimePosted(message.getTimePosted());

        messageRepository.save(existing);
    }

    public void deleteMessageById(int messId) {
        messageRepository.deleteById(messId);
    }
}
