package com.webDevelopment.solid;

import com.webDevelopment.solid.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SolidApplication {

	public static List<Book> books = new ArrayList<>();
	public static final Logger LOGGER = LoggerFactory.getLogger(SolidApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SolidApplication.class, args);
	}

}
