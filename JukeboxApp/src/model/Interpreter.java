package model;

public class Interpreter 
{
	private String name;
	private String surname;
	private int age;
	
	public Interpreter(String pName, String pSurname, int pAge)	//This is a constructor
	{
		name = pName;
		surname = pSurname;
		age = pAge;	
	}

	//These are Getters
	
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
