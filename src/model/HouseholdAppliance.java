package model;

public abstract class HouseholdAppliance {
	
	private String name;
	private String brand;
	private double price;
	private String line;
	
	public HouseholdAppliance(String name, String brand, double price, String line) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.line = line;
	}
	
	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public double getPrice() {
		return price;
	}

	public String getLine() {
		return line;
	}

	@Override
	public String toString() {
		String m = "";
		m += "\nHousehold Appliance.";
		m += "\nName: " + name;
		m += "\nBrand: " + brand;
		m += "\nPrice: " + price;
		m += "\nLine: " + price;
		return m;
	}
	
}
