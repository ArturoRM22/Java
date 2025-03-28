package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @Override
    public Book getBookId(Long id){
        return bookRepository.findAll(id).orElse(null);
    }

    @Override
    public Book save(Book book){
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }
}