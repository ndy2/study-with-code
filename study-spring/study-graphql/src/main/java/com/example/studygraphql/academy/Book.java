package com.example.studygraphql.academy;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Book {


	@Id
	@GeneratedValue
	private Long id;

	private String title;

	private String publisher;

	@ManyToOne(fetch = FetchType.LAZY)
	private Author author;

	public Book(String title, String publisher, Author author) {
		this.title = title;
		this.publisher = publisher;
		this.author = author;
	}
}
