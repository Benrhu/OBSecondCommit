package com.example.SpringForumSC.Processes;

public interface HasheablePass {

    String passHash(String password);

    boolean passwordVetification(String hash, String password);
}
