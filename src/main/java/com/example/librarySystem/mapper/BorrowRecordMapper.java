package com.example.librarySystem.mapper;

import com.example.librarySystem.dto.BorrowRecordDTO;
import com.example.librarySystem.model.BorrowRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BorrowRecordMapper {
    BorrowRecordMapper INSTANCE = Mappers.getMapper(BorrowRecordMapper.class);

    BorrowRecordDTO toDTO(BorrowRecord record);
    BorrowRecord toEntity(BorrowRecordDTO recordDTO);
}
