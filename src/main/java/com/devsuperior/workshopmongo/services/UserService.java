package com.devsuperior.workshopmongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.workshopmongo.domain.User;
import com.devsuperior.workshopmongo.dto.UserDTO;
import com.devsuperior.workshopmongo.repositories.UserRepository;
import com.devsuperior.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;


	public List<UserDTO> findAll(){
		List<User> list = repository.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return listDTO;
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
				return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public UserDTO insert(UserDTO user) {
		repository.insert(user.toEntity());
		return user;
	}
	

}
