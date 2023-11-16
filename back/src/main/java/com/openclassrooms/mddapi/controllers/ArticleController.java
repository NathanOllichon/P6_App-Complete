package com.openclassrooms.mddapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mddapi.dto.ArticleDetailledDto;
import com.openclassrooms.mddapi.dto.ArticleDto;
import com.openclassrooms.mddapi.dto.ArticleToCreateDTO;
import com.openclassrooms.mddapi.dto.CommentCreateDto;
import com.openclassrooms.mddapi.dto.CommentDto;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.services.TokenService;
import com.openclassrooms.mddapi.services.impl.ArticleServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "Article", description = "Articles route APIs")
@RestController
public class ArticleController {

	@Autowired
	private ArticleServiceImpl articleService;

	@Autowired
	private TokenService tokenService;

	@Operation(summary = "Get data from articles for all theme subscribe by current user", description = "Route for get data from articles for all theme subscribe by current user. The response is a list of DTO of article")
	@GetMapping("/article/list")
	public ResponseEntity<List<ArticleDto>> articlesGet(@RequestHeader("Authorization") String token) {
		User actualUser = tokenService.validateJwtToken(token);

		List<ArticleDto> articleListDTO = articleService.getArticles(actualUser);
		return new ResponseEntity<>(articleListDTO, HttpStatus.OK);
	}

	
	@Operation(summary = "Route for create an article", description = "Route for create an article")
	@PostMapping(value = "/article/create", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<String> createArticle(@RequestBody ArticleToCreateDTO articleToCreateDTO,
			@Parameter(description = "Authentificate header, string token JWT") @RequestHeader("Authorization") String token) {

		User user = tokenService.validateJwtToken(token);

		articleService.createArticle(articleToCreateDTO, user);

		return new ResponseEntity<>("Article created", HttpStatus.OK);
	}

	
	@GetMapping("/article/{id}")
	public ResponseEntity<ArticleDetailledDto> getDetailledArticle(@PathVariable("id") Long articleId) {
		ArticleDetailledDto articleDetailledDTO = articleService.getArticle(articleId);

		return ResponseEntity.ok(articleDetailledDTO);
	}

	
    @PostMapping("/article/comment/create")
    public ResponseEntity<CommentCreateDto> articlesIdCommentPost(
    		@RequestBody CommentCreateDto commentCreateDto,
    		@RequestHeader("Authorization") String token
    ) {
		User actualUser = tokenService.validateJwtToken(token);

        return ResponseEntity.ok(articleService.addComment(actualUser, commentCreateDto));
    }

}
