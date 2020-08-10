package model;

public class Researcher 
{
	//Fields of a Researcher
	private String name;
	private String surname;
	private int age;
	
	//Constructor method that creates an instance of a Researcher
	public Researcher(String pName, String pSurname, int pAge)
	{
		name = pName;
		surname = pSurname;
		age = pAge;
	}

	//Getters that retrieve values of a Researcher
	
	/**Method that returns the name of a researcher
	 * @return the name of the researcher 
	 */
	public String getName() 
	{
		return name;
	}

	/**Method that returns the surname of a researcher 
	 * @return the surname of the researcher
	 */
	public String getSurname() 
	{
		return surname;
	}

	/**Method that returns the age of a researcher
	 * @return the age of the researcher
	 */
	public int getAge() 
	{
		return age;
	}
	
	

}
