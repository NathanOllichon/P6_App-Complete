package com.openclassrooms.mddapi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.openclassrooms.mddapi.dto.ThemeIsSubscribedDTO;
import com.openclassrooms.mddapi.mappers.ThemeMapper;
import com.openclassrooms.mddapi.models.Subscription;
import com.openclassrooms.mddapi.models.SubscriptionPrimaryKey;
import com.openclassrooms.mddapi.models.Theme;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repository.SubscriptionDeleteRepository;
import com.openclassrooms.mddapi.repository.SubscriptionRepository;
import com.openclassrooms.mddapi.repository.ThemeRepository;
import com.openclassrooms.mddapi.services.ThemeService;
import com.openclassrooms.mddapi.services.TokenService;

@Service
public class ThemeServiceImpl implements ThemeService {

	private final TokenService tokenService;

	@Autowired
	private ThemeRepository themeRepository;

	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private SubscriptionDeleteRepository subscriptionDeleteRepository;

	public ThemeServiceImpl(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	@Override
	public List<ThemeIsSubscribedDTO> getThemesList(String token) {
		List<Long> listSubscriptionIdTheme = new ArrayList<Long>();
		List<ThemeIsSubscribedDTO> listThemesDTO = new ArrayList<ThemeIsSubscribedDTO>();

		User actualUser = tokenService.validateJwtToken(token);
		actualUser.getThemes().forEach(subscription -> {
			listSubscriptionIdTheme.add(subscription.getTheme().getId());
		});

		themeRepository.findAll().forEach(theme -> {
			boolean isSubscribed;

			if (listSubscriptionIdTheme.contains(theme.getId())) {
				isSubscribed = true;
			} else {
				isSubscribed = false;
			}
			ThemeIsSubscribedDTO themeToAdd = new ThemeIsSubscribedDTO(ThemeMapper.MAPPER.mapToThemeDTO(theme),
					isSubscribed);
			listThemesDTO.add(themeToAdd);
		});

		return listThemesDTO;
	}

	@Override
	public List<ThemeIsSubscribedDTO> getThemes(String token) {
		List<Long> listSubscriptionIdTheme = new ArrayList<Long>();
		List<ThemeIsSubscribedDTO> listThemesDTO = new ArrayList<ThemeIsSubscribedDTO>();

		User actualUser = tokenService.validateJwtToken(token);

		actualUser.getThemes().forEach(subscription -> {
			listSubscriptionIdTheme.add(subscription.getTheme().getId());
		});

		themeRepository.findAll().forEach(theme -> {

			if (listSubscriptionIdTheme.contains(theme.getId())) {
				ThemeIsSubscribedDTO themeToAdd = new ThemeIsSubscribedDTO(ThemeMapper.MAPPER.mapToThemeDTO(theme),
						true);
				listThemesDTO.add(themeToAdd);
			}
		});

		return listThemesDTO;
	}

	@Override
	public void subscribeToTheme(Long themeId, User user) {
		Theme theme = themeRepository.findById(themeId).orElse(null);

		SubscriptionPrimaryKey subscriptionPrimaryKey = new SubscriptionPrimaryKey(user.getId(),theme.getId());
		Subscription subscribed = new Subscription(subscriptionPrimaryKey, user, theme);
		subscriptionRepository.save(subscribed);
	}

	@Override
	public void unsubscribeFromTheme(Long themeId, User user) {

		List<Subscription> actualUserSubscriptions = new ArrayList<Subscription>();
		user.getThemes().forEach(subscription -> {
			actualUserSubscriptions.add(subscription);
		});

		actualUserSubscriptions.forEach(subscription -> {
			if (themeId.equals(subscription.getTheme().getId())) {
				
	            SubscriptionPrimaryKey subscriptionPrimaryKey = new SubscriptionPrimaryKey();
	            subscriptionPrimaryKey.setTheme_id(themeId);
	            subscriptionPrimaryKey.setUser_id(user.getId());

	            
	            System.out.println( "themeId " + themeId + " et user.getId() " + user.getId());
	            subscriptionRepository.deleteSubscriptionByIds(themeId, user.getId());

			}
		});
	}

}
