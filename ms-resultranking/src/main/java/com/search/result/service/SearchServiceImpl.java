package com.search.result.service;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

import com.search.result.dao.ArticleRepository;
import com.search.result.dao.BookRepository;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ArticleRepository articleRepository;


	@Override
	public Page<?> searchByField(String q, String document, String fieldName) {

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

}
