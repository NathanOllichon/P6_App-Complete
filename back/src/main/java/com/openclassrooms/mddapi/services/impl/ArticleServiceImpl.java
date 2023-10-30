package com.openclassrooms.mddapi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.openclassrooms.mddapi.dto.ArticleDto;
import com.openclassrooms.mddapi.mappers.ArticleMapper;
import com.openclassrooms.mddapi.models.Article;
import com.openclassrooms.mddapi.repository.ArticleRepository;
import com.openclassrooms.mddapi.services.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public List<ArticleDto> getArticles() {
		// TODO Auto-generated method stub
		
		//remonter l'utilisateur, puis avec son fk_id_theme 
		//les themes souscris, ensuite les articles liés 
		//à ce themes par le
		
		//Ou, vu que tout est lié en spring, on remonte 
		//directement l'objet et on peut traiter avec ???
		
		
		List<Article> listArticles = articleRepository.findAll();
		List<ArticleDto> listRentalsDTO = new ArrayList<ArticleDto>();
		
		//user ? 
		//TODO 
		for (Article article : listArticles) {
			listRentalsDTO.add(ArticleMapper.MAPPER.mapToArticleDto(article));
		}
		
		return listRentalsDTO;
	}
	
//	List<Rentals> listRentals = rentalsRepository.findAll();
//	List<RentalsDTO> listRentalsDTO = new ArrayList<RentalsDTO>();
//	for (Rentals rentals : listRentals) {
//		listRentalsDTO.add(RentalsMapper.MAPPER.mapToRentalsDto(rentals));
//	}
//	
//	RentalsListDTO rentalsList = new RentalsListDTO(listRentalsDTO);
//	return rentalsList;
//	}

}
