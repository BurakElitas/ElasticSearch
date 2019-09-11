package com.search.main.document;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "books", type = "book")
public class Book {
	
	@Id
	public String id;
	
	@NotBlank(message = "Name is mandatory")
	public String name;
	
	@NotBlank(message = "Price is mandatory")
	public double price;
	public String summary;
	@NotBlank(message = "Author is mandatory")
	public String author;
	public String type;
	
	public Book() {
		
	}

	public Book(String id, String name, double price,String summary,String author, String type) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
		this.author=author;
		this.summary=summary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String typex) { 
		this.type = typex;
	}
	
}
