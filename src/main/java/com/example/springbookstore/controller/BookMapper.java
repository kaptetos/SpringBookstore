package com.example.springbookstore.controller;

import com.example.springbookstore.dto.BookDto;
import com.example.springbookstore.dto.CreateBookRequestDto;
import com.example.springbookstore.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "isbn", target = "isbn")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "coverImage", target = "coverImage")
    BookDto bookToBookDto(Book book);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "isbn", target = "isbn")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "coverImage", target = "coverImage")
    Book createBookRequestDtoToBook(CreateBookRequestDto createBookRequestDto);
}
