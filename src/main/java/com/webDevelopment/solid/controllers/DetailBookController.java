package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.useCases.DetailBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.webDevelopment.solid.SolidApplication.LOGGER;

@RestController
@RequestMapping(value = "/title")
public class DetailBookController {

    private DetailBook detailBook;

    @Autowired
    public DetailBookController(DetailBook detailBook) {
        this.detailBook = detailBook;
    }

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> listBooksByAuthor(@RequestBody String title){

        HttpStatus codigo = HttpStatus.FORBIDDEN;
        String detalles = null;
        try {
            detalles = detailBook.execute(title);
            codigo = (detalles != null) ? HttpStatus.OK : HttpStatus.CONFLICT;
        } catch (Exception e){
            LOGGER.error("DetailBookController.detailBook causa: " + e.toString());
        }

        return ResponseEntity.status(codigo).body(detalles);
    }
}
