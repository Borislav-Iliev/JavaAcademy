package com.example.manytomany.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "youtube_channel", nullable = false)
    private String youtubeChannel;

    @Column(nullable = false)
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor instructor;

    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public InstructorDetail setId(Long id) {
        this.id = id;
        return this;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public InstructorDetail setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
        return this;
    }

    public String getHobby() {
        return hobby;
    }

    public InstructorDetail setHobby(String hobby) {
        this.hobby = hobby;
        return this;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public InstructorDetail setInstructor(Instructor instructor) {
        this.instructor = instructor;
        return this;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
