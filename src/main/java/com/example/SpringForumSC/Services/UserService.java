package com.example.SpringForumSC.Services;

import com.example.SpringForumSC.Entities.User;
import com.example.SpringForumSC.Processes.HasheablePass;
import com.example.SpringForumSC.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Data
@AllArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    private List<User> users;

    private HasheablePass encode;

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

    public List<User> findAll(){ return userRepository.findAll(); }

}
