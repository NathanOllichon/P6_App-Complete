package com.openclassrooms.mddapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.openclassrooms.mddapi.dto.UserDTO;
import com.openclassrooms.mddapi.models.User;


@Mapper
public interface UserMapper {

	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

	UserDTO mapToUserDto(User user);

	User mapToUser(UserDTO userDTO);
    
}