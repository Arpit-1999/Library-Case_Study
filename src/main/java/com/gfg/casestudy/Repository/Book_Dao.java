package com.gfg.casestudy.Repository;

import com.gfg.casestudy.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface Book_Dao extends JpaRepository<Books, Integer> {
    @Query("select b from Books b where b.author=?1")
    public List<Books> findByAuthor(String author);
}


