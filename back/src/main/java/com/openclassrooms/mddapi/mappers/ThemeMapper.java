package com.openclassrooms.mddapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.openclassrooms.mddapi.dto.ThemeDTO;
import com.openclassrooms.mddapi.dto.ThemeListDTO;
import com.openclassrooms.mddapi.models.Theme;

@Mapper
public interface ThemeMapper {

	ThemeMapper MAPPER = Mappers.getMapper(ThemeMapper.class);

	ThemeListDTO mapToThemeListDto(Theme theme);

	Theme mapToThemeList(ThemeListDTO themeListDTO);  
	
	Theme mapToTheme(ThemeDTO themeDTO);  
	
	ThemeDTO mapToThemeDTO(Theme theme);  

}