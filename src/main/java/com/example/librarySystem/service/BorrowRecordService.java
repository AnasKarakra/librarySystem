package com.example.librarySystem.service;

import com.example.librarySystem.dto.BorrowRecordDTO;
import com.example.librarySystem.exception.ResourceNotFoundException;
import com.example.librarySystem.mapper.BookMapper;
import com.example.librarySystem.mapper.BorrowRecordMapper;
import com.example.librarySystem.mapper.LibraryUserMapper;
import com.example.librarySystem.model.BorrowRecord;
import com.example.librarySystem.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowRecordService {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    public List<BorrowRecordDTO> getAllRecords() {
        return borrowRecordRepository.findAll().stream()
                .map(BorrowRecordMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public BorrowRecordDTO getRecordById(Long id) {
        BorrowRecord record = borrowRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrow record not found with id: " + id));
        return BorrowRecordMapper.INSTANCE.toDTO(record);
    }

    public BorrowRecordDTO createRecord(BorrowRecordDTO recordDTO) {
        BorrowRecord record = BorrowRecordMapper.INSTANCE.toEntity(recordDTO);
        BorrowRecord savedRecord = borrowRecordRepository.save(record);
        return BorrowRecordMapper.INSTANCE.toDTO(savedRecord);
    }

   /* public BorrowRecordDTO updateRecord(Long id, BorrowRecordDTO recordDTO) {
        BorrowRecord existingRecord = borrowRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrow record not found with id: " + id));

        existingRecord.setBorrowDate(recordDTO.getBorrowDate());
        existingRecord.setUser(LibraryUserMapper.INSTANCE.toEntity(recordDTO.getUser()));
        existingRecord.setBook(BookMapper.INSTANCE.toEntity(recordDTO.getBook()));

        BorrowRecord updatedRecord = borrowRecordRepository.save(existingRecord);
        return BorrowRecordMapper.INSTANCE.toDTO(updatedRecord);
    }*/

    public void deleteRecord(Long id) {
        BorrowRecord existingRecord = borrowRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrow record not found with id: " + id));
        borrowRecordRepository.delete(existingRecord);
    }
}
