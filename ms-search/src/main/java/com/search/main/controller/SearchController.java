package com.search.main.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.search.main.document.Article;
import com.search.main.document.Book;
import com.search.main.service.SearchService;

@RestController
@RequestMapping("api")
@CrossOrigin 
public class SearchController {

//	@Autowired   
//	private RestTemplate restTemplate;

	@Autowired
	private SearchService searchService;

	@RequestMapping(value = "/v1/public/engines/search/article", method = RequestMethod.GET, produces = "application/json")
	public Page<Article> searchArticle(@RequestParam String q) {
		return searchService.searchInArticles(q);
	}

	@RequestMapping(value = "/v1/public/engines/search/books", method = RequestMethod.GET)
	public Iterable<Book> allBooks() {
		return searchService.allBooks();
	} 
 
	@RequestMapping(value = "/v1/public/engines/search/articles", method = RequestMethod.GET)
	public Iterable<Article> allArticles() {
		return searchService.allArticles();
	}

	@RequestMapping(value = "/v1/public/engines/search/book", method = RequestMethod.GET, produces = "application/json")
	public Page<Book> searchBooks(@RequestParam String q) {
		return searchService.searchInBooks(q);
	}

	@RequestMapping(value = "/v1/public/engines/search/filters/books/genre")
	public Page<Book> basicFiltering(@RequestParam String genre, String q) {
		return searchService.basicFiltering(genre, q);
	}

	@RequestMapping(value = "/v1/public/engines/search/filters/books/range")
	public Page<Book> range(@RequestParam double from, double to, String q) {
		return searchService.range(from, to, q);
	}

	@RequestMapping(value = "/v1/public/engines/search/searchByField")
	public Page<?> searchByField(@RequestParam String q, String document, String fieldName) {
		return searchService.searchByField(q, document, fieldName);
	}
	
	@RequestMapping(value = "/v1/public/engines/search/fetchByField")
	public Page<?> fetchByField(@RequestParam String q,String document,String fieldName1,String fieldName2){
		return searchService.fetchByField(q, document, fieldName1, fieldName2);
	}
	
	@RequestMapping(value = "/v1/public/engines/delete/{id}",method = RequestMethod.POST)
	public boolean deleteDocument(@PathVariable String id) {
		 return searchService.deleteDocument(id);
		 
	} 
	@RequestMapping(value = "/v1/public/engines/add/book",method = RequestMethod.POST,produces = "application/json")
	public boolean addBook(@ModelAttribute Book book) {
		int d=(int)(Math.random()*1000);
		book.setId(String.valueOf(d)); 
		 return searchService.addBook(book);
		 
		 
	} 
	
//	@RequestMapping(value = "/v1/public/engines/synonym")
//	public void Synonym(@RequestBody String[] array) {
//		
//		//restTemplate.put("http://localhost:9200/books?pretty", array, uriVariables);
//	}

}
