package com.search.result.document;



import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "books", type = "book")
public class Book {
	
	@Id
	private String id;
	private String name;
	private double price;
	public String summary;
	public String author;
	public String type;
	
	public Book() {
		
	}

	public Book(String id, String name, double price,String summary,String author, String types) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.type = types;
		this.author=author;
		this.summary=summary;
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

	public String getTypes() {
		return type;
	}

	public void setTypes(String types) {
		this.type = types;
	}

}
