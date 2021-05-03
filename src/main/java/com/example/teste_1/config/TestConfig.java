package com.example.teste_1.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.teste_1.Entities.Category;
import com.example.teste_1.Entities.Order;
import com.example.teste_1.Entities.Product;
import com.example.teste_1.Entities.User;
import com.example.teste_1.Entities.enums.OrderStatus;
import com.example.teste_1.repositories.CategoryRepository;
import com.example.teste_1.repositories.OrderRepository;
import com.example.teste_1.repositories.ProductRepository;
import com.example.teste_1.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	//injecao dependencia
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "User1", "email@email1", "242423234","12312adad");
		User u2 = new User(null, "User2", "email@email2", "242423234","12312adad");
		User u3 = new User(null, "User3", "email@email3", "242423234","12312adad");
		
		Order o1 = new Order(null, Instant.parse("2021-01-01T00:01:02Z"), u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2021-01-01T00:01:02Z"), u2, OrderStatus.PAID);
		Order o3 = new Order(null, Instant.parse("2021-01-01T00:01:02Z"), u3, OrderStatus.SHIPPPED);
		Order o4 = new Order(null, Instant.parse("2021-01-01T00:01:02Z"), u2, OrderStatus.WAITING_PAYMENT);
		Order o5 = new Order(null, Instant.parse("2021-01-01T00:01:02Z"), u1, OrderStatus.CANCELED);
		
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Pets");
		Category c4 = new Category(null, "Presents");
		
		Product p1 = new Product(null, "Livro - livro", "Sobre auto ajuda em tempos de pandemia",
				45.99, "");
		Product p2 = new Product(null, "TV SMART LG", "Full HD",
				1555.99, "");
		Product p3 = new Product(null, "Raçao cao", "Alimento para seu PET",
				25.00, "");
		Product p4 = new Product(null, "Livro - livro", "Sobre economia",
				30.44, "");
		
		p1.getCategories().add(c2);
		p2.getCategories().add(c1);
		p3.getCategories().add(c3);
		p4.getCategories().add(c2);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5));
		categoryRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
	}
	
}
	