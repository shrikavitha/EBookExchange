package com.example.demo.model;

import jakarta.persistence.Entity;//contains full API of CRUD repository
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity//map a table
@Table(name="Sell")

public class SellModel {
       
	@Id//primary key
	private int id;
	private String title;
	private String author;
	private String emailid;
	private long price;
	public SellModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellModel(int id, String title, String author, String emailid, long price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.emailid = emailid;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	
}