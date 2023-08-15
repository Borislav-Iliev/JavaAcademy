package com.example.restsocialmediaapplication.repository;

import com.example.restsocialmediaapplication.model.dto.PostDto;
import com.example.restsocialmediaapplication.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT new com.example.restsocialmediaapplication.model.dto.PostDto " +
            "(p.description)" +
            " FROM Post p" +
            " WHERE p.user.id = :id")
    List<PostDto> getPostsByUserId(Long id);
}
