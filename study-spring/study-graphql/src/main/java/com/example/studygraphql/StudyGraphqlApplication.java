package com.example.studygraphql;

import java.util.List;

import com.example.studygraphql.academy.Author;
import com.example.studygraphql.academy.AuthorRepository;
import com.example.studygraphql.academy.Book;
import com.example.studygraphql.academy.BookRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudyGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyGraphqlApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
		return args -> {
			Author josh = authorRepository.save(new Author(null, "Josh Long"));
			Author mark = authorRepository.save(new Author(null, "Josh Long"));

			bookRepository.saveAll(List.of(
					new Book("book1", "publisher1", josh),
					new Book("book2", "publisher1", mark),
					new Book("book3", "publisher1", mark)
			));
		};
	}

}
