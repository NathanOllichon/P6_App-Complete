package com.openclassrooms.mddapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CredentialsJsonDTO {

  @JsonProperty(value = "identifier") 
  private String identifier;
  
  @JsonProperty(value = "password") 
  private String password;
}
