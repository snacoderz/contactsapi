package com.learn.contactsapi.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.learn.contactsapi.model.Contact;

@Repository
public class ContactDaoImpl implements ContactDao{

	private Map<String, Contact> contacts = new HashMap<>();
	
	@Override
	public Contact addContact(Contact contact) {
		contacts.put(contact.getContactId(), contact);
		return contact;
	}

	@Override
	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}

	@Override
	public List<Contact> getAllContacts() {
		return new ArrayList<>(contacts.values());
	}

	@Override
	public void deleteContact(String contactId) {
		contacts.remove(contactId);
	}
}
