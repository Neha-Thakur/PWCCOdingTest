package com.test.PWCCodingTest.model;

public class AddressBook implements Comparable<AddressBook>
{
	
	public String userName;
	public int phoneNumber;
	 
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public AddressBook()
	{
		
	}
	
	AddressBook(String userName, int phoneNumber)
    {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }
	
	 @Override
	public boolean equals(Object obj) 
	 {
	    if(obj instanceof AddressBook)
	      {
	    	AddressBook temp = (AddressBook) obj;
	            if(this.userName.equals(temp.userName))
	            {
	            	System.out.println("username are equal");
	            	return true;
	            }
	                
	        }
	        return false;

	    }
	    @Override
	    public int hashCode() {
	        // TODO Auto-generated method stub

	        return (this.userName.hashCode() + this.phoneNumber);        
	    }
	    
		@Override
		public int compareTo(AddressBook o) {
			
			return this.getUserName().compareTo(o.getUserName());
		}
	    
	    
	

}
