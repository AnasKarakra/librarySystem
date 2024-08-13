package com.example.librarySystem.controller;

import com.example.librarySystem.dto.BorrowRecordDTO;
import com.example.librarySystem.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class BorrowRecordController {

    @Autowired
    private BorrowRecordService borrowRecordService;

    @GetMapping
    public List<BorrowRecordDTO> getAllRecords() {
        return borrowRecordService.getAllRecords();
    }

    @GetMapping("/{id}")
    public BorrowRecordDTO getRecordById(@PathVariable Long id) {
        return borrowRecordService.getRecordById(id);
    }

    @PostMapping
    public BorrowRecordDTO createRecord(@RequestBody BorrowRecordDTO recordDTO) {
        return borrowRecordService.createRecord(recordDTO);
    }

   /* @PutMapping("/{id}")
    public BorrowRecordDTO updateRecord(@PathVariable Long id, @RequestBody BorrowRecordDTO recordDTO) {
        return borrowRecordService.updateRecord(id, recordDTO);
    }*/

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id) {
        borrowRecordService.deleteRecord(id);
    }
}
