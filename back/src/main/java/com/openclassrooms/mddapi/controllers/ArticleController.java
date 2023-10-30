package com.openclassrooms.mddapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mddapi.dto.ArticleDto;
import com.openclassrooms.mddapi.services.impl.ArticleServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "Article", description = "Articles route APIs")
@RestController
public class ArticleController {

	@Autowired
	private ArticleServiceImpl articleService;

	@Operation(summary = "Get data from articles for all theme subscribe by current user", description = "Route for get data from articles for all theme subscribe by current user. The response is a list of DTO of article")
	@GetMapping("/article/list")
	public ResponseEntity<List<ArticleDto>> articlesGet() {
		List<ArticleDto> articleListDTO = articleService.getArticles();
		return new ResponseEntity<>(articleListDTO, HttpStatus.OK);
	}

	@Operation(summary = "Get data from articles for all theme subscribe by current user", description = "Route for get data from articles for all theme subscribe by current user. The response is a list of DTO of article")
	@PostMapping("/article/list")
	public ResponseEntity<List<ArticleDto>> articlesGet2() {
		List<ArticleDto> articleListDTO = articleService.getArticles();
		return new ResponseEntity<>(articleListDTO, HttpStatus.OK);
	}

//    @Override
//    @GetMapping(
//            value = "/articles/{article_id}",
//            produces = {"application/json"}
//    )
//    public ResponseEntity<ArticleDto> articlesArticleIdGet(
//            @Parameter(name = "article_id", description = "ID of the article to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("article_id") Long articleId
//    ) {
//        return ResponseEntity.ok(articleServices.getArticle(articleId));
//    }

//    @Override
//    @PostMapping(
//            value = "/articles/{id}/comment",
//            produces = {"application/json"},
//            consumes = {"application/json"}
//    )
//    public ResponseEntity<CommentDto> articlesIdCommentPost(
//            @Parameter(name = "id", description = "ID of the article to comment on", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
//            @Parameter(name = "CommentDto", description = "", required = true) @Valid @RequestBody CommentDto commentDto
//    ) {
//        return ResponseEntity.ok(articleServices.addComment(id, commentDto));
//    }

//    @Override
//    @PostMapping(
//            value = "/articles",
//            produces = {"application/json"},
//            consumes = {"application/json"}
//    )
//    public ResponseEntity<ArticleDto> createArticle(
//            @Parameter(name = "ArticlePostRequest", description = "", required = true) @Valid @RequestBody ArticlePostRequest articlePostRequest
//    ) {
//        return ResponseEntity.ok(articleServices.createArticle(articlePostRequest));
//    }

}
