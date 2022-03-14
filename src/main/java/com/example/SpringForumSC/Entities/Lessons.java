package com.example.SpringForumSC.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "lessons")
public class Lessons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn(name = "lessonsId")
    private Long lessonsId;


}
