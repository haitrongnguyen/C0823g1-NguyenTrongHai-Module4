package com.example.bookmanagement;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class BookFormatter implements Formatter<Book> {
    private IBookService bookService;
    @Autowired
    public BookFormatter(IBookService bookService){
        this.bookService = bookService;
    }
    @Override
    public Book parse(String id, Locale locale) throws ParseException {
        Optional<Book> bookOptional = Optional.ofNullable(bookService.findById(Long.parseLong(id)));
        return bookOptional.orElse(null);
    }

    @Override
    public String print(Book object, Locale locale) {
        return null;
    }
}
