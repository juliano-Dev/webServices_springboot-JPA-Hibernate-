package com.example.teste_1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teste_1.Entities.User;
import com.example.teste_1.repositories.UserRepository;


@Service
public class UserService {
	

	@Autowired
	private UserRepository repository;
	
	
	public List<User> findAll(){
		return repository.findAll();		
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		//getOne ñ busca no banco o objeto, sendo mais eficiente q o findById
		User user = repository.getOne(id);
		updateData(user, obj);
		return repository.save(user);
	}

	private void updateData(User user, User obj) {
		user.setNome(obj.getNome());
		user.setEmail(obj.getEmail());
		user.setPhone(obj.getPhone());		
	}

}
