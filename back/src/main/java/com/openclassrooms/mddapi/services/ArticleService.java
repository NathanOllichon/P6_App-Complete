package com.openclassrooms.mddapi.services;

import java.util.List;

import com.openclassrooms.mddapi.dto.ArticleDetailledDto;
import com.openclassrooms.mddapi.dto.ArticleDto;
import com.openclassrooms.mddapi.dto.ArticleToCreateDTO;
import com.openclassrooms.mddapi.models.User;

public interface ArticleService {

	void createArticle(ArticleToCreateDTO articleToCreateDTO, User user);
	
	List<ArticleDto> getArticles(User actualUser);

	ArticleDetailledDto getArticle(Long id);

}
