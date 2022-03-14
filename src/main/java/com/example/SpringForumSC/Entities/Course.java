package com.example.SpringForumSC.Entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "courses")
public class Course {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseId")
    private Long courseId;

    @Column
    private String title;

    public Course() {}

    public Course(Long courseId, String title) {
        this.courseId = courseId;
        this.title = title;
    }

    // private List<Lessons>(){}

}
