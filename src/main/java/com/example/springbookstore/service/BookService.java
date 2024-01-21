package com.example.springbookstore.service;

import com.example.springbookstore.dto.BookDto;
import com.example.springbookstore.dto.CreateBookRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    BookDto createBook(CreateBookRequestDto createBookRequestDto);

    List<BookDto> findAll();

    BookDto findById(Long id);

    BookDto updateBook(Long id, CreateBookRequestDto updateBookRequestDto);

    void deleteBook(Long id);

    Page<BookDto> searchBooksByTitle(String title, Pageable pageable);
}
