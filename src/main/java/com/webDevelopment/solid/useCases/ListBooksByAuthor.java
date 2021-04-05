package com.webDevelopment.solid.useCases;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.Formatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.webDevelopment.solid.SolidApplication.books;

import java.util.List;

@Service
public class ListBooksByAuthor {

    @Autowired
    public ListBooksByAuthor() {

    }

    public String execute(String author){
        String libros = "";
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getAuthor().equals(author)){
                libros += books.get(i).titleAndAuthor();
            }
        }
        return libros;
    }
}
