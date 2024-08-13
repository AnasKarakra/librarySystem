package com.example.librarySystem.repository;

import com.example.librarySystem.model.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryUserRepository extends JpaRepository<LibraryUser, Long> {
}
