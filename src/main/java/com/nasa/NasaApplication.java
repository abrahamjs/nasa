package com.nasa;

import com.nasa.dao.RatingRepository;
import com.nasa.dao.UserRepository;
import com.nasa.model.Rating;
import com.nasa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NasaApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RatingRepository ratingRepository;

	public static void main(String[] args) {
		SpringApplication.run(NasaApplication.class, args);
	}

	@Override
	public void run(String... args) {



        userRepository.save(new User("user1@gmail.com"));
		userRepository.save(new User("user2@gmail.com"));
		userRepository.save(new User("user3@gmail.com"));

		User user = new User();
		user.setEmail("user9@hotmail.com");
		user = userRepository.save(user);
		ratingRepository.save(new Rating("image.com/2", "just an image", user, 4 ));
		System.out.println("\nfindAll()");
		userRepository.findAll().forEach(x -> System.out.println(x));
		ratingRepository.findAll().forEach(x -> System.out.println(x));
		/*
		User user = new User("user4@gmail.com");


		userRepository.save(user);
		System.out.println("\nfindAll()");
		userRepository.findAll().forEach(x -> System.out.println(x));
*/


		//System.out.println("\nfindByName('Node')");
		//repository.findByFirstName("Node").forEach(x -> System.out.println(x));

	}
}
