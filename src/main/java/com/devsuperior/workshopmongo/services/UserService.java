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
	
	public void delete(String id) {
		// Caso não encontre o objeto, o findById já sobe a exceção.
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		return repository.save(newUser);
		
	}
	public void updateData(User newUser, User userDto) {
		newUser.setName(userDto.getName());
		newUser.setEmail(userDto.getEmail());
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}

}
