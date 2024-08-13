package com.example.librarySystem.mapper;

import com.example.librarySystem.dto.LibraryUserDTO;
import com.example.librarySystem.model.LibraryUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LibraryUserMapper {
    LibraryUserMapper INSTANCE = Mappers.getMapper(LibraryUserMapper.class);

    LibraryUserDTO toDTO(LibraryUser user);
    LibraryUser toEntity(LibraryUserDTO userDTO);
}
