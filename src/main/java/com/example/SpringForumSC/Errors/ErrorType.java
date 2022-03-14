package com.example.SpringForumSC.Errors;

public enum ErrorType {
    DUPLICATED_EMAIL("Error, duplicated email in line: "),
    DUPLICATED_FULLNAME("Error, fullName duplicated in line: "),
    BAD_FORMAT("Error, line of file have a bad format. Line: ");

    private String description;

    ErrorType(String description) {
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

}

