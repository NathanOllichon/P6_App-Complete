package com.openclassrooms.mddapi.services;

import java.util.List;

import com.openclassrooms.mddapi.dto.ArticleDto;

public interface ArticleService {

	List<ArticleDto> getArticles();

}
