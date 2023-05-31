package com.example;

import com.example.domain.Book;
import com.example.infrastructure.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class LoadingInitialDataTestApplicationTests {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void find_all() {
        List<Book> foundBooks = bookRepository.findAll();

        assertThat(foundBooks).containsExactly(
                new Book(1L, "TDD", 12000),
                new Book(2L, "CLEAN CODE", 19000),
                new Book(3L, "JPA", 18000)
        );
    }
}
