package com.example.main.dao;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.main.document.Article;



@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {

	Page<Article> search(QueryBuilder q);

}
