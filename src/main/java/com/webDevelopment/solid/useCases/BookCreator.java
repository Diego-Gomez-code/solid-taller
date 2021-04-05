package com.webDevelopment.solid.useCases;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.webDevelopment.solid.SolidApplication.books;

@Service
public class BookCreator {

    private Validator validator;

    @Autowired
    public BookCreator(Validator validator) {
        this.validator = validator;
    }

    public Book execute(Book book){
        if(this.validator.Validate(book)){
            books.add(book);
            return book;
        }
        return null;
    }
}
