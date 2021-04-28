package com.example.teste_1.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.teste_1.Entities.User;
import com.example.teste_1.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u1 = new User(null, "Teste1", "email@email", "242423234","12312adad");
		User u2 = new User(null, "Teste1", "email@email", "242423234","12312adad");
		User u3 = new User(null, "Teste1", "email@email", "242423234","12312adad");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
	}
	
}
	