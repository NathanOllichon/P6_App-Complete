package com.openclassrooms.mddapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.openclassrooms.mddapi.dto.ThemeIsSubscribedDTO;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.services.ThemeService;
import com.openclassrooms.mddapi.services.TokenService;

@CrossOrigin
@RestController
public class ThemeController {

	@Autowired
	private final ThemeService themeService;

	@Autowired
	private TokenService tokenService;
	
	public ThemeController(ThemeService themeService) {
		this.themeService = themeService;
	}
	
	@GetMapping("/theme/listTheme")
	public ResponseEntity<List<ThemeIsSubscribedDTO>> getThemesList(@RequestHeader("Authorization") String token) {
		List<ThemeIsSubscribedDTO> listThemeIsSubscribedDTO = themeService.getThemesList(token);
				
		return ResponseEntity.ok(listThemeIsSubscribedDTO);
	}

	@GetMapping("/theme/list")
	public ResponseEntity<List<ThemeIsSubscribedDTO>> getList(@RequestHeader("Authorization") String token) {
		
		return ResponseEntity.ok(themeService.getThemes(token));
	}

	@PostMapping(value = "/theme/subscribe")
	public ResponseEntity<String> themesThemeIdSubscribeUserIdPost(
			@RequestBody Long themeId,
			@RequestHeader("Authorization") String token) {

		User actualUser = tokenService.validateJwtToken(token);

		themeService.subscribeToTheme(themeId, actualUser);
		return ResponseEntity.ok("subscribe");
	}

	@PostMapping(value = "/theme/unsubscribe")
	public ResponseEntity<String> themesThemeIdSubscribeUserIdDelete(
			@RequestBody Long themeId,
			@RequestHeader("Authorization") String token) {

		User actualUser = tokenService.validateJwtToken(token);
		
		themeService.unsubscribeFromTheme(themeId, actualUser);
		return ResponseEntity.ok("unsubscribe");
	}
}
