package com.learn.contactsapi.service;

import java.util.List;

import com.learn.contactsapi.exceptions.ContactNotFoundException;
import com.learn.contactsapi.model.Contact;

public interface ContactService {
	
	Contact addContact(Contact contact);
	Contact getContact(String contactId) throws ContactNotFoundException;
	List<Contact> getAllContacts();
	void deleteContact(String contactId);

}
