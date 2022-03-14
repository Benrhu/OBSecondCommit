package com.example.SpringForumSC.Processes;

import com.sparkpost.exception.SparkPostException;
import com.sparkpost.model.responses.Response;

public class emailSender{

    public emailSender() throws SparkPostException {

    String from = "benrhu@gmail.com";
    String to = "rubendiaz300000@gmail.com";
    String subject = "Email test for SC";
    String body = "This is a test :)";
    String html = "<p>greetings :)</p>";

    SparkpostConfig sp = new SparkpostConfig();
    Response response = sp.getClient().sendMessage(from, to, subject, body, html);
    System.out.println(response);
    }
}
