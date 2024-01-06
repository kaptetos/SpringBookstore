package com.example.springbookstore.mapper;

import com.example.springbookstore.dto.BookDto;
import com.example.springbookstore.dto.CreateBookRequestDto;
import com.example.springbookstore.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    Book createRequestDtoToEntity(CreateBookRequestDto createBookRequestDto);

    BookDto entityToDto(Book book);
}
