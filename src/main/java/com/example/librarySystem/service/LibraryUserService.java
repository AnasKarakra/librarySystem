package com.example.librarySystem.service;

import com.example.librarySystem.dto.LibraryUserDTO;
import com.example.librarySystem.exception.ResourceNotFoundException;
import com.example.librarySystem.mapper.BookMapper;
import com.example.librarySystem.mapper.LibraryUserMapper;
import com.example.librarySystem.model.LibraryUser;
import com.example.librarySystem.repository.LibraryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryUserService {

    @Autowired
    private LibraryUserRepository libraryUserRepository;

    public List<LibraryUserDTO> getAllUsers() {
        return libraryUserRepository.findAll().stream()
                .map(LibraryUserMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public LibraryUserDTO getUserById(Long id) {
        LibraryUser user = libraryUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return LibraryUserMapper.INSTANCE.toDTO(user);
    }

    public LibraryUserDTO createUser(LibraryUserDTO userDTO) {
        LibraryUser user = LibraryUserMapper.INSTANCE.toEntity(userDTO);
        LibraryUser savedUser = libraryUserRepository.save(user);
        return LibraryUserMapper.INSTANCE.toDTO(savedUser);
    }

    /*public LibraryUserDTO updateUser(Long id, LibraryUserDTO userDTO) {
        LibraryUser existingUser = libraryUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        existingUser.setName(userDTO.getName());
        existingUser.setBorrowedBooks(userDTO.getBorrowedBooks().stream()
                .map(bookDTO -> BookMapper.INSTANCE.toEntity(bookDTO))
                .collect(Collectors.toList()));

        LibraryUser updatedUser = libraryUserRepository.save(existingUser);
        return LibraryUserMapper.INSTANCE.toDTO(updatedUser);
    }*/

    public void deleteUser(Long id) {
        LibraryUser existingUser = libraryUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        libraryUserRepository.delete(existingUser);
    }
}
