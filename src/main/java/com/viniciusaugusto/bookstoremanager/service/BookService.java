package com.viniciusaugusto.bookstoremanager.service;

import com.viniciusaugusto.bookstoremanager.dto.MessageResponseDTO;
import com.viniciusaugusto.bookstoremanager.entity.Book;
import com.viniciusaugusto.bookstoremanager.reposiroty.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public MessageResponseDTO create(Book book) {
        Book savedBook = repository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId())
                .build();
    }
}
