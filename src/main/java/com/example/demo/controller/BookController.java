package com.example.demo.controller;

import com.example.demo.Entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Book> getList(HttpServletRequest request) {
        Book book = new Book();
        if (null != request.getParameter("likeName")) {
            book.setBookName(request.getParameter("likeName"));
        }
        return bookService.findList(book);
    }



}
