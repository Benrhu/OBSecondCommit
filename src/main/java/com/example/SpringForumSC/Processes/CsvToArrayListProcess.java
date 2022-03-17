package com.example.SpringForumSC.Processes;

import com.example.SpringForumSC.Entities.User;
import com.example.SpringForumSC.Errors.ErrorType;
import com.example.SpringForumSC.Errors.Errors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsvToArrayListProcess {

    private List<User> users;
    private static String SEPARATOR = ",";
    private List<Errors> errors;

    public CsvToArrayListProcess(int lines, List<User> users, String pathFile) {
        this.users = users;
    }

    public void csvProcess() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/home/rubdh/My things/OB/SecondCommit/SpringForumSC/usuarios.csv"));
            ArrayList<String> users = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(SEPARATOR);
                if (vf(fields)) {
                    if (this.vde(fields[0])) {
                        Errors emailError = new Errors(ErrorType.DUPLICATED_EMAIL);
                        this.errors.add(emailError);
                    } else if (this.vdu((fields[2]))) {
                        Errors nameError = new Errors(ErrorType.DUPLICATED_FULLNAME);
                        this.errors.add(nameError);
                    } else {
                        User user = new User();
                        this.users.add(user);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file doesn't exist or the path is wrong: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Something happens reading the file: " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Verify fields = vf
    public boolean vf(String[] fields){
        Pattern email = Pattern.compile("^[a-zA-Z0-9_\\-\\.]+@([a-zA-Z0-9]+)(\\.)[a-zA-Z0-9]+$");
        Pattern fullName = Pattern.compile("^[a-zA-Z]+(\\s[a-zA-Z]+)+$");
        Pattern user = Pattern.compile("^[a-zA-Z0-9_\\.\\-@]+$");
        String[] paramArray = new String[3];

        if (fields.length == 3){
            paramArray = fields;
            Matcher emailMat = email.matcher(paramArray[0]);
            Matcher nameMat = fullName.matcher(paramArray[0]);
            Matcher userMat = user.matcher(paramArray[0]);
            if (emailMat.matches() && userMat.matches() && nameMat.matches()){
                return true;
            }
        }
        return false;
    }

    // Verify Duplicated Emails function = vde
    public boolean vde(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    // Verify Duplicated Usernames = vdu

    public boolean vdu(String FullName) {
        for (User user : users) {
            if (user.getFullName().equals(FullName)) {
                return true;
            }
        }
        return false;
    }

    // Showing errors = se

    public void se() {
        System.out.println("------> Error List <------");
        for (Errors error : errors) {
            System.out.println(error.toString());
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public static String getSeparator() {
        return SEPARATOR;
    }

    public static void setSeparator(String separator) {
        CsvToArrayListProcess.SEPARATOR = separator;
    }

    public List<Errors> getErrors() {
        return errors;
    }

    public void setErrors(List<Errors> errors) {
        this.errors = errors;
    }
}
