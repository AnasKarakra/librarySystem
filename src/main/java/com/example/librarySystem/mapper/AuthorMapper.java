package com.example.librarySystem.mapper;

import com.example.librarySystem.dto.AuthorDTO;
import com.example.librarySystem.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO toDTO(Author author);
    Author toEntity(AuthorDTO authorDTO);
}
