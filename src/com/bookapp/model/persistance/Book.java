package com.bookapp.model.persistance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "book_table")
public class Book {
	@Id
	@GeneratedValue
	private int id;
    @NotEmpty(message="isbn can not left blank")
	private String isbn;
    @NotEmpty(message="title can not left blank")
	private String title;
    @NotEmpty(message="author can not left blank")
	private String author;
    @NotNull(message="price can not null")
    @Min(value=0,message="min price should be more than 10")
    @Max(value=1000,message="max price should be less than 1000")
	private Double price;
    @Email
    @NotEmpty(message="email can left blank")
    private String pubEmail;
    private String publisher;
  
  
   @NotNull(message="date can not be left blank")
   @Past
   @Temporal(TemporalType.DATE)
   @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date pubDate;
	public String getPubEmail() {
	return pubEmail;
}

public void setPubEmail(String pubEmail) {
	this.pubEmail = pubEmail;
}

public String getPublisher() {
	return publisher;
}

public void setPublisher(String publisher) {
	this.publisher = publisher;
}



	public Date getPubDate() {
	return pubDate;
}

public void setPubDate(Date pubDate) {
	this.pubDate = pubDate;
}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Book( String isbn, String title, String author, Double price) {
		super();
		
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public Book() {

	}
}
