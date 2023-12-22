package com.example.springbookstore.service;

import com.example.springbookstore.dto.CreateBookRequestDto;
import com.example.springbookstore.entity.Book;
import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();

    Book createBook(CreateBookRequestDto createBookRequestDto);

    Book getBookById(Long id);

    Book updateBook(Long id, CreateBookRequestDto updateBookRequestDto);

    void deleteBook(Long id);
}
