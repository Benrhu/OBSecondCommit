package com.example.SpringForumSC.Entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@Table(name="users")
public class User {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String email;

    @Column
    private String password;
    @Column
    private String fullName;

    @Column
    private String userName;

    private enum role { USER, ADMIN, MODERATOR };

    @OneToOne(targetEntity = Course.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    private Course courseId;

    public User() {
    }
}
