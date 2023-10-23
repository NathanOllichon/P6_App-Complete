package com.openclassrooms.mddapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "Article", description = "Articles route APIs")
@RestController
public class ArticleController {

//	@Autowired
//	private final ArticleServices articleServices;
	
//	@Autowired
//	private TokenService tokenService;
	
// ---------------------------------------------------------------------

//    public ArticleController(ArticleServices articleServices) {
//        this.articleServices = articleServices;
//    }

//    @Override
//    @GetMapping(
//            value = "/articles",
//            produces = {"application/json"}
//    )
//    public ResponseEntity<List<ArticleDto>> articlesGet() {
//        return ResponseEntity.ok(articleServices.getArticles());
//    }

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
