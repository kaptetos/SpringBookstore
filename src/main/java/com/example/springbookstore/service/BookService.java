package com.example.springbookstore.service;

import com.example.springbookstore.entity.Book;
import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();
}
