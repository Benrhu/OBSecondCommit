package com.example.SpringForumSC.Processes;

public interface HasheablePass {

    String passHash(String password);

    boolean passwordVerification(String hash, String password);
}
