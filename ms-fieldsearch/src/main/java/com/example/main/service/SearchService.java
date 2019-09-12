package com.example.main.service;

import org.springframework.data.domain.Page;




public interface SearchService {
	

	Page<?> searchByField(String q, String document, String fieldName);

	Page<?> fetchByField(String q, String document, String fieldName1, String fieldName2);
	Iterable<com.example.main.document.Book> allBooks();

}
