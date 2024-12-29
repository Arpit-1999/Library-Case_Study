package com.gfg.casestudy.Service;

import com.gfg.casestudy.Model.Books;
import com.gfg.casestudy.Model.Records;
import com.gfg.casestudy.Model.Users;
import com.gfg.casestudy.Repository.Book_Dao;
import com.gfg.casestudy.Repository.Records_Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecordService {
    @Autowired
    private Book_Dao bookDao;

    @Autowired
    Records_Dao recordsDao;



    public Records borrowBook(int id, Users user) {
        // Find the book by ID or throw an exception if not found
        Books book = bookDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Check if the book is available for borrowing
        if (!book.isAvailable()) {
            throw new RuntimeException("Book not available");
        }

        // Mark the book as unavailable and save the updated book
        book.setAvailable(false);
        bookDao.save(book);

        // Create a new record for the borrowed book
        Records record = new Records();
        record.setBooks(book); // Associate the book with the record
        record.setUsers(user); // Associate the user with the record
        record.setBorrow_date(LocalDate.now()); // Set the current date as the borrow date

        // Save and return the new record
        return recordsDao.save(record);
    }
    //_________________________________________________________________________________

   /* public Records returnBook(int id) {
        Records record = recordsDao.findById(id).orElseThrow(() -> new RuntimeException("Record not found"));
        Books book = record.getBooks();
        book.setAvailable(true);
        bookDao.save(book);

        record.setReturn_date(LocalDate.now());
        return recordsDao.save(record);
    }

    public List<Records> getAllRecords() {
        return recordsDao.findAll();
    }*/

    public Records returnBook(int id) {
        // Find the borrowing record by ID or throw an exception if not found
        Records record = recordsDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        // Retrieve the associated book and mark it as available
        Books book = record.getBooks();
        book.setAvailable(true);
        bookDao.save(book); // Save the updated book

        // Set the return date for the record
        record.setReturn_date(LocalDate.now());

        // Save and return the updated record
        return recordsDao.save(record);
    }


    public List<Records> getAllRecords() {
        return recordsDao.findAll();
    }
}
