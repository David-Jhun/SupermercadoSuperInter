package model;

import java.io.Serializable;
import java.util.ArrayList;

import exception.ElementRepeatedException;

public class Management extends Worker implements Salary, Serializable, Comparable<Management>{
	
	private double salary;
	private String position;
	
	private Management leftSon;
	private Management rightSon;

	public Management(String documentType, String documentNumber, String name, String email, 
			String cellphone, String address, String position) 
	{
		super(documentType, documentNumber, name, email, cellphone, address);
		this.position = position;
		leftSon = null;
		rightSon = null;
	}

	public double getSalary() {
		return salary;
	}

	public String getPosition() {
		return position;
	}
	
	public Management getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(Management leftSon) {
		this.leftSon = leftSon;
	}

	public Management getRightSon() {
		return rightSon;
	}

	public void setRightSon(Management rightSon) {
		this.rightSon = rightSon;
	}
	
	public void add( Management son ) throws ElementRepeatedException 
	{
		if( getName().compareToIgnoreCase(son.getName()) == 0 )
			throw new ElementRepeatedException("This element already exists.");
		
		if( compareTo(son) > 0 )
		{
			if(leftSon == null)
				leftSon = son;
			else
				leftSon.add(son);
		}
		else
		{
			if( rightSon == null )
				rightSon = son;
			else
				rightSon.add(son);
		}
			
	}
	
	public Management search( String name )
	{
		if( getName().equalsIgnoreCase(name) )
			return this;
		else if( getName().compareToIgnoreCase(name) > 0 )
			return (leftSon == null) ? null: leftSon.search(name);
		else
			return (rightSon == null) ? null: rightSon.search(name);
	}
	
	public int getWeight()
	{
		int p1 = (leftSon == null) ? 0 : leftSon.getWeight();
		int p2 = (rightSon == null) ? 0 : rightSon.getWeight();
		return 1 + p1 + p2;
	}
	
	public void inOrden( ArrayList<Management> list )
	{
		if( leftSon != null )
			leftSon.inOrden(list);
		
		list.add(this);
		
		if( rightSon != null )
			rightSon.inOrden(list);
			
	}

	@Override
	public double totalSalary() 
	{
		return salary;
	}

	@Override
	public int compareTo(Management o) {
		if( getName().compareToIgnoreCase(o.getName()) < 0 )
			return -1;
		else if( getName().compareToIgnoreCase(o.getName()) < 0 )
			return 1;
		else 
			return (int)(salary - o.salary);
			
	}
	
}
