package com.test.PWCCodingTest.controller.test;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.test.PWCCodingTest.controller.AddressBookController;
import com.test.PWCCodingTest.model.AddressBook;

import static org.junit.Assert.*;

import org.junit.Test;


// @Autowired annotation is not working on test cases for somehow. But rest is I have added. 

@RunWith(JUnit4.class)
@ContextConfiguration(locations={"rest-servlet.xml"})
public class AddressBookControllerTest 
{
	
	private AddressBookController bookController = new AddressBookController();
	private AddressBook book = new AddressBook();
	
	
	@Test
	public void testHelloWorldMessage()
	{	
		String messageResponse = bookController.helloWorld();
		System.out.println(messageResponse);
		
		assertNotNull(messageResponse);
	}
	
	@Test
	public void testAddUserToBook()
	{
		book.setUserName("Leela");
		book.setPhoneNumber(54872314);
		
		ResponseEntity<?> response = bookController.addUser(book, 1);
		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	public static void main(String args[])
	{
		AddressBookControllerTest at = new AddressBookControllerTest();
		
		//at.testHelloWorldMessage();
		
		//at.testAddUserToBook();
	}

}
