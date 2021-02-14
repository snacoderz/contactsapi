package com.learn.contactsapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.contactsapi.dao.ContactDao;
import com.learn.contactsapi.exceptions.ContactNotFoundException;
import com.learn.contactsapi.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	
	private ContactDao dao;
	
	@Autowired
	public ContactServiceImpl(ContactDao dao) {
		this.dao = dao;
	}

	@Override
	public Contact addContact(Contact contact) {
		contact.setContactId(UUID.randomUUID().toString());
		return dao.addContact(contact);
	}

	@Override
	public Contact getContact(String contactId) throws ContactNotFoundException {
		Contact contact = dao.getContact(contactId);
		if(contact == null) {
			throw new ContactNotFoundException("Contact not found");
		}
		return contact;
	}

	@Override
	public List<Contact> getAllContacts() {
		return dao.getAllContacts();
	}

	@Override
	public void deleteContact(String contactId) {
		dao.deleteContact(contactId);
		
	}

}
