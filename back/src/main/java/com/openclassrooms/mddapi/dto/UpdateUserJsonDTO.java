package com.openclassrooms.mddapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UpdateUserJsonDTO {

  @JsonProperty(value = "email") 
  private String email;
  
  @JsonProperty(value = "username") 
  private String username;
}
