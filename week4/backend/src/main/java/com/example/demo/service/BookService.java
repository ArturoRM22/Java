package com.example.demo.service;
import java.util.List;
import com.example.demo.model.Book;

public interface BookService {
    List<Book> findAll();
    Book getBookById(Long id);
    Book save(Book book);
    void deleteById(Long id)
}
