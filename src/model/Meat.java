package model;

import java.io.Serializable;

public class Meat extends Product implements Serializable, Comparable<Meat>{
	
	private String animal;
	
	public Meat(String code, String name, double price, int inventory, double weight, String animal)
	{
		super(code, name, price, inventory, weight);
		this.animal = animal;
	}

	public String getAnimal() {
		return animal;
	}

	@Override
	public int compareTo(Meat o) {
		
		if( getName().compareToIgnoreCase(o.getName()) < 0 )
			return -1;
		else if( getName().compareToIgnoreCase(o.getName()) > 0 )
			return 1;
		else
			return getInventory() - o.getInventory();
		
	}
	
}
