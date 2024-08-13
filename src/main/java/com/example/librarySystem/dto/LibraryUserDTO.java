package com.example.librarySystem.dto;

import lombok.Data;

import java.util.List;

@Data
public class LibraryUserDTO {
    private Long id;
    private String name;
    private List<BookDTO> borrowedBooks;
}
