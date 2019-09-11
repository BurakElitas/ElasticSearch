package com.search.main.service;

import org.springframework.data.domain.Page;

import com.search.main.document.Article;
import com.search.main.document.Book;

public interface SearchService {
	Page<Article> searchInArticles(String q);

	Page<Book> searchInBooks(String q);

	Iterable<Book> allBooks();

	Iterable<Article> allArticles();

	Page<Book> basicFiltering(String genre, String q);

	Page<Book> range(double from, double to, String q);

	Page<?> searchByField(String q, String document, String fieldName);

	Page<?> fetchByField(String q, String document, String fieldName1, String fieldName2);
	
	boolean deleteDocument(String id);
	boolean addBook(Book book);
}
