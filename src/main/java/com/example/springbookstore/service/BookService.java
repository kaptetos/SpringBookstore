package com.example.springbookstore.service;

import com.example.springbookstore.dto.BookDto;
import com.example.springbookstore.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {

    BookDto createBook(CreateBookRequestDto createBookRequestDto);

    List<BookDto> getAllBooks();

    BookDto getBookById(Long id);

    List<BookDto> findAll();

    BookDto findById(Long id);

    BookDto updateBook(Long id, CreateBookRequestDto updateBookRequestDto);

    void deleteBook(Long id);
}
