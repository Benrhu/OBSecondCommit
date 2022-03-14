package com.example.SpringForumSC.Services;

import com.example.SpringForumSC.Entities.User;
import com.example.SpringForumSC.Processes.HasheablePass;

import java.util.ArrayList;
import java.util.List;

public class LoginService {
    private List<User> users;
    private HasheablePass encode;

    public LoginService(List<User> users, HasheablePass encode) {
        this.users = users;
        this.encode = encode;
    }

    public int Login(String email, String password){
        int resultado = - 1;
        if(this.emailExists(email) != null){
            if (this.encode.passwordVerification(this.hashed(email), password)){
                return 1;
            }
            return -2;
        }
        return resultado;
    }

    // Verify if email already exists
    public User emailExists(String email){
        for (User user : this.users){
            if(user.getEmail().equals(email));
        }
        return null;
    }

    public String hashed(String email){
        User user = this.emailExists(email);
        return  user.getPassword();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public HasheablePass getEncode() {
        return encode;
    }

    public void setEncode(HasheablePass encode) {
        this.encode = encode;
    }
}
