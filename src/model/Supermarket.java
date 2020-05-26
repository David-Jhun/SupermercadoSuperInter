package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import exception.ElementRepeatedException;

public class Supermarket {
	
	private Client firstClient;
	
	private Provider firstProvider;
	
	private Management rootManagement;
	
	private Candidate rootCandidate;
	
	private ArrayList<Television> televisions;
	
	private ArrayList<Laptop> laptops;
	
	private ArrayList<Meat> meats;
	
	public Supermarket() {
		firstClient = null;
		firstProvider = null;
		rootManagement = null;
		rootCandidate = null;
		televisions = new ArrayList<Television>();
		laptops = new ArrayList<Laptop>();
		meats = new ArrayList<Meat>();
	}

	public Client getFirstClient() {
		return firstClient;
	}

	public Provider getFirstProvider() {
		return firstProvider;
	}

	public Management getRootManagement() {
		return rootManagement;
	}

	public Candidate getRootCandidate() {
		return rootCandidate;
	}

	public ArrayList<Television> getTelevisions() {
		return televisions;
	}

	public ArrayList<Laptop> getLaptops() {
		return laptops;
	}
	
	public ArrayList<Meat> getMeats(){
		return meats;
	}
	
	public void addClient(String documentType, String documentNumber, String name, String email, String address) {
		Client c = new Client(documentType, documentNumber, name, email, address);
		if( firstClient == null )
			firstClient = c;
		else 
		{
			Client temporal = firstClient;
			while( temporal.getNext() != null )
			{
				temporal = temporal.getNext();
			}
			temporal.setNext(c);
		}
	}
	
	public Client searchClient( String name ) 
	{
		Client c = null;
		if( firstClient.getName().compareToIgnoreCase(name) == 0 )
			c = firstClient;
		else
		{
			Client temporal = firstClient;
			while( temporal != null && !(temporal.getName().compareToIgnoreCase(name) == 0) )
			{
				temporal = temporal.getNext();
			}
			if( temporal != null )
				c = temporal;
		}
		return c;
	}
	
	public boolean deleteClient( String name )
	{
		boolean deleted = false;
		if( firstClient.getName().compareToIgnoreCase(name) == 0 ) {
			if( firstClient.getNext() == null )
			{
				firstClient = null;
				deleted = true;
			}
			else if( firstClient.getNext() != null ) 
			{
				firstClient = firstClient.getNext();
				deleted = true;
			}
		}else
		{
			Client previous = null;
			Client current = firstClient;
			while( current != null && !(current.getName().compareToIgnoreCase(name) == 0) )
			{
				previous = current;
				current = current.getNext();
			}
			if( current != null ) {
				previous.setNext(current.getNext());
				deleted = true;
			}
		}
		return deleted;
	}
	
	public ArrayList<Client> getArrayListClients()
	{
		ArrayList<Client> clients = new ArrayList<Client>();
		if( firstClient != null ) {
			Client temporal = firstClient;
			while( temporal != null )
			{
				clients.add(temporal);
				temporal = temporal.getNext();
			}
		}
		return clients;
	}
	
	public void addProvider(String documentType, String documentNumber, String name, String email, String cellphone, String address, int quantityOrdered, double price) 
	{
		Provider provider = new Provider(documentType, documentNumber, name, email, cellphone, address, quantityOrdered, price);
		if( firstProvider == null ) {
			firstProvider = provider;
		}else {
			Provider temporal = firstProvider;
			while( temporal.getNext() != null ) {
				temporal = temporal.getNext();
			}
			temporal.setNext(provider);
			provider.setPrevious(temporal);
		}
	}
	
	public Provider searchProvider( String name )
	{
		Provider pro = null;
		if( firstProvider.getName().equalsIgnoreCase(name) ) {
			pro = firstProvider;
		}else {
			Provider temporal = firstProvider;
			while( temporal != null && !(temporal.getName().equalsIgnoreCase(name)) ) {
				temporal = temporal.getNext();
			}
			if( temporal != null ) 
			{
				pro = temporal;
			}
		}
		return pro;
	}
	
	public boolean deleteProvider( String name )
	{
		boolean deleted = false;
		if( firstProvider.getName().equalsIgnoreCase(name) ) {
			if( firstProvider.getNext() == null )
			{
				firstProvider = null;
				deleted = true;
			}
			else if( firstProvider.getNext() != null )
			{
				firstProvider = firstProvider.getNext();
				deleted = true;
			}
		}
		else
		{
			Provider previous = null;
			Provider current = firstProvider;
			while( current != null && !(current.getName().equalsIgnoreCase(name)))
			{
				previous = current;
				current = current.getNext();
			}
			if( current != null )
			{
				if( current.getNext() == null )
				{
					previous.setNext(current.getNext());
				}
				else if( current.getNext() != null )
				{
					previous.setNext(current.getNext());
					current.getNext().setPrevious(previous);
				}
			}
		}
		return deleted;
	}
	
