package com.test.PWCCodingTest.controller;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.PWCCodingTest.constant.Constant;
import com.test.PWCCodingTest.model.AddressBook;
import com.test.PWCCodingTest.service.AddressBookService;

@RestController
public class AddressBookController 
{
	@RequestMapping("/hello")
	  public String helloWorld() {
	 
	    System.out.println("In HelloWorldController");
	    String message = "Hello World";
	    return message;
	  }
	
	@Autowired
	private Constant constant;
	
	@Autowired
	private AddressBookService bookService;
	
	// add a new user 
	@PostMapping("/user/book/{book_id}/add")
	public ResponseEntity<?> addUser(@RequestBody AddressBook bookItem, @PathVariable("book_id") int book_id)
	{
		// make the id as long in future
		
		if(constant.getBookId(book_id) == null)
		{
			return ResponseEntity.ok().body("You must mention the book id in to add the user. ");
		}
		else
		{
			if(book_id == 1 || book_id == 2)
			{
				long bookId = bookService.addUserToBook(bookItem, book_id);
				if(bookId == 0)
				{
					return ResponseEntity.ok().body("Empty book cannot be added.");
				}
				return ResponseEntity.ok().body("User has been added to Book: " + bookId);
			}
			else
			{
				return ResponseEntity.ok().body("Book Id can be either 1 or 2.");
			}
		}
	}
	
	// get user by id
	@GetMapping("/user/book/{book_id}")
	public ResponseEntity<?> getUserFromBook(@PathVariable("book_id") int book_id)
	{
		System.out.println("in getUserFromBook method");
		if(constant.getBookId(book_id) == null)
		{
			return ResponseEntity.ok().body("You must mention the book id in to add the user. ");
		}
		else
		{
			if(book_id == 1 || book_id == 2)
			{
				List<AddressBook> book = bookService.getUserFromBook(book_id);
				
				return ResponseEntity.ok().body(book.stream().sorted().collect(Collectors.toList()));
			}
			else
			{
				return ResponseEntity.ok().body("Book Id can be either 1 or 2.");
			}
		}		
	}
	
	@GetMapping("/user/unique/book")
	public ResponseEntity<?> getUniqueUser()
	{
		System.out.println("in getUniqueUser method");
		
		Set<AddressBook> uniqueUsers = bookService.getUniqueUsers();
		
		return ResponseEntity.ok().body(uniqueUsers);

	}

}
