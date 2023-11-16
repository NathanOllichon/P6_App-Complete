package com.openclassrooms.mddapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ThemeListDTO {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "titre")
	private String titre;
	
}