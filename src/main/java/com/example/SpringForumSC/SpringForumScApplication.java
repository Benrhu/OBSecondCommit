package com.example.SpringForumSC;

import com.example.SpringForumSC.Entities.User;
import com.example.SpringForumSC.Processes.SparkpostConfig;

import com.example.SpringForumSC.Repositories.UserRepository;
import com.sparkpost.model.responses.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringForumScApplication {

	public static void main(String[] args){
		ApplicationContext context = SpringApplication.run(SpringForumScApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
	}

}
