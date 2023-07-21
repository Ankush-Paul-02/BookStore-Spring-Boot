package com.paul.controller;

import com.paul.entity.Book;
import com.paul.entity.MyBookList;
import com.paul.service.BookService;
import com.paul.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    MyBookListService myBookListService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView availableBooks() {
        List<Book> bookList = bookService.getAllBook();
        //? ModelAndView modelAndView = new ModelAndView();
        //? modelAndView.setViewName("myBooks");
        //? modelAndView.addObject("book", bookList);
        return new ModelAndView("availableBooks", "book", bookList);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        bookService.save(b);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String myBooks(Model model) {
        List<MyBookList> myBookLists = myBookListService.getMyBookLists();
        model.addAttribute("myBooks", myBookLists);
        return "myBooks";
    }

    @RequestMapping("/my_books/{id}")
    public String getMyBookList(@PathVariable("id") int id) {
        Optional<Book> book = bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(
                book.get().getId(),
                book.get().getTitle(),
                book.get().getAuthor(),
                book.get().getPrice()
        );
        myBookListService.saveMyBook(myBookList);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Optional<Book> book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "editBook";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBookById(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "redirect:/available_books";
    }

}
