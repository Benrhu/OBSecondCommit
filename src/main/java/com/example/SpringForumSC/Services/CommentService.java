package com.example.SpringForumSC.Services;

import com.example.SpringForumSC.Entities.Comment;
import com.example.SpringForumSC.Entities.Lessons;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

public interface CommentService {

    List<Comment> findAll();

    Comment findById(@PathVariable Long commentId);
    Set<Comment> findLatest();
    Set<Comment> findByCreationDate();
    Set<Comment> findByUser(@PathVariable Long userId);
    Set<Comment> findByLesson(Lessons lessons);

    void save(Comment comment);
    void update(Comment comment);
    void delete(Comment comment);



}
