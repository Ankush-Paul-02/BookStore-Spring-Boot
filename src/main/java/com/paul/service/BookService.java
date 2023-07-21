package com.paul.service;

import com.paul.entity.Book;
import com.paul.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
