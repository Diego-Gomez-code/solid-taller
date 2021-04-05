package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

@Service
public class BookValidator implements Validator{
    @Override
    public Boolean Validate(Book book) {
        if(book.validate()){
            return true;
        }
        return false;
    }
}
