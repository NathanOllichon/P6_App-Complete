package com.openclassrooms.mddapi.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDetailledDto {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "titre")
	private String titre;

	@JsonProperty(value = "contenu")
	private String contenu;

	@JsonProperty(value = "created_at")
	private Instant created_at;

	@JsonProperty(value = "auteur_name")
	private String auteur_name;
	
	@JsonProperty(value = "commentaires")
	private List<CommentDto> commentaires;
	
	@JsonProperty(value = "theme_titre")
	private String theme_titre;
}
