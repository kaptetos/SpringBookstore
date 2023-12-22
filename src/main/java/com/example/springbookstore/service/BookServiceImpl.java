package com.example.springbookstore.service;

import com.example.springbookstore.dto.CreateBookRequestDto;
import com.example.springbookstore.entity.Book;
import com.example.springbookstore.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(CreateBookRequestDto createBookRequestDto) {
        Book book = new Book();
        BeanUtils.copyProperties(createBookRequestDto, book);
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
    }

    @Override
    public Book updateBook(Long id, CreateBookRequestDto updateBookRequestDto) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));

        BeanUtils.copyProperties(updateBookRequestDto, existingBook);

        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
