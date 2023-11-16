package com.openclassrooms.mddapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ArticleToCreateDTO {

	@JsonProperty(value = "title")
	private String title;

	@JsonProperty(value = "contenu")
	private String contenu;

	@JsonProperty(value = "idTheme")
	private Long idTheme;
}
