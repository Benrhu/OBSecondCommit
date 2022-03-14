package com.example.SpringForumSC.Services;

import com.example.SpringForumSC.Entities.User;
import com.example.SpringForumSC.Processes.HasheablePass;
import com.example.SpringForumSC.Repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterService implements UserRepository {

    private List<User> users;
    private HasheablePass encode;

    public RegisterService(List<User> users, HasheablePass encode){
        this.encode = encode;
        this.users = users;
    }

    public boolean register(String email, String password){
        String passHashed;
        if (this.vf(email)){
            if (!this.lde(email)){
                if (encode.passHash(password) != null){
                    passHashed = encode.passHash(password);
                    User user = new User(null, email, null, null, null, null);
                    this.users.add(user);
                    System.out.println("Usuario:" + email + " | Password: " + password + " almacenado con exito");
                    System.out.println("El hash es: " + passHashed);
                    System.out.println("Encriptación: " + encode.getClass().getSimpleName());
                }else{
                    System.err.println("Error al hashear el password.");
                }
            }
        }
        return false;
    }

    // Verifying format
    public boolean vf(String email) {
        Pattern emailPatt = Pattern.compile("^[a-zA-Z0-9_\\-\\.]+@([a-zA-Z0-9]+)(\\.)[a-zA-Z0-9]+$");
        Matcher emailMatch = emailPatt.matcher(email);

        if (emailMatch.matches()){
            return true;
        }
        System.err.println("Bad format email. Please, introduce a valid email.");
        return false;
    }

    // Looking for Duplicated Emails function
    public boolean lde(String email) {
        for (User user : this.users) {
            if (user.getEmail().equals(email)) {
                System.err.println("This email already exists in our database.");
                return true;
            }
        }
        return false;
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
