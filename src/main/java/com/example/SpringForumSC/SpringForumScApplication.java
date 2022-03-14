package com.example.SpringForumSC;

import com.example.SpringForumSC.Processes.emailSender;

import com.sparkpost.model.responses.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringForumScApplication {

	public static void main(String[] args){
		SpringApplication.run(SpringForumScApplication.class, args);

		String from = "benrhu@gmail.com";
		String to = "rubendiaz300000@gmail.com";
		String subject = "Email test for SC";
		String body = "This is a test :)";
		String html = "<p>greetings :)</p>";

		emailSender emailSender = new emailSender();
		Response response = emailSender.getClient().sendMessage(from, to, subject, body, html);
		System.out.println(response);
	}

}
