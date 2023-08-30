 package com.example.demo.model;

import jakarta.persistence.Entity;//it contains full api of crud repository
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity//map a table
@Table(name="Buyer")
public class BuyModel {
	
	@Id//primary key-unique values
	private int id;
	private String title;
	private String author;
	private String address;
	private String email;
	private String paymentmode;
	private long phonenumber;
	public BuyModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyModel(int id, String title, String author, String address, String email, String paymentmode,
			long phonenumber) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.address = address;
		this.email = email;
		this.paymentmode = paymentmode;
		this.phonenumber = phonenumber;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
}