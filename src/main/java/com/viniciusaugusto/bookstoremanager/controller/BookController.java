package com.viniciusaugusto.bookstoremanager.controller;

import com.viniciusaugusto.bookstoremanager.dto.BookDTO;
import com.viniciusaugusto.bookstoremanager.dto.MessageResponseDTO;
import com.viniciusaugusto.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
        return service.create(bookDTO);
    }
}
