package com.devsuperior.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devsuperior.workshopmongo.domain.Post;
import com.devsuperior.workshopmongo.domain.User;
import com.devsuperior.workshopmongo.repositories.PostRepository;
import com.devsuperior.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "partiu viagem", "vou viajar para São Paulo. Abraços.", maria);
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "partiu viagem", "vou viajar para São Paulo. Abraços.", maria);
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		
	}

}
