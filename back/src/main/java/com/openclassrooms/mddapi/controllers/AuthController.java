package com.openclassrooms.mddapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mddapi.dto.TokenDTO;
import com.openclassrooms.mddapi.dto.UserJsonDTO;
import com.openclassrooms.mddapi.mappers.UserMapper;
import com.openclassrooms.mddapi.dto.UserDTO;
import com.openclassrooms.mddapi.dto.CredentialsJsonDTO;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.services.TokenService;
import com.openclassrooms.mddapi.services.impl.UserServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "Authentification", description = "Authentification route APIs")
@RestController
public class AuthController {

	@Autowired
	private UserServiceImpl userService;

	private final TokenService tokenService;

	public AuthController(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	@Operation(summary = "Create a new User, email unique needed", 
			description = "Route for create an user. Email need to be unique ! The response is the security token.")
	@PostMapping("/auth/register")
	@ResponseBody
	public TokenDTO register(@RequestBody UserJsonDTO userJsonDTO) {		
		userService.registerUser(userJsonDTO);
		String token = tokenService.generateToken(userJsonDTO.getEmail());
		TokenDTO tokenDTO = new TokenDTO(token);
		return tokenDTO;
	}

	@Operation(summary = "Log in route if your user are registered and your credentials are good", 
			description = "Route for log in user. Credentials mail and password needed. The response is the security token.")
	@PostMapping("/auth/login")
	@ResponseBody
	public TokenDTO login(@RequestBody CredentialsJsonDTO credentialsJsonDTO) {
		User user = userService.isLoginValid(credentialsJsonDTO.getIdentifier(), credentialsJsonDTO.getPassword());
		String token = tokenService.generateToken(user.getEmail());
		TokenDTO tokenDTO = new TokenDTO(token);
		return tokenDTO;
	}

	@Operation(summary = "Route for validate your JWT token", 
			description = "Route for validate your token. The response is a DTO with your user informations.")
	@GetMapping("/auth/me")
	@ResponseBody
	public UserDTO getMe(@RequestHeader("Authorization") String token) {

		User actualUser = tokenService.validateJwtToken(token);
		UserDTO userDTO = UserMapper.MAPPER.mapToUserDto(actualUser);
		return userDTO;
	}

}