package com.openclassrooms.mddapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ThemeDTO {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "titre")
	private String titre;
	
	@JsonProperty(value = "description")
	private String description;
}