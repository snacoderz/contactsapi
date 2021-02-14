package com.learn.contactsapi.dao;

import java.util.List;

import com.learn.contactsapi.model.Contact;

public interface ContactDao {
	
	Contact addContact(Contact contact);
	Contact getContact(String contactId);
	List<Contact> getAllContacts();
	void deleteContact(String contactId);
	
}
