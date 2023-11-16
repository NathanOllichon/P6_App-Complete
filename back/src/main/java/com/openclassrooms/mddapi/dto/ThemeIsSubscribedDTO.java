package com.openclassrooms.mddapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ThemeIsSubscribedDTO {

	public ThemeIsSubscribedDTO(ThemeDTO theme, boolean isSubscribed) {
		this.id = theme.getId();
		this.titre = theme.getTitre();
		this.description = theme.getDescription();
		this.isSubscribed = isSubscribed;

	}
	
	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "titre")
	private String titre;
	
	@JsonProperty(value = "description")
	private String description;
	
	@JsonProperty(value = "isSubscribed")
	private boolean isSubscribed;
}