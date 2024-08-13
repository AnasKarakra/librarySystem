package com.example.librarySystem.service;

import com.example.librarySystem.dto.BookDTO;
import com.example.librarySystem.exception.ResourceNotFoundException;
import com.example.librarySystem.mapper.AuthorMapper;
import com.example.librarySystem.mapper.BookMapper;
import com.example.librarySystem.model.Book;
import com.example.librarySystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        return BookMapper.INSTANCE.toDTO(book);
    }

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.toEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return BookMapper.INSTANCE.toDTO(savedBook);
    }

   /* public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(AuthorMapper.INSTANCE.toEntity(bookDTO.getAuthor()));

        Book updatedBook = bookRepository.save(existingBook);
        return BookMapper.INSTANCE.toDTO(updatedBook);
    }
*/
    public void deleteBook(Long id) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        bookRepository.delete(existingBook);
    }
}
