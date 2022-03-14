package com.example.SpringForumSC.Processes;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class Argon2Hash implements HasheablePass{

    Argon2 argon2 = Argon2Factory.create();

    @Override
    public String passHash(String password) {
        String hash = null;
        char[] passArray = password.toCharArray();
        try{
            hash = this.argon2.hash(10, 55555,1, passArray);
        }catch (Exception e){
            System.out.println("Something Wrong while hashing: " + e.getMessage());
        }finally {
            this.argon2.wipeArray(passArray);
        }
        return hash;
    }

    @Override
    public boolean passwordVetification(String hash, String password) {
        return false;
    }

    public Argon2 getArgon2() {
        return argon2;
    }

    public void setArgon2(Argon2 argon2) {
        this.argon2 = argon2;
    }
}
