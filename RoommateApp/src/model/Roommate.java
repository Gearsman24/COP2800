package model;

public class Roommate 
{
	private String name;
	private String surname;
	private int age;
	
	//This is the constructor method
	
	public Roommate(String pName, String pSurname, int pAge)
	{
		name = pName;
		surname = pSurname;
		age = pAge;
	}

	//These below are Getters
	
	public String getName() 
	{
		return name;
	}

	public String getSurname() 
	{
		return surname;
	}

	public int getAge() 
	{
		return age;
	}

}