	public ArrayList<Provider> getArrayListProviders()
	{
		ArrayList<Provider> providers = new ArrayList<Provider>();
		if( firstProvider != null ) {
			Provider temporal = firstProvider;
			while( temporal != null ) {
				providers.add(temporal);
				temporal = temporal.getNext();
			}
		}
		return providers;
		
	}
	
	public void addManagement(String documentType, String documentNumber, String name, String email, String cellphone, String address, String position) throws ElementRepeatedException
	{
		Management m = new Management(documentType, documentNumber, name, email, cellphone, address, position);
		if( rootManagement == null )
			rootManagement = m;
		else 
			rootManagement.add(m);
	}
	
	public Management searchManagement( String name )
	{
		return rootManagement.search(name);
	}
	
	public int getWeigtManagementTree()
	{
		return rootManagement.getWeight();
	}
	
	public ArrayList<Management> managementList()
	{
		if( rootManagement == null )
			return null;
		else {
			ArrayList<Management> list = new ArrayList<Management>();
			rootManagement.inOrden(list);
			return list;
		}
			
	}
	
	public void addCandidate(String documentType, String documentNumber, String name, String email, String cellphone, String address, int yearsOfExperience) throws ElementRepeatedException
	{
		Candidate son = new Candidate(documentType, documentNumber, name, email, cellphone, address, yearsOfExperience);
		if( rootCandidate == null )
			rootCandidate = son;
		else
			rootCandidate.add(son);
	}
	
	public Candidate searchCandidate( String name )
	{
		return rootCandidate.search(name);
	}
	
	public int getWeightCandidateTree()
	{
		return rootCandidate.getWeight();
	}
	
	public ArrayList<Candidate> candidateList()
	{
		if( rootCandidate == null )
			return null;
		else
		{
			ArrayList<Candidate> list = new ArrayList<Candidate>();
			rootCandidate.inOrden(list);
			return list;
		}
	}
	
	public void addTv(String name, String brand, double price, String line, String resolution, boolean smartv, boolean wifi) 
	{
		Television tv = new Television(name, brand, price, line, resolution, smartv, wifi);
		televisions.add(tv);
	}
	
	public Television binarySearchTv( String name ) 
	{
		insertionSortTvs();
		Television searched = null;
		boolean found = false;
		int start = 0;
		int end = televisions.size() - 1;
		while( start <= end && !found )
		{
			int mid = (start + end) / 2;
			if( televisions.get(mid).getName().equalsIgnoreCase(name) )
			{
				found = true;
				searched = televisions.get(mid);
			}
			else if( televisions.get(mid).getName().compareToIgnoreCase(name) > 0 )
				end = mid - 1;
			else
				start = mid + 1;
		}
		return searched;
	}

	public boolean deleteTv( String name ) 
	{
		boolean deleted = false;
		if( !(televisions.isEmpty()) )
		{
			for( int i = 0 ; i < televisions.size() && !deleted ; i++ )
			{
				if( televisions.get(i).getName().equalsIgnoreCase(name) ) 
				{
					televisions.remove(i);
					deleted = true;
				}
			}
		}
		return deleted;
	}
	
	public void bubbleSortTvs()
	{
		for( int i = 0; i < televisions.size(); i++ )
		{
			for( int j = 0 ; j < televisions.size() - 1 - i; j++ )
			{
				if( televisions.get(j).compareTo(televisions.get(j + 1)) > 0 )
				{
					Television temporal = televisions.get(j);
					televisions.set(j, televisions.get(j + 1));
					televisions.set(j + 1, temporal);
				}
			}
		}
	}
	
	public void selectionSortTvs() 
	{
		for( int i = 0; i < televisions.size() ; i++ )
		{
			Television minor = televisions.get(i);
			int index = i;
			for( int j = i + 1 ; j < televisions.size(); j++ )
			{
				if( minor.compareTo(televisions.get(j)) > 0 )
				{
					minor = televisions.get(j);
					index = j;
				}
			}
			Television temporal = televisions.get(i);
			televisions.set(i, minor);
			televisions.set(index, temporal);
		}
	}
	
	public void insertionSortTvs()
	{
		for( int i = 0 ; i < televisions.size() ; i++ )
		{
			Television insert = televisions.get(i);
			boolean done = false;
			for( int j = i ; j > 0 && !done ; j-- )
			{
				Television current = televisions.get(j - 1);
				if( current.compareTo(insert) > 0 )
				{
					televisions.set(j, current);
					televisions.set(j - 1, insert);
				}
				else
					done = true;
			}
		}
	}
	
