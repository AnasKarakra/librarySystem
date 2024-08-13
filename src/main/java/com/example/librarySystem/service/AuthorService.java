package com.example.librarySystem.service;

import com.example.librarySystem.dto.AuthorDTO;
import com.example.librarySystem.exception.ResourceNotFoundException;
import com.example.librarySystem.mapper.AuthorMapper;
import com.example.librarySystem.mapper.BookMapper;
import com.example.librarySystem.model.Author;
import com.example.librarySystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(AuthorMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public AuthorDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
        return AuthorMapper.INSTANCE.toDTO(author);
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = AuthorMapper.INSTANCE.toEntity(authorDTO);
        // Check if author or any nested objects are null
        if (author == null) {
            throw new RuntimeException("Author entity is null after mapping.");
        }
        Author savedAuthor = authorRepository.save(author);
        return AuthorMapper.INSTANCE.toDTO(savedAuthor);
    }



  /*  public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));

        existingAuthor.setName(authorDTO.getName()); // Ensure this is correct
        existingAuthor.setBooks(authorDTO.getBooks().stream()
                .map(bookDTO -> BookMapper.INSTANCE.toEntity(bookDTO))
                .collect(Collectors.toList()));

        Author updatedAuthor = authorRepository.save(existingAuthor);
        return AuthorMapper.INSTANCE.toDTO(updatedAuthor);
    }*/


    public void deleteAuthor(Long id) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
        authorRepository.delete(existingAuthor);
    }
}
