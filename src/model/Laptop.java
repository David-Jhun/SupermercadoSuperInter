package model;

import java.io.Serializable;

public class Laptop extends HouseholdAppliance implements Serializable, Component, Comparable<Laptop>{
	
	private String processor;
	private int ram;
	private String storageType;
	private int amountStorage;

	public Laptop(String name, String brand, double price, String line, String processor, int ram, String storageType, int amountStorage) {
		super(name, brand, price, line);
		this.processor = processor;
		this.ram = ram;
		this.storageType = storageType;
		this.amountStorage = amountStorage;
	}

	public String getProcessor() {
		return processor;
	}

	public int getRam() {
		return ram;
	}

	public String getStorageType() {
		return storageType;
	}

	public int getAmountStorage() {
		return amountStorage;
	}

	@Override
	public String toString() {
		String m = "";
		m += "\nLaptop";
		m += super.toString();
		m += "\nProcessor: " + processor;
		m += "\nRam: " + ram;
		m += "\nStorage type: " + storageType;
		m += "\nAmount of storage: " + amountStorage;
		return m;
	}

	@Override
	public double calculatePrice() 
	{
		return (double)getPrice() * amountStorage;
	}

	@Override
	public int compareTo(Laptop o) {
		
		if( getName().compareToIgnoreCase(o.getName()) < 0 )
			return -1;
		else if( getName().compareToIgnoreCase(o.getName()) > 0 )
			return 1;
		else
			return ram - o.ram;
					
	}
	
}
