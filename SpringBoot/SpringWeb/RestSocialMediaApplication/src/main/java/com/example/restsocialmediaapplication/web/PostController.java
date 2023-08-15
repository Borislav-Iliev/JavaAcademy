package com.example.restsocialmediaapplication.web;

import com.example.restsocialmediaapplication.model.dto.PostDto;
import com.example.restsocialmediaapplication.model.entity.Post;
import com.example.restsocialmediaapplication.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/users/{id}/posts")
    public ResponseEntity<List<PostDto>> getAllPostsForUser(@PathVariable Long id) {
        return ResponseEntity
                .ok(this.postService.getAllPostsForUser(id));
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@PathVariable Long id, @RequestBody @Valid PostDto postDto) {
        Post post = this.postService.createPost(id, postDto);

        return ResponseEntity
                .created( URI.create("/users/" + id + "/posts/" + post.getId()))
                .body(post);
    }
}
