package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.exception.UserException;
import com.example.request.LoginRequest;
import com.example.response.AuthResponse;
import com.example.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
     
	
	private UserService userService;
	
	@Autowired
	public AuthController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException{
		return new ResponseEntity<AuthResponse>(userService.createUser(user),HttpStatus.CREATED);		 
	}
	
	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest logingRequest){
		return new ResponseEntity<AuthResponse>(userService.userLogin(logingRequest),HttpStatus.OK );
	}
}
