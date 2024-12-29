package com.gfg.casestudy.Controller;


import com.gfg.casestudy.Model.Books;
import com.gfg.casestudy.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Books> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Books addBook(@RequestBody Books book) {
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public Books updateBook(@PathVariable int id, @RequestBody Books book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
}
