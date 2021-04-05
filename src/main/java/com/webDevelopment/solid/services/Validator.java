package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

@Service
public interface Validator {
    Boolean Validate(Book book);
}
