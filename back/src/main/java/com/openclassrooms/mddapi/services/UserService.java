package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.UserJsonDTO;
import com.openclassrooms.mddapi.models.User;

public interface UserService {

	User getUser(Long id);

	void registerUser(UserJsonDTO userJsonDTO);

	User isLoginValid(String mail, String password);

}
