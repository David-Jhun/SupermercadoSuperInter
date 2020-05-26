package model;

import java.io.Serializable;
import java.util.ArrayList;

import exception.ElementRepeatedException;

public class Candidate extends Worker implements Serializable, Comparable<Candidate>{
	
	private int yearsOfExperience;
	
	private Candidate leftSon;
	private Candidate rightSon;
	
	public Candidate(String documentType, String documentNumber, String name, String email, String cellphone, String address, 
			int yearsOfExperience) 
	{
		super(documentType, documentNumber, name, email, cellphone, address);
		this.yearsOfExperience = yearsOfExperience;
		leftSon = null;
		rightSon = null;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public Candidate getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(Candidate leftSon) {
		this.leftSon = leftSon;
	}

	public Candidate getRightSon() {
		return rightSon;
	}

	public void setRightSon(Candidate rightSon) {
		this.rightSon = rightSon;
	}
	
	public void add( Candidate son ) throws ElementRepeatedException
	{
		if( compareTo(son) == 0 )
			throw new ElementRepeatedException("This element already exits.");
		
		if( compareTo(son) > 0 ) {
			if( leftSon == null )
				leftSon = son;
			else
				leftSon.add(son);
		}else {
			if( rightSon == null )
				rightSon = son;
			else
				rightSon.add(son);
		}
		
	}
	
	public Candidate search( String name ) 
	{
		if( getName().equalsIgnoreCase(name) )
			return this;
		else if( getName().compareToIgnoreCase(name) > 0 )
			return (leftSon == null) ? null : leftSon.search(name);
		else
			return (rightSon == null) ? null : rightSon.search(name);
			
	}
	
	public int getWeight()
	{
		int p1 = (leftSon == null) ? 0 : leftSon.getWeight();
		int p2 = (rightSon == null) ? 0 : rightSon.getWeight();
		return 1 + p1 + p2;
	}
	
	public void inOrden( ArrayList<Candidate> list )
	{
		if( leftSon != null )
			leftSon.inOrden(list);
		
		list.add(this);
		
		if( rightSon != null )
			rightSon.inOrden(list);
	}

	@Override
	public int compareTo(Candidate c) {
		
		if( getName().compareToIgnoreCase(c.getName()) < 0 )
			return -1;
		else if(getName().compareToIgnoreCase(c.getName()) > 0)
			return 1;
		else 
			return yearsOfExperience - c.yearsOfExperience;
	}
	
	
	
}
