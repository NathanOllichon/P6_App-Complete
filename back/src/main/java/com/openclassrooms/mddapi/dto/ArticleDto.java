package com.openclassrooms.mddapi.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openclassrooms.mddapi.models.User;

import lombok.Data;

@Data
public class ArticleDto {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "titre")
	private String titre;

	@JsonProperty(value = "contenu")
	private String contenu;

	@JsonProperty(value = "created_at")
	private Instant created_at;

	@JsonProperty(value = "auteur")
	private User auteur;
}
