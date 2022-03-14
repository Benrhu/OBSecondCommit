package com.example.SpringForumSC.Entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User userId;

    @OneToOne(targetEntity = Lessons.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "lessonsId", referencedColumnName = "lessonsId")
    private Lessons lessons;

    private String content;

    private LocalDateTime creationDate;

    private LocalDateTime lastUpdate;

    public Comment() {}

    public Comment(Long commentId, User userId, Lessons lessons, String content, LocalDateTime creationDate, LocalDateTime lastUpdate) {
        this.commentId = commentId;
        this.userId = userId;
        this.lessons = lessons;
        this.content = content;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
    }

    private void createCommentTime(){
        this.creationDate = LocalDateTime.now();
    }

    private void updateCommentTime(){
        this.lastUpdate = LocalDateTime.now();
    }

}
