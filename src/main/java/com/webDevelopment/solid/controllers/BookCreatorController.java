package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.useCases.BookCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.webDevelopment.solid.SolidApplication.LOGGER;

@RestController
@RequestMapping(value = "/book")
public class BookCreatorController {

    private BookCreator bookCreator;

    @Autowired
    public BookCreatorController(BookCreator bookCreator) {
        this.bookCreator = bookCreator;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createBook(@RequestBody Book book){
        //LOGGER.error(book.getTitle());
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        Book b = null;
        try {
            b = bookCreator.execute(book);
            codigo = (b != null) ? HttpStatus.OK : HttpStatus.CONFLICT;
        } catch (Exception e){
            LOGGER.error("BookCreatorController.createBook causa: " + e.toString());
        }

        return ResponseEntity.status(codigo).body(null);
    }

}
