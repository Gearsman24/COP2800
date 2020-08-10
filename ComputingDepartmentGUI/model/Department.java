package model;

public class Department 
{
	public int numberOfLabs;
	
	//Constant number of laboratories
	public static final int NUMBER_LABORATORIES = 25;
	
	//New array of type Laboratory
	public Laboratory[] laboratories;

	//Constructor method that creates an instance of a Department
	public Department()
	{
		numberOfLabs = 0;
		
		//Initializes the array of type Laboratory and to null
		laboratories = new Laboratory[NUMBER_LABORATORIES];
		
		for(int i = 0; i < laboratories.length; i++) 
		{
			laboratories[i] = null;
		}
	}
	
	/**
	 * Method that adds a new laboratory to the array of laboratories in the department
	 * pre: The array of laboratories has already been initialized.
	 * @param pNameLaboratory name of the laboratory that will be added to the array of laboratories. pNameLaboratory != null
	 * @return true if it was successfully added. Otherwise false
	 * @throws Exception if the laboratory previously exists in the department
	 */
	public boolean addNewLaboratory(String pNameLaboratory) throws Exception
	{
		boolean response = false;
		
		for (int i = 0; i < laboratories.length && response == false; i++) 
		{
			//Exception if no input
			if(pNameLaboratory == null || pNameLaboratory.isEmpty())
			{
				throw new Exception("You must input a lab name.");
			}
			
			//Exception if lab previously exists
			Laboratory exists = laboratories[i];
			if(exists != null && exists.getName().contentEquals(pNameLaboratory))
			{
				throw new Exception("The laboratory already exists!");
			}
			
			
			if(laboratories[i] == null)
			{
				laboratories[i] = new Laboratory(pNameLaboratory);
				numberOfLabs++;
				response = true;
			}
			
		}
		
		return response;
	}
	
	/**
	 * Method that adds a new researcher to the ArrayList of researchers in the laboratory
	 * @param pNameLaboratory name of the laboratory the researcher will be added to. pNameLaboratory != null
	 * @param pName name of the researcher to be added to the laboratory. pName != null
	 * @param pSurname surname of the researcher to be added to the laboratory. pSurname != null
	 * @param pAge age of the researcher to be added to the laboratory. pAge != null
	 * @return true if the researcher was successfully added. Otherwise false
	 * @throws Exception if the researcher previously exists in the laboratory
	 */
	public boolean addNewResearcher(String pNameLaboratory, String pName, String pSurname, int pAge) throws Exception
	{
		boolean response = false;
		
		for(int i = 0; i < laboratories.length && response == false; i++) 
		{
			//Exceptions if no input
			if(pNameLaboratory == null || pNameLaboratory.isEmpty())
			{
				throw new Exception("You must input a lab name");
			}
			if(pName == null || pName.isEmpty())
			{
				throw new Exception("You must input a name");
			}
			if(pSurname == null || pSurname.isEmpty())
			{
				throw new Exception("You must input a surname");
			}
			//Age input exception handled in Frame class
			
			//Exception if the researcher previously exists
			Laboratory searchedLaboratory = laboratories[i];
			if(searchedLaboratory != null && searchedLaboratory.getName().contentEquals(pNameLaboratory))
			{
				for(int j = 0; j < searchedLaboratory.researchers.size(); j++) 
				{
					Researcher searchedResearcher = searchedLaboratory.researchers.get(j);
					if(searchedResearcher != null && searchedResearcher.getSurname().contentEquals(pSurname) && searchedResearcher.getName().contentEquals(pName))
					{
						throw new Exception("This researcher already exists in the laboratory!");
					}
					
				}
				
				Researcher newResearcher = new Researcher(pName, pSurname, pAge);
				searchedLaboratory.researchers.add(newResearcher);
				searchedLaboratory.numberOfResearchers++;
				response = true;
			}
			
		}
		
		return response;
	}
	
	/**
	 * Method that finds the youngest researcher in the department
	 * pre: The array of laboratories has already been initialized.
	 * pre: The ArrayList of researchers has already been initialized.
	 * @return Researcher with the youngest age in the department. Otherwise null
	 */
	public Researcher findYoungestResearcher() throws Exception
	{
		Researcher response = null;
		int minAge = 300;
		
		for(int i = 0; i < laboratories.length; i++) 
		{
			Laboratory lab = laboratories[i];
			if(lab != null)
			{
				Researcher youngestInLab = lab.findYoungestResearcherInThisLab();
				if(youngestInLab != null && youngestInLab.getAge() < minAge)
				{
					minAge = youngestInLab.getAge();
					response = youngestInLab;
				}
			}
		}
		
		if(response == null)
		{
			throw new Exception("You must add a researcher to a lab first");
		}
	
		return response;
	}
	
	/**
	 * Method that finds the average of all researchers in the department
	 * pre: The array of laboratories has already been initialized.
	 * pre: The ArrayList of researchers has already been initialized.
	 * @return The average age of researchers in the department. Otherwise 0.0
	 */
	public double averageAgeDepartment()
	{
		double response = 0.0;
		double averageLab = 0.0;
		int numberLabs = 0;
		for (int i = 0; i < laboratories.length; i++) 
		{
			Laboratory lab = laboratories[i];
			if(lab != null)
			{
				averageLab = averageLab + lab.findAverageAgeInThisLab();
				if(lab.researchers.isEmpty() == false)
				{
					numberLabs++;
				}
				
			}
			
			if(numberLabs != 0)
			{
				response = averageLab/numberLabs;
			}
			
		}
		
		return response;
		
	}
	
	/**
	 * Method that finds the most populated laboratory in the department
	 * pre: The array of laboratories has already been initialized.
	 * pre: The ArrayList of researchers has already been initialized.
	 * @return Laboratory with the largest number of researchers. Otherwise null
	 */
	public Laboratory mostPopulatedLaboratory() throws Exception
	{
		Laboratory response = null;
		int maxNumber = 0;
		
		for (int i = 0; i < laboratories.length; i++) 
		{
			Laboratory lab = laboratories[i];
			if(lab != null)
			{
				int labPopulation = lab.getNumberOfResearchers();
					if(labPopulation > maxNumber)
					{
						maxNumber = labPopulation;
						response = lab;
					}
					
			}
			
		}
		
		if(response == null)
		{
			throw new Exception("You must add a researcher to a lab first");
		}
		
		return response;
	}
	
	/**
	 * Method that finds the number of researchers older than a given age
	 * @param pAge age of the researcher. pAge != null
	 * @return The number of researchers older than a given age
	 */
	public int olderResearchers(int pAge)
	{
		int response = 0;
		
		for (int i = 0; i < laboratories.length; i++) 
		{
			Laboratory lab = laboratories[i];
			if(lab != null)
			{
				for (int j = 0; j < lab.researchers.size(); j++) 
				{
					Researcher found = lab.researchers.get(j);
					if(found != null && found.getAge() > pAge)
					{
						response++;
					}
				}
			}
			
		}
		
		return response;
	}
	
	public int getNumberOfLabs()
	{
		return numberOfLabs;
	}

}
