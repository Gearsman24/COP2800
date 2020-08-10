package model;

import java.util.ArrayList;

public class Laboratory 
{
	//Fields of a Laboratory
	private String nameLab;
	private int numberOfResearchers;
	
	//New ArrayList of type Researcher *Import
	public ArrayList<Researcher> researchers;
	
	//Constructor method that creates an instance of a Laboratory
	public Laboratory(String pNameLaboratory)
	{
		nameLab = pNameLaboratory;
		numberOfResearchers = 0;
		
		//Initializes the ArrayList of type Researcher
		researchers = new ArrayList<Researcher>();
	}

	//Getters
	
	/**
	 * Method that returns the name of a laboratory
	 * @return the name of the lab
	 */
	public String getName() 
	{
		return nameLab;
	}

	/**
	 * Method that returns the number of researchers in a laboratory
	 * @return the number of researchers
	 */
	public int getNumberOfResearchers() 
	{
		return numberOfResearchers;
	}
	
	/**
	 * Method that finds the youngest researcher in the lab
	 * pre: The ArrayList of researchers has already been initialized.
	 * pre: The array of laboratories has already been initialized.
	 * @return Researcher who has the youngest age in this lab. Otherwise null 
	 */
	public Researcher findYoungestResearcherInThisLab()
	{
		Researcher response = null;
		int maxAge = 300;
		
		for(int i = 0; i < researchers.size(); i++) 
		{
			Researcher searchedResearcher = researchers.get(i);
			if(searchedResearcher != null && searchedResearcher.getAge() < maxAge)
			{
				maxAge = searchedResearcher.getAge();
				response = searchedResearcher;
			}
			
		}
		
		return response;
	}
	
	/**Method that finds the average age of researchers in the lab
	 * pre: The ArrayList of researchers has already been initialized.
	 * pre: The array of laboratories has already been initialized. 
	 * @return The average age of researchers in this lab. Otherwise 0.0 
	 */
	public double findAverageAgeInThisLab()
	{
		double response = 0.0;
		int age = 0;
		int numberOfResearchers = 0;
		
		for (int i = 0; i < researchers.size(); i++) 
		{
			Researcher exists = researchers.get(i);
			if(exists != null)
			{
				age = age + exists.getAge();
				numberOfResearchers++;
			}
			
		}
		
		if(numberOfResearchers != 0)
		{
			response = age/numberOfResearchers;
		}
		
		return response;
	}
	

}
