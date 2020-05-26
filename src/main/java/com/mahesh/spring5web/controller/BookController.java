package com.mahesh.spring5web.controller;

import com.mahesh.spring5web.repositories.BookRepsitory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepsitory bookRepsitory;

    public BookController(BookRepsitory bookRepository){
        this.bookRepsitory=bookRepository;
    }

    @RequestMapping("/books")
    public String getBook(Model model){
    model.addAttribute("books",bookRepsitory.findAll());
    return "books";
    }
}
