package com.example.SpringForumSC.Processes;

import org.springframework.stereotype.Component;

@Component
public class HasheablePassImpl implements HasheablePass{

    @Override
    public String passHash(String password) {
        return null;
    }

    @Override
    public boolean passwordVerification(String hash, String password) {
        return false;
    }
}
