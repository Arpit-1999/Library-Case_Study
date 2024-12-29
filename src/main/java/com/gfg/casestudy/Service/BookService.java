package com.gfg.casestudy.Service;

import com.gfg.casestudy.Model.Books;
import com.gfg.casestudy.Repository.Book_Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private Book_Dao bookDao;

   //ADD
    public Books addBook(Books book) {
        book.setAvailable(true);
        return bookDao.save(book);
    }
    //GET
    public List<Books> getAllBooks() {
        return bookDao.findAll();
    }

    //UPDATE


    //DELETE
    public void deleteBook(int id) {
        bookDao.deleteById(id);
    }


   /* public Books updateBook(int id, Books bookDetails) {
        Books book = bookDao.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setAvailable(bookDetails.isAvailable());
        return bookDao.save(book);
    }*/

//simple

    public Books updateBook(int id, Books bookDetails) {
        // Find the book by ID or throw an exception if not found
        Books book = bookDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Update the book's properties with the provided details
        book.setTitle(bookDetails.getTitle()); // Update title
        book.setAuthor(bookDetails.getAuthor()); // Update author
        book.setAvailable(bookDetails.isAvailable()); // Update availability status

        // Save and return the updated book
        return bookDao.save(book);
    }



}
