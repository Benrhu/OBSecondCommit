package com.example.SpringForumSC.Entities;

public enum Role {
    USER("User"),
    ADMIN("Admin");

    private String name;

    Role(String name){ this.name = name;}
}
