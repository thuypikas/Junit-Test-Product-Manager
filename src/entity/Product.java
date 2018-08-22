package entity;

import javax.persistence.*;

@Entity
@Table(name="Product")
public class Product {
	@Id
	@Column(name="id")
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="amount")
	private int amount;
	@Column(name="price")
	private double price;
	@Column(name="brand")
	private String brand;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String id, String name, int amount, double price, String brand) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.brand = brand;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	

}
