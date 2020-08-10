package model;

public class Member 
{
	//These are the fields
	private String alias;
	private String name;
	private String surname;
	private int bioSex;
	private int age;
	private double income;
	
	//This is the constructor method
	public Member(String pAlias, String pName, String pSurname, int pBioSex, int pAge, double pIncome)
	{
		alias = pAlias;
		name = pName;
		surname = pSurname;
		bioSex = pBioSex;
		age = pAge;
		income = pIncome;
	}

	//These are the getters
	public String getAlias() 
	{
		return alias;
	}

	public int getBioSex() 
	{
		return bioSex;
	}

	public int getAge() 
	{
		return age;
	}

	public double getIncome() 
	{
		return income;
	}
	

}
