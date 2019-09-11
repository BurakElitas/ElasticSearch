package com.search.main.service;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

import com.search.main.dao.ArticleRepository;
import com.search.main.dao.BookRepository;
import com.search.main.document.Article;
import com.search.main.document.Book;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public Page<Article> searchInArticles(String q) {
		QueryBuilder qb = QueryBuilders.queryStringQuery("*" + q + "*");
		return articleRepository.search(qb);
	}

	@Override
	public Page<Book> searchInBooks(String q) {

		if(q.isEmpty())
			return null;
		QueryBuilder qb = QueryBuilders.queryStringQuery("*" + q + "*").field("name").field("summary").field("author").field("type");
		return bookRepository.search(qb);
		
	}

	@Override
	public Iterable<Book> allBooks() {
		return bookRepository.findAll();
	}
	

	@Override
	public Iterable<Article> allArticles() {
		return articleRepository.findAll();
	}


	@Override
	public Page<Book> basicFiltering(String genre, String q) {

		QueryBuilder query = QueryBuilders.queryStringQuery(genre).field("type");
		QueryBuilder que = QueryBuilders.boolQuery().must(QueryBuilders.queryStringQuery("*" + q + "*")).filter(query);

		return bookRepository.search(que);
	}

	@Override
	public Page<Book> range(double from, double to, String q) {
		QueryBuilder query = QueryBuilders.rangeQuery("price").from(from).to(to).includeLower(true).includeUpper(false);

		QueryBuilder que = QueryBuilders.boolQuery().must(QueryBuilders.queryStringQuery("*" + q + "*")).filter(query);
		return bookRepository.search(que);
	}

	@Override
	public Page<?> searchByField(String q, String document, String fieldName) {

		// QueryBuilder query = QueryBuilders.termQuery(fieldName, q);
		QueryBuilder query;
		double newq;

		try {
			newq = Double.parseDouble(q);

			query = QueryBuilders.matchQuery(fieldName, newq);
		} catch (Exception ex) {
			query = QueryBuilders.queryStringQuery("*" + q + "*").field(fieldName);

		}

		if (document.equals("books"))
			return bookRepository.search(query);
		else if (document.equals("articles"))
			return articleRepository.search(query);
 
		return null; 
	} 

	@Override
	public Page<?> fetchByField(String q, String document, String fieldName1, String fieldName2) {

		QueryBuilder query;
		double newq;

		try {
			newq = Double.parseDouble(q);

			query = QueryBuilders.multiMatchQuery(newq, fieldName1, fieldName2);
		} catch (Exception ex) {
			query = QueryBuilders.queryStringQuery("*" + q + "*").field(fieldName1).field(fieldName2);

		}


		if (document.equals("books"))
			return bookRepository.search(query);
		else if (document.equals("articles"))
			return articleRepository.search(query);

		return null;

	}

	@Override
	public boolean deleteDocument(String id) {
		bookRepository.deleteById(id);
		boolean result=bookRepository.existsById(id);
		return result;
		
		
	}

	@Override
	public boolean addBook(Book book) {
		Book b=bookRepository.save(book);
		return b!=null?true:false;
	}

}
