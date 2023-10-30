package com.openclassrooms.mddapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.openclassrooms.mddapi.dto.ArticleDto;
import com.openclassrooms.mddapi.models.Article;

@Mapper
public interface ArticleMapper {

	ArticleMapper MAPPER = Mappers.getMapper(ArticleMapper.class);

	ArticleDto mapToArticleDto(Article article);

	Article mapToArticle(ArticleDto ArticleDTO);    
}