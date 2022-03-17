package com.example.SpringForumSC.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "questions")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn(name = "questionsId")
    private Long questionsId;

    @OneToOne(targetEntity = Category.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;

    @OneToOne(targetEntity = Lessons.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "lessonsId", referencedColumnName = "lessonsId")
    private Lessons lessons;

}
