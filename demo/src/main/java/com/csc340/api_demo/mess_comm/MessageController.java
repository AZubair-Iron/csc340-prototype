package com.csc340.api_demo.mess_comm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{messId}")
    public Message getMessageById(@PathVariable Long messId) {
        return messageService.getMessageById(messId);
    }

    @PostMapping("/new")
    public Message createMessage(@RequestBody Message message) {
        return messageService.createMessage(message);
    }

    @PutMapping("/update/{messId}")
    public Message updateMessage(@PathVariable Long messId, @RequestBody Message message) {
        return messageService.updateMessage(messId, message);
    }

    @DeleteMapping("/delete/{messId}")
    public void deleteMessage(@PathVariable Long messId) {
        messageService.deleteMessage(messId);
    }
}
