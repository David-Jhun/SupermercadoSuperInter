package model;

public abstract class Worker {
	
	private String documentType;
	private String documentNumber;
	private String name;
	private String email;
	private String cellphone;
	private String address;
	
	public Worker(String documentType, String documentNumber, String name, String email, String cellphone, String address)
	{
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.name = name;
		this.email = email;
		this.cellphone = cellphone;
		this.address = address;
	}

	public String getDocumentType() {
		return documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public String getAddress() {
		return address;
	}
	
	

}
