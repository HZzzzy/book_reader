package com.example.demo.service;

import com.example.demo.Entity.Apply;
import com.example.demo.Entity.Book;
import com.example.demo.dao.ApplyDao;
import com.example.demo.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public List<Book> findList(Book book) {
        return bookDao.findList(book);
    }
}
