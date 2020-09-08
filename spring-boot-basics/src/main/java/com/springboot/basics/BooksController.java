package com.springboot.basics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BooksController {

    @GetMapping("/books")
    public List<Book> getAllList() {
        return Arrays.asList(
                new Book(4, "Masters", "Spring"),
                new Book(2, "Controller", "Michel"));
    }
}
