package com.openclassrooms.mddapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CommentCreateDto {
	
	@JsonProperty(value = "contenu")
	private String contenu;

	@JsonProperty(value = "idArticle")
	private Long id_article;
}


