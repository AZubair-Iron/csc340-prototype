package com.csc340.api_demo.mess_comm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService service;

    @GetMapping("/all")
    public List<Message> getAllMessages() {
        return service.getAllMessages();
    }

    @GetMapping("/{messId}")
    public Message getMessageById(@PathVariable int messId) {
        return service.getMessageById(messId);
    }

    @PostMapping("/new")
    public List<Message> addNewMessage(@RequestBody Message message) {
        service.addNewMessage(message);
        return service.getAllMessages();
    }

    @PutMapping("/update/{messId}")
    public Message updateMessage(@PathVariable int messId, @RequestBody Message message) {
        service.updateMessage(messId, message);
        return service.getMessageById(messId);
    }

    @DeleteMapping("/delete/{messId}")
    public List<Message> deleteMessageById(@PathVariable int messId) {
        service.deleteMessageById(messId);
        return service.getAllMessages();
    }
}
