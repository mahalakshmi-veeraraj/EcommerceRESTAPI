package com.maha.ecommerce.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.maha.ecommerce.user_service.models.Token;
import com.maha.ecommerce.user_service.models.User;
import com.maha.ecommerce.user_service.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;

	public User signUp(String email, String name, String password) {
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setHashedPassword(bCryptPasswordEncoder.encode(password));
		user.setEmailVerified(true);

		// save the user object to the database.
		User savedUser = userRepository.save(user);
		return savedUser;
	}

	public Token login(String email, String password) {

		return null;
	}

	public void logout(String token) {

	}

	public User validateToken(String token) {

		return null;
	}
}
