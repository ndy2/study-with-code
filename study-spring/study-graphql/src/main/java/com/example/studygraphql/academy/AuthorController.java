package com.example.studygraphql.academy;

import java.util.Optional;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthorController {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	/**
	 * query {
	 *   authors{
	 *     id
	 *     name
	 *     books {
	 *       title
	 *     }
	 *   }
	 * }
	 */
	@QueryMapping("authors")
	Iterable<Author> authors(){
		return authorRepository.findAll();
	}

	/**
	 * query {
	 *   authorById(id: 1){
	 *     id
	 *     name
	 *     books {
	 *       title
	 *     }
	 *   }
	 * }
	 */
	@QueryMapping
	Optional<Author> authorById(@Argument Long id){
		return authorRepository.findById(id);
	}

	@MutationMapping
	Book addBook(@Argument BookInput book){
		Book b = new Book(
				book.title,
				book.publisher,
				authorRepository.findById(book.authorId).orElseThrow()
		);

		return bookRepository.save(b);
	}

	@Data
	static class BookInput{
		String title;
		String publisher;
		Long authorId;
	}
}
