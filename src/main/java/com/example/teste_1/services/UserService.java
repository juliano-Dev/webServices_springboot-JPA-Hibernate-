package com.example.teste_1.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.teste_1.Entities.User;
import com.example.teste_1.repositories.UserRepository;
import com.example.teste_1.resources.exceptions.DataBaseException;
import com.example.teste_1.services.exceptions.ResourceNotFoundException;


@Service
public class UserService {
	

	@Autowired
	private UserRepository repository;
	
	
	public List<User> findAll(){
		return repository.findAll();		
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		//return obj.get();
		//lança execessao caso nao ache o obj
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));  
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {//id nao encontrado
			throw new ResourceNotFoundException(id); 
		}catch(DataIntegrityViolationException e ) {
			throw new DataBaseException(e.getMessage());
		}
		/*catch(RuntimeException e) { //erro generico. Teste
			e.printStackTrace();
		}
		*/
		
	}
	
	public User update(Long id, User obj) {
		try {
			//getOne ñ busca no banco o objeto, sendo mais eficiente q o findById
			User user = repository.getOne(id);
			updateData(user, obj);
			return repository.save(user);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id); 
		}
		
	}

	private void updateData(User user, User obj) {
		user.setNome(obj.getNome());
		user.setEmail(obj.getEmail());
		user.setPhone(obj.getPhone());		
	}

}
