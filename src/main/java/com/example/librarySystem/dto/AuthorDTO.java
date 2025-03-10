package com.example.librarySystem.dto;

import lombok.Data;
import java.util.List;

@Data
public class AuthorDTO {
    private Long id;
    private String name;
    private List<BookDTO> books;
}
