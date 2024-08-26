package com.maha.ecommerce.user_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maha.ecommerce.user_service.dto.LoginRequestDto;
import com.maha.ecommerce.user_service.dto.LogoutRequestDto;
import com.maha.ecommerce.user_service.dto.SignUpRequestDto;
import com.maha.ecommerce.user_service.dto.UserDto;
import com.maha.ecommerce.user_service.models.User;
import com.maha.ecommerce.user_service.service.UserService;

import ch.qos.logback.core.subst.Token;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public UserDto signUp(@RequestBody SignUpRequestDto signUpRequestDTO) {
		User user = userService.signUp(signUpRequestDTO.getEmail(), signUpRequestDTO.getName(),
				signUpRequestDTO.getPassword());
		return UserDto.from(user);
	}

	@PostMapping("/login")
	public Token login(@RequestBody LoginRequestDto loginRequestDto) {

		return null;
	}

	@PostMapping("/logout")
	public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto logoutRequestDto) {

		return null;
	}

	@PostMapping("/validate/{token}")
	public UserDto validateToken(@PathVariable String token) {

		return null;
	}
}
