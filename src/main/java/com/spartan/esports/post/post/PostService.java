package com.spartan.esports.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepo;
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public Post getById(int id) {
        return postRepo.findById(id).orElse(null);
    }


    public void savePost(Post post) {
        postRepo.save(post);
    }

    public void deletePostById(int id) {
        postRepo.deleteById(id);
    }

}
