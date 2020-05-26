package model;

public abstract class Product {
	
	private String code;
	private String name;
	private double price;
	private int inventory;
	private double weight;
	
	public Product(String code, String name, double price, int inventory, double weight) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.inventory = inventory;
		this.weight = weight;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getInventory() {
		return inventory;
	}

	public double getWeight() {
		return weight;
	}
	
}
