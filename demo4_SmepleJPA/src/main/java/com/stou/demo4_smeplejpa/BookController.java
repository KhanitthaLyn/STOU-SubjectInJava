package com.stou.demo4_smeplejpa;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.*;

import static com.stou.demo4_smeplejpa.BookService.*;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String index(Model model) {
        Book book = new Book("99444", "Spring Boot Web", "Mana", 300);
        bookService.addBook(book);
        model.addAttribute("book", book);
        return "index";
    }
}