	public void addLaptop(String name, String brand, double price, String line, String processor, int ram, String storageType, int amountStorage)
	{
		Laptop laptop = new Laptop(name, brand, price, line, processor, ram, storageType, amountStorage);
		laptops.add(laptop);
	}
	
	public Laptop binarySearchLaptopByName( String name ) 
	{
		insertionSortLaptopsByName();
		Laptop searched = null;
		boolean found = false;
		int start = 0;
		int end = laptops.size() - 1;
		while( start <= end && !found )
		{
			int mid = (start + end) / 2;
			if( laptops.get(mid).getName().equalsIgnoreCase(name) )
			{
				found = true;
				searched = laptops.get(mid);
			}
			else if( laptops.get(mid).getName().compareToIgnoreCase(name) > 0 )
				end = mid - 1;
			else
				start = mid + 1;
		}
		return searched;
	}
	
	public Laptop binarySearchLaptopByRam( int ram ) 
	{
		bubbleSortLaptopsByRam();
		Laptop searched = null;
		boolean found = false;
		int start = 0;
		int end = laptops.size() - 1;
		while( start <= end && !found )
		{
			int mid = (start + end) / 2;
			if( laptops.get(mid).getRam() == ram )
			{
				found = true;
				searched = laptops.get(mid);
			}
			else if( laptops.get(mid).getRam() > ram )
				end = mid - 1;
			else
				start = mid + 1;
		}
		return searched;
	}

	public boolean deleteLaptop( String name )
	{
		boolean deleted = false;
		if( !(televisions.isEmpty()) )
		{
			for( int i = 0; i < laptops.size() && !deleted ; i++)
			{
				if( laptops.get(i).getName().equalsIgnoreCase(name) )
				{
					laptops.remove(i);
					deleted = true;
				}
			}
		}
		return deleted;
	}
	
	public void insertionSortLaptopsByName()
	{
		for( int i = 0 ; i < laptops.size() ; i++ )
		{
			Laptop insert = laptops.get(i);
			boolean done = false;
			for( int j = i ; j > 0 && !done ; j-- )
			{
				Laptop current = laptops.get(j - 1);
				if( current.compareTo(insert) > 0 )
				{
					laptops.set(j, current);
					laptops.set(j - 1, insert);
				}
				else
					done = true;
			}
		}
	}
	
	public void bubbleSortLaptopsByRam()
	{
		for( int i = 0; i < laptops.size(); i++ )
		{
			for( int j = 0 ; j < laptops.size() - 1 - i; j++ )
			{
				if( laptops.get(j).getRam() > laptops.get(j + 1).getRam() )
				{
					Laptop temporal = laptops.get(j);
					laptops.set(j, laptops.get(j + 1));
					laptops.set(j + 1, temporal);
				}
			}
		}
	}
	
	public void selectionSortLaptops() 
	{
		for( int i = 0; i < laptops.size() ; i++ )
		{
			Laptop minor = laptops.get(i);
			int index = i;
			for( int j = i + 1 ; j < laptops.size(); j++ )
			{
				if( minor.compareTo(laptops.get(j)) > 0 )
				{
					minor = laptops.get(j);
					index = j;
				}
			}
			Laptop temporal = laptops.get(i);
			laptops.set(i, minor);
			laptops.set(index, temporal);
		}
	}
	
	public void addMeat(String code, String name, double price, int inventory, double weight, String animal)
	{
		Meat meat = new Meat(code, name, price, inventory, weight, animal);
		meats.add(meat);
	}
	
	public void insertionSortMeatsByName()
	{
		for( int i = 0 ; i < meats.size() ; i++ )
		{
			Meat insert = meats.get(i);
			boolean done = false;
			for( int j = i ; j > 0 && !done ; j-- )
			{
				Meat current = meats.get(j - 1);
				if( current.compareTo(insert) > 0 )
				{
					meats.set(j, current);
					meats.set(j - 1, insert);
				}
				else
					done = true;
			}
		}
	}
	
	public Meat binarySearchMeatByName( String name ) 
	{
		insertionSortMeatsByName();
		Meat searched = null;
		boolean found = false;
		int start = 0;
		int end = meats.size() - 1;
		while( start <= end && !found )
		{
			int mid = (start + end) / 2;
			if( meats.get(mid).getName().equalsIgnoreCase(name) )
			{
				found = true;
				searched = meats.get(mid);
			}
			else if( meats.get(mid).getName().compareToIgnoreCase(name) > 0 )
				end = mid - 1;
			else
				start = mid + 1;
		}
		return searched;
	}
	
