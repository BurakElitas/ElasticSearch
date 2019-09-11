package com.search.main.dao;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.search.main.document.Book;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String> {
	Page<Book> search(QueryBuilder q);
}
