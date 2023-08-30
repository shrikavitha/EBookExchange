package com.example.demo.model;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;//contains full API of CRUD repository
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity//map a table
@Table(name="Book")
public class ApiModel {
	
	@Id//primary key
	private int id;
	private String title;
	private String category;
	private String author;
	private long price;
	
	@OneToOne(cascade = CascadeType.ALL)//to maintain relation ship to entity
	@JoinColumn(name="fk_buymodelid")
	private BuyModel bm;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name= "title")
	private List<SellModel> ti;
	

	public ApiModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiModel(int id, String title, String category, String author, long price, BuyModel bm,List<SellModel> ti) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.author = author;
		this.price = price;
		this.bm = bm;
		this.ti = ti;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public BuyModel getBm() {
		return bm;
	}

	public void setBm(BuyModel bm) {
		this.bm = bm;
	}
	public List<SellModel> getTi() {
		return ti;
	}
	public void setVh(List<SellModel>ti) {
		this.ti = ti;
	}
}