package com.viniciusaugusto.bookstoremanager.service;

import com.viniciusaugusto.bookstoremanager.dto.BookDTO;
import com.viniciusaugusto.bookstoremanager.dto.MessageResponseDTO;
import com.viniciusaugusto.bookstoremanager.entity.Book;
import com.viniciusaugusto.bookstoremanager.exceptions.BookNotFoundException;
import com.viniciusaugusto.bookstoremanager.mapper.BookMapper;
import com.viniciusaugusto.bookstoremanager.reposiroty.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    private BookRepository repository;

    public MessageResponseDTO create(BookDTO bookDTO) {
        Book bookToSave = bookMapper.toModel(bookDTO);
        Book savedBook = repository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId())
                .build();
    }

    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return bookMapper.toDTO(book);
    }
}
