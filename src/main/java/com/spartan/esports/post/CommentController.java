package com.spartan.esports.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @GetMapping("/comment")
    public String getComment() {
        return "discussion/comment";
    }

    @GetMapping("/privacy")
    public String privacy() {
        return "privacy";
    }
    @GetMapping("/services")
    public String termServices() {
        return "terms-of-services";
    }
}
