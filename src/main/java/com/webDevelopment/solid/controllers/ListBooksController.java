package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.useCases.ListBooksByAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.webDevelopment.solid.SolidApplication.LOGGER;

@RestController
@RequestMapping(value = "/author")
public class ListBooksController {

    private ListBooksByAuthor listBooksByAuthor;

    @Autowired
    public ListBooksController(ListBooksByAuthor listBooksByAuthor) {
        this.listBooksByAuthor = listBooksByAuthor;
    }

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> listBooksByAuthor(@RequestBody String author){

        HttpStatus codigo = HttpStatus.FORBIDDEN;
        String libros = null;
        try {
            libros = listBooksByAuthor.execute(author);
            codigo = (libros != null) ? HttpStatus.OK : HttpStatus.CONFLICT;
        } catch (Exception e){
            LOGGER.error("ListBooksController.listBooksByAuthor causa: " + e.toString());
        }

        return ResponseEntity.status(codigo).body(libros);
    }
}
