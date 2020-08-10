package model;

public class Friend 
{
	private String name;
	private String phoneNumber;
	
	public Friend(String pName, String pPhoneNumber)
	{
		name = pName;
		phoneNumber = pPhoneNumber;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String pPhoneNumber)
	{
		phoneNumber = pPhoneNumber;
	}
	
	public String getName()
	{
		return name;
	}

}
