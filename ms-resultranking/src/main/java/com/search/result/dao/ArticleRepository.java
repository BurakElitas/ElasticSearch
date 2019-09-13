package com.search.result.dao;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.search.result.document.Article;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {

	Page<Article> search(QueryBuilder q);

}
