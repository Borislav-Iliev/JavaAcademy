package com.example.restsocialmediaapplication.service;

import com.example.restsocialmediaapplication.model.dto.PostDto;
import com.example.restsocialmediaapplication.model.entity.Post;
import com.example.restsocialmediaapplication.model.entity.User;
import com.example.restsocialmediaapplication.repository.PostRepository;
import com.example.restsocialmediaapplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<PostDto> getAllPostsForUser(Long id) {
        return this.postRepository.getPostsByUserId(id);
    }

    public Post createPost(Long userId, PostDto postDto) {
        Post post = new Post();

        User user = this.userRepository.findById(userId).orElseThrow();

        post.setDescription(postDto.getDescription())
                .setUser(user);

        return this.postRepository.save(post);
    }
}
