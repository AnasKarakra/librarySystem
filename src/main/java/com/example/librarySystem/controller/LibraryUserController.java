package com.example.librarySystem.controller;

import com.example.librarySystem.dto.LibraryUserDTO;
import com.example.librarySystem.service.LibraryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class LibraryUserController {

    @Autowired
    private LibraryUserService libraryUserService;

    @GetMapping
    public List<LibraryUserDTO> getAllUsers() {
        return libraryUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public LibraryUserDTO getUserById(@PathVariable Long id) {
        return libraryUserService.getUserById(id);
    }

    @PostMapping
    public LibraryUserDTO createUser(@RequestBody LibraryUserDTO userDTO) {
        return libraryUserService.createUser(userDTO);
    }

   /* @PutMapping("/{id}")
    public LibraryUserDTO updateUser(@PathVariable Long id, @RequestBody LibraryUserDTO userDTO) {
        return libraryUserService.updateUser(id, userDTO);
    }*/

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        libraryUserService.deleteUser(id);
    }
}
