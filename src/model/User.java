package model;

public abstract class User {
	
	private String documentType;
	private String documentNumber;
	private String name;
	private String email;
	private String address;
	
	public User(String documentType, String documentNumber, String name, String email, String address) {
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.name = name;
		this.email = email;
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

	public String getAddress() {
		return address;
	}
	
	

}
