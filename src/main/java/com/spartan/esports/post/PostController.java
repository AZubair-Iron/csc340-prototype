package com.spartan.esports.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public String getAllPosts(Model model) {
        model.addAttribute("postList", postService.getAllPosts());
        return "discussion/post-list";
    }

    @GetMapping("/{id}")
    public String getOnePost(@PathVariable int id, Model model) {
        model.addAttribute("post", postService.getById(id));
        return "discussion/postdetails";
    }

    @GetMapping("/createForm")
    public String showCreateForm(){
        return "discussion/new-post";
    }
    @PostMapping("/new")
    public String addNewPost(Post post) {
        postService.savePost(post);
        return "redirect:/posts/all";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model){
        model.addAttribute("animal", postService.getById(id));
        return "discussion/edit-post";
    }
    @PostMapping("/update")
    public String updateAnimal(Post post) {
        postService.savePost(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteAnimalById(@PathVariable int id) {
        postService.deletePostById(id);
        return "redirect:/posts/all";
    }


}
