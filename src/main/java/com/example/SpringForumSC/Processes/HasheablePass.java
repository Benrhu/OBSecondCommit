package com.example.SpringForumSC.Processes;

import org.springframework.context.annotation.Bean;

public interface HasheablePass {

    String passHash(String password);

    boolean passwordVerification(String hash, String password);
}
