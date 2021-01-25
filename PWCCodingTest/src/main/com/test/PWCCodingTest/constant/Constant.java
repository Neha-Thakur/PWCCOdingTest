package com.test.PWCCodingTest.constant;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.test.PWCCodingTest.model.AddressBook;

@Component
public class Constant 
{
	public ArrayList<AddressBook> Book1 = new ArrayList<AddressBook>();
	public ArrayList<AddressBook> Book2 = new ArrayList<AddressBook>();
		
	public Integer getBookId(int book_id)
	{
		return book_id;
	}

}
