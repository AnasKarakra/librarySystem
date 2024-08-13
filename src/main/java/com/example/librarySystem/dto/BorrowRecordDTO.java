package com.example.librarySystem.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowRecordDTO {
    private Long id;
    private LibraryUserDTO user;
    private BookDTO book;
    private LocalDate borrowDate;
}
