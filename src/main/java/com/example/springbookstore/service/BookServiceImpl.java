package com.example.springbookstore.service;

import com.example.springbookstore.dto.BookDto;
import com.example.springbookstore.dto.CreateBookRequestDto;
import com.example.springbookstore.entity.Book;
import com.example.springbookstore.exception.EntityNotFoundException;
import com.example.springbookstore.mapper.BookMapper;
import com.example.springbookstore.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDto createBook(CreateBookRequestDto createBookRequestDto) {
        Book book = bookMapper.createRequestDtoToEntity(createBookRequestDto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.entityToDto(savedBook);
    }

    @Override
    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::entityToDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book", id));
        return bookMapper.entityToDto(book);
    }

    @Override
    public BookDto updateBook(Long id, CreateBookRequestDto updateBookRequestDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book", id));

        book.setTitle(updateBookRequestDto.getTitle());
        book.setAuthor(updateBookRequestDto.getAuthor());

        Book updatedBook = bookRepository.save(book);

        return bookMapper.entityToDto(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book", id));

        bookRepository.deleteById(id);
    }

    @Override
    public Page<BookDto> searchBooksByTitle(String title, Pageable pageable) {
        Page<Book> booksPage = bookRepository.findByTitleContainingIgnoreCase(title, pageable);

        return booksPage.map(bookMapper::entityToDto);
    }
}
