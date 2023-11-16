package com.openclassrooms.mddapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.openclassrooms.mddapi.dto.CommentDto;
import com.openclassrooms.mddapi.models.Comment;

@Mapper
public interface CommentMapper {

	CommentMapper MAPPER = Mappers.getMapper(CommentMapper.class);

	CommentDto mapToCommentDto(Comment comment);

	Comment mapToComment(CommentDto commenDto);    
}