package model;

import java.io.Serializable;

public class Client extends User implements Serializable{
	
	private int points;
	
	private Client next;

	public Client(String documentType, String documentNumber, String name, String email, String address) {
		super(documentType, documentNumber, name, email, address);
		points = 0;
		next = null;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Client getNext() {
		return next;
	}

	public void setNext(Client next) {
		this.next = next;
	}

}
