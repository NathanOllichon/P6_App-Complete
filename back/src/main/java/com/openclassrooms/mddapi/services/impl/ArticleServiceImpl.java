package com.openclassrooms.mddapi.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.openclassrooms.mddapi.dto.ArticleDetailledDto;
import com.openclassrooms.mddapi.dto.ArticleDto;
import com.openclassrooms.mddapi.dto.ArticleToCreateDTO;
import com.openclassrooms.mddapi.dto.CommentCreateDto;
import com.openclassrooms.mddapi.dto.CommentDto;
import com.openclassrooms.mddapi.mappers.ArticleMapper;
import com.openclassrooms.mddapi.mappers.CommentMapper;
import com.openclassrooms.mddapi.models.Article;
import com.openclassrooms.mddapi.models.Comment;
import com.openclassrooms.mddapi.models.Theme;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repository.ArticleRepository;
import com.openclassrooms.mddapi.repository.CommentRepository;
import com.openclassrooms.mddapi.repository.ThemeRepository;
import com.openclassrooms.mddapi.services.ArticleService;
import com.openclassrooms.mddapi.services.TokenService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private ThemeRepository themeRepository;
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<ArticleDto> getArticles(User actualUser) {

		List<Article> listArticles = articleRepository.findAll();
		List<ArticleDto> listArticlesDTO = new ArrayList<ArticleDto>();

		List<Long> actualUserSubscriptions = new ArrayList<Long>();
		actualUser.getThemes().forEach(subscription -> {
			actualUserSubscriptions.add(subscription.getTheme().getId());
		});

		listArticles.forEach(article -> {

			// if user subscribed to theme of this article OR user have written this article
			// add on dashboard
			if (actualUserSubscriptions.contains(article.getTheme().getId())
					|| article.getUser().getId().equals(actualUser.getId())) {
				listArticlesDTO.add(ArticleMapper.MAPPER.mapToArticleDto(article));
			}
		});

		return listArticlesDTO;
	}

	@Override
	public void createArticle(ArticleToCreateDTO articleToCreateDTO, User user) {
		Theme theme = themeRepository.getReferenceById(articleToCreateDTO.getIdTheme());
		Article article = new Article(null, articleToCreateDTO.getTitle(), articleToCreateDTO.getContenu(), null, theme,
				user, null);
		articleRepository.save(article);
	}

	@Override
	public ArticleDetailledDto getArticle(Long id) {

		Article article = articleRepository.findById(id).orElse(null);
		String titreTheme = article.getTheme().getTitre();
		List<Comment> comments = article.getComments();
		List<CommentDto> listCommentDto = new ArrayList<CommentDto>();
		comments.forEach(comment ->{
			CommentDto commentDto = CommentMapper.MAPPER.mapToCommentDto(comment);
			commentDto.setUser_name(comment.getUserEntity().getUsername());
			listCommentDto.add(commentDto);
		});
		String writterName = article.getUser().getUsername(); 
		ArticleDto articleDto = ArticleMapper.MAPPER.mapToArticleDto(article);

		ArticleDetailledDto articleDetailledDto = new ArticleDetailledDto(articleDto.getId(), articleDto.getTitre(), articleDto.getContenu(),
				articleDto.getCreated_at(), writterName, listCommentDto, titreTheme);
		
		return articleDetailledDto;
	}

	public CommentDto addComment(Long articleId, User user, CommentDto commentDto) {
		Article article = articleRepository.findById(articleId).orElse(null);
		Comment comment = new Comment(null, commentDto.getContenu(), null, user, article );
		
		commentRepository.save(comment);
		return commentDto;
	}

	public CommentCreateDto addComment(User actualUser, CommentCreateDto commentCreateDto) {
		Article article = articleRepository.findById(commentCreateDto.getId_article()).orElse(null);
		Comment comment = new Comment(null, commentCreateDto.getContenu(), null, actualUser, article );
		
		commentRepository.save(comment);
		return commentCreateDto;
	}

}
