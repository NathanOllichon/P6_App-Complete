package com.openclassrooms.mddapi.controllers;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ThemeController {


    //private final ThemeServices themeService;

//    public ThemeController(ThemeServices themeService) {
//        this.themeService = themeService;
//    }

//    @GetMapping(
//            value = "/themes",
//            produces = {"application/json"}
//    )
//    public ResponseEntity<List<Theme>> themesGet() {
//        return ResponseEntity.ok(themeService.getThemeList());
//    }

//    @PostMapping(
//            value = "/themes/{theme_id}/subscribe/{user_id}",
//            produces = { "application/json" }
//    )
//    public ResponseEntity<Void> themesThemeIdSubscribeUserIdPost(
//            @Parameter(name = "theme_id", description = "ID of the theme to subscribe to", required = true, in = ParameterIn.PATH) @PathVariable("theme_id") Long themeId,
//            @Parameter(name = "user_id", description = "ID of the user subscribing", required = true, in = ParameterIn.PATH) @PathVariable("user_id") Long userId
//    ) {
//        themeService.subscribeToTheme(themeId, userId);
//        return ResponseEntity.ok().build();
//    }

//    @DeleteMapping(
//            value = "/themes/{theme_id}/subscribe/{user_id}",
//            produces = { "application/json" }
//    )
//    public ResponseEntity<Void> themesThemeIdSubscribeUserIdDelete(
//            @Parameter(name = "theme_id", description = "ID of the theme to unsubscribe from", required = true, in = ParameterIn.PATH) @PathVariable("theme_id") Long themeId,
//            @Parameter(name = "user_id", description = "ID of the user unsubscribing", required = true, in = ParameterIn.PATH) @PathVariable("user_id") Long userId
//    ) {
//        themeService.unsubscribeFromTheme(themeId, userId);
//        return ResponseEntity.ok().build();
//    }
}
