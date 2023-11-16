package com.openclassrooms.mddapi.services;

import java.util.List;

import com.openclassrooms.mddapi.dto.ThemeIsSubscribedDTO;
import com.openclassrooms.mddapi.models.User;

public interface ThemeService {

	List<ThemeIsSubscribedDTO> getThemes(String token);

	void subscribeToTheme(Long themeId, User userId);

	void unsubscribeFromTheme(Long themeId, User userId);

	List<ThemeIsSubscribedDTO> getThemesList(String token);
	 
}
