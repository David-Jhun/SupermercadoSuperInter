package model;

import java.io.Serializable;

public class Provider extends Worker implements Commodity, Serializable{
	
	private String product;
	private int quantityOrdered;
	private double price;
	
	private Provider previous;
	private Provider next;

	public Provider(String documentType, String documentNumber, String name, String email, 
			String cellphone, String address, int quantityOrdered, double price)
	{
		super(documentType, documentNumber, name, email, cellphone, address);
		this.quantityOrdered = quantityOrdered;
		this.price = price;
		previous = null;
		next = null;
	}
	
	public String getProduct() {
		return product;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public double getPrice() {
		return price;
	}
	
	public Provider getPrevious() {
		return previous;
	}

	public void setPrevious(Provider previous) {
		this.previous = previous;
	}

	public Provider getNext() {
		return next;
	}

	public void setNext(Provider next) {
		this.next = next;
	}

	@Override
	public double merchandiseCost() {
		return price * quantityOrdered;
	}
	
}
