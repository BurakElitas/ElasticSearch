package com.search.result.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.search.result.service.SearchService;

@RestController
@RequestMapping("api")
@CrossOrigin
public class SearchController {


	@Autowired
	private SearchService searchService;

	
	@RequestMapping(value = "/v1/public/engines/search/searchByField")
	public Page<?> searchByField(@RequestParam String q, String document, String fieldName) {
		return searchService.searchByField(q, document, fieldName);
	}
	
	@RequestMapping(value = "/v1/public/engines/search/fetchByField")
	public Page<?> fetchByField(@RequestParam String q,String document,String fieldName1,String fieldName2){
		//System.out.println(q);
		return searchService.fetchByField(q, document, fieldName1, fieldName2);
	}
	
	@RequestMapping(value = "/v1/public/engines/delete/{id}",method = RequestMethod.POST)
	public boolean deleteDocument(@PathVariable String id) {
		 return searchService.deleteDocument(id);
		
	}


}
