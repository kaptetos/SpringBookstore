package com.example.springbookstore.mapper;

import com.example.springbookstore.dto.BookDto;
import com.example.springbookstore.dto.CreateBookRequestDto;
import com.example.springbookstore.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "deleted", ignore = true),
            @Mapping(target = "title", source = "createBookRequestDto.title"),
            @Mapping(target = "author", source = "createBookRequestDto.author"),
            @Mapping(target = "isbn", source = "createBookRequestDto.isbn"),
            @Mapping(target = "price", source = "createBookRequestDto.price"),
            @Mapping(target = "description", source = "createBookRequestDto.description"),
            @Mapping(target = "coverImage", source = "createBookRequestDto.coverImage")
    })
    Book createRequestDtoToEntity(CreateBookRequestDto createBookRequestDto);

    BookDto entityToDto(Book book);
}