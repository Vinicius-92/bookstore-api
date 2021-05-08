package com.viniciusaugusto.bookstoremanager.reposiroty;

import com.viniciusaugusto.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
