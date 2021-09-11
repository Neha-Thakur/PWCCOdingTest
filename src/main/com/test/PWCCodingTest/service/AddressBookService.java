package com.test.PWCCodingTest.service;

import java.util.List;
import java.util.Set;

import com.test.PWCCodingTest.model.AddressBook;

public interface AddressBookService 
{
	long addUserToBook(AddressBook book, int book_id);
	List<AddressBook> getUserFromBook(int book_id);// make id as long
	Set<AddressBook> getUniqueUsers();

}
