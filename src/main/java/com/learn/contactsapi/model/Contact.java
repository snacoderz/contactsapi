package com.learn.contactsapi.model;


public class Contact {
	
	private String contactId;
	private String name;
	private String email;
	private String category;
	
	public Contact() {}
	
	public Contact(String contactId, String name, String email, String category) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.email = email;
		this.category = category;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	

}
