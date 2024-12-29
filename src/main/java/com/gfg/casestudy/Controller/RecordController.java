package com.gfg.casestudy.Controller;

import com.gfg.casestudy.Model.Records;
import com.gfg.casestudy.Model.Users;
import com.gfg.casestudy.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow-records")
public class RecordController {
    @Autowired
    private RecordService borrowRecordService;

    @GetMapping
    public List<Records> getAllRecords() {
        return borrowRecordService.getAllRecords();
    }

    @PostMapping("/borrow/{bookId}")
    public Records borrowBook(@PathVariable int bookId, @RequestBody Users user) {
        return borrowRecordService.borrowBook(bookId, user);
    }

    @PutMapping("/return/{borrowId}")
    public Records returnBook(@PathVariable int borrowId) {
        return borrowRecordService.returnBook(borrowId);
    }
}