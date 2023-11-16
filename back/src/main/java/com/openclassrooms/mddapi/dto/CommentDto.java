package com.openclassrooms.mddapi.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CommentDto {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "created_at")
	private Instant created_at;

	@JsonProperty(value = "contenu")
	private String contenu;
	
	@JsonProperty(value = "user_name")
	private String user_name;
	
}


