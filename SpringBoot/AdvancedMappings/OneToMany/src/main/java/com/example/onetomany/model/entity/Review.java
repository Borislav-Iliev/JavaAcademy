package com.example.onetomany.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comment;

    public Review() {
    }

    public Review(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public Review setId(Long id) {
        this.id = id;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Review setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
