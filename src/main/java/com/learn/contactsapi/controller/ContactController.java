package com.learn.contactsapi.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.contactsapi.exceptions.ContactNotFoundException;
import com.learn.contactsapi.model.Contact;
import com.learn.contactsapi.service.ContactService;

/*
 * GET /contacts/{contactid}
 * GET /contacts
 * GET /contacts/{category}
 * GET /contacts?category={category}
 * POST /contacts
 * DELETE /contacts/{contactid} 
 * 
*/

@RestController
@RequestMapping("/api/v1")
public class ContactController {

	private ContactService service;
	
	@Autowired
	public ContactController(ContactService service) {
		this.service = service;
	}

	@GetMapping("/info")
//	@RequestMapping(path = "/info", method = RequestMethod.GET)
	public String apiInfo(@RequestParam("catg") String category, @RequestParam String city) {
		return "Contacts API is UP and Running : Query parameters : " + category + ",  " + city;
	}
	
	@GetMapping("/contacts")
	public List<Contact> getContacts() {
		return service.getAllContacts();

	}
	
	@GetMapping("/contacts/{contactId}")
	public Contact getContactById(@PathVariable String contactId) throws ContactNotFoundException {
		System.out.println("Contact ID received : " + contactId);
		Contact one = service.getContact(contactId);
 		return one;
	}
	
	@PostMapping("/contacts")
	public ResponseEntity<?> addContact(@RequestBody Contact contact) {
		Contact newContact = service.addContact(contact);
		return new ResponseEntity<Contact>(newContact, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/contacts/{contactId}")
	public void deleteContact(@PathVariable String contactId) {
		service.deleteContact(contactId);
	}
}