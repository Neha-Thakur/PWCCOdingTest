package com.test.PWCCodingTest.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.PWCCodingTest.constant.Constant;
import com.test.PWCCodingTest.model.AddressBook;

@Service
public class AddressBookServiceImpl implements AddressBookService 
{
	@Autowired
	private Constant constant;

	@Override
	public long addUserToBook(AddressBook book, int book_id) 
	{
		if(book == null)
		{
			return 0;
			
		}
		else
		{
			if(book_id == 1)
			{
				constant.Book1.add(book);
			}
			else if(book_id == 2)
			{
				constant.Book2.add(book);
			}
			
			return book_id;
		}
		
	}

	@Override
	public List<AddressBook> getUserFromBook(int book_id) 
	{
		if(book_id == 1)
		{
			return constant.Book1;
		}
		else 
		{
			return constant.Book2;
		}
		
	}

	@Override
	public Set<AddressBook> getUniqueUsers() 
	{
		List<AddressBook> uniqueList = new ArrayList<AddressBook>();
		
		for (AddressBook book1 : constant.Book1) 
		{
            if(!constant.Book2.contains(book1)) 
            {
            	uniqueList.add(book1);
            }
        }
		
		for (AddressBook book2 : constant.Book2) 
		{
            if(!constant.Book1.contains(book2)) 
            {
            	uniqueList.add(book2);
            }
        }
		
		 Set<AddressBook> set = new HashSet<AddressBook>(uniqueList);
		 
        return set;
	}

}
