package com.example.teste_1.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.teste_1.Entities.Order;
import com.example.teste_1.Entities.User;
import com.example.teste_1.repositories.OrderRepository;
import com.example.teste_1.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Teste1", "email@email", "242423234","12312adad");
		User u2 = new User(null, "Teste1", "email@email", "242423234","12312adad");
		User u3 = new User(null, "Teste1", "email@email", "242423234","12312adad");
		
		Order o1 = new Order(null, Instant.parse("2021-01-01T00:01:02Z"), u1);
		Order o2 = new Order(null, Instant.parse("2021-01-01T00:01:02Z"), u2);
		Order o3 = new Order(null, Instant.parse("2021-01-01T00:01:02Z"), u3);
		Order o4 = new Order(null, Instant.parse("2021-01-01T00:01:02Z"), u2);
		Order o5 = new Order(null, Instant.parse("2021-01-01T00:01:02Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5));
	}
	
}
	