	public void bubbleSortMeatsByInventory()
	{
		for( int i = 0; i < meats.size(); i++ )
		{
			for( int j = 0 ; j < meats.size() - 1 - i; j++ )
			{
				if( meats.get(j).getInventory() > meats.get(j + 1).getInventory() )
				{
					Meat temporal = meats.get(j);
					meats.set(j, meats.get(j + 1));
					meats.set(j + 1, temporal);
				}
			}
		}
	}
	
	public Meat binarySearchMeatByInventory( int inventory ) 
	{
		bubbleSortMeatsByInventory();
		Meat searched = null;
		boolean found = false;
		int start = 0;
		int end = meats.size() - 1;
		while( start <= end && !found )
		{
			int mid = (start + end) / 2;
			if( meats.get(mid).getInventory() == inventory )
			{
				found = true;
				searched = meats.get(mid);
			}
			else if( meats.get(mid).getInventory() > inventory )
				end = mid - 1;
			else
				start = mid + 1;
		}
		return searched;
	}
	
	public boolean deleteMeat( String name ) 
	{
		boolean deleted = false;
		if( !(meats.isEmpty()) )
		{
			for( int i = 0; i < meats.size() && !deleted ; i++)
			{
				if( meats.get(i).getName().equalsIgnoreCase(name) )
				{
					meats.remove(i);
					deleted = true;
				}
			}
		}
		return deleted;
	}
	
	public void randomClients() throws IOException 
	{
		File file = new File("files//Random.txt");
		FileReader fr = new FileReader(file);
		BufferedReader reader = new BufferedReader(fr);
		String line = "";
		do {
			line = reader.readLine();
			String[] data = line.split(",");
			addClient(data[0], data[1], data[2], data[3], data[4]);
		}while( line != null );
		fr.close();
		reader.close();
	}
	
	public void loadFiles() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		loadClients();
		loadProviders();
		loadManagers();
		loadCandidates();
		loadTvs();
		loadLaptops();
		loadMeat();
	}
	
	public void loadClients() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File file = new File("files//clients.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		firstClient = (Client) ois.readObject();
		ois.close();
	}
	
	public void loadProviders() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File file = new File("files//providers.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		firstProvider = (Provider) ois.readObject();
		ois.close();
	}
	
	public void loadManagers() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File file = new File("files//managers.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		rootManagement = (Management) ois.readObject();
		ois.close();
	}
	
	public void loadCandidates() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File file = new File("files//candidates.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		rootCandidate = (Candidate) ois.readObject();
		ois.close();
	}
	
	public void loadTvs() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File file = new File("files//tvs.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		televisions = (ArrayList<Television>) ois.readObject();
		ois.close();
	}
	
	public void loadLaptops() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File file = new File("files//laptops.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		laptops = (ArrayList<Laptop>) ois.readObject();
		ois.close();
	}
	
	public void loadMeat() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File file = new File("files//meat.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		meats = (ArrayList<Meat>) ois.readObject();
		ois.close();
	}
	
	public void saveFiles()throws FileNotFoundException, IOException
	{
		serializeClients();
		serializeProviders();
		serializeManagers();
		serializeCandidates();
		serializeTvs();
		serializeLaptops();
		serializeMeat();
	}
	
	public void serializeClients() throws FileNotFoundException, IOException
	{
		File file = new File("files//clients.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(firstClient);
		oos.close();
	}
	
	public void serializeProviders() throws FileNotFoundException, IOException
	{
		File file = new File("files//providers.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(firstProvider);
		oos.close();
	}
	
	public void serializeManagers()throws FileNotFoundException, IOException
	{
		File file = new File("files//managers.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(rootManagement);
		oos.close();
	}
	
	public void serializeCandidates()throws FileNotFoundException, IOException
	{
		File file = new File("files//candidates.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(rootCandidate);
		oos.close();
	}
	
	public void serializeTvs()throws FileNotFoundException, IOException
	{
		File file = new File("files//tvs.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(televisions);
		oos.close();
	}
	
	public void serializeLaptops()throws FileNotFoundException, IOException
	{
		File file = new File("files//laptops.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(laptops);
		oos.close();
	}
	
	public void serializeMeat()throws FileNotFoundException, IOException
	{
		File file = new File("files//meat.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(meats);
		oos.close();
	}
	
	public void printAllComputers() throws FileNotFoundException
	{
		File file = new File("files//Laptops-report.txt");
		PrintWriter writer = new PrintWriter(file);
		if( !(laptops.isEmpty()) ) 
		{
			for( int i = 0 ; i < laptops.size() ; i++ ) 
			{
				writer.println();
				writer.println(laptops.get(i).getName());
				writer.println(laptops.get(i).calculatePrice());
				writer.println();
			}
		}
		writer.close();
	}
	
}
