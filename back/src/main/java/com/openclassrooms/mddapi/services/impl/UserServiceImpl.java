package com.openclassrooms.mddapi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.dto.UserJsonDTO;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repository.UserRepository;
import com.openclassrooms.mddapi.services.UserService;
 
@Service
public class UserServiceImpl implements UserService {
	
    @Autowired
    private UserRepository userRepository;
	
    @Override
	public User getUser(final Long id) {
    	User user = userRepository.findById(id).get();
    	return user;
	}
    
    @Override
	public void registerUser(UserJsonDTO userJsonDTO) {
    	String encodedString = java.util.Base64.getEncoder().encodeToString(userJsonDTO.getPassword().getBytes());
    	User userCreated = new User(null, userJsonDTO.getEmail(), userJsonDTO.getUsername(), encodedString, null);
    	userRepository.save(userCreated);
    }
    
    //TODO identifier WIP test that !
    @Override
	public User isLoginValid(String identifier, String password) {
    	User user;
    	user = userRepository.findByEmail(identifier);
    	if(user == null) {
        	user = userRepository.findByUsername(identifier);
        	if(user == null) {
        		return null; //"userNull";
        	}
    	}
    	String encodedString = java.util.Base64.getEncoder().encodeToString(password.getBytes());
    	if(user.getPassword().equals(encodedString)) {
    		return user;
    	}
    	return null;
	}
    
}