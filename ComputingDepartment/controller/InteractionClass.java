package controller;

import java.util.Scanner;
import model.Laboratory;
import model.Department;
import model.Researcher;

/**
 * Interaction class for the exercise
 * @author Pedro Feijoo
 */
public class InteractionClass 
{

	public static void main(String[] args) 
	{
		Department model = new Department();
		Scanner userInput = new Scanner(System.in);
		boolean keepWorking = true;
		
		while(keepWorking == true)
		{
			System.out.println("Welcome to Department. Here are the possible actions:");
			System.out.println("1. Add a new laboratory.");
			System.out.println("2. Add a new researcher to an existing laboratory.");
			System.out.println("3. Find the youngest researcher in the Department.");
			System.out.println("4. Find the researchers’ average age in the whole Department.");
			System.out.println("5. Find the laboratory with the highest number of researchers.");
			System.out.println("6. Find older researchers.");
			System.out.println("7. Exit the app.");

			String choice = userInput.nextLine();
			int numChoice = Integer.parseInt(choice);
			
			
			if(numChoice == 1)
			{
				System.out.println("Please input the name of the laboratory: ");
				String labName = userInput.nextLine();

				try 
				{
					boolean added = model.addNewLaboratory(labName);
					if(added == true)
					{
						System.out.println("The laboratory has succesfully been added to the Department.");
					}

					else
					{	
						System.out.println("I'm sorry, but the laboratory was not added to the Department.");
					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}

				
			}

			else if(numChoice == 2)
			{
				//Up to you to complete this requirement ;)
				System.out.println("What is the name of the lab?");
				String labName = userInput.nextLine();
				System.out.println("What is the researcher's name?");
				String name = userInput.nextLine();
				System.out.println("What is the researcher's surname?");
				String surname = userInput.nextLine();
				System.out.println("What is the researcher's age?");
				String txtAge = userInput.nextLine();
				int age = Integer.parseInt(txtAge);
				
				try
				{
					boolean added = model.addNewResearcher(labName, name, surname, age);
					if(added == true)
					{
						System.out.println("The researcher was added successfully!");
					}
					else
					{
						System.out.println("Sorry, we were unable to add the researcher to the lab.");
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				
			}

			else if(numChoice == 3)
			{
				//Up to you to complete this requirement ;)
				Researcher found = model.findYoungestResearcher();
				if(found != null)
				{
					System.out.println("We have the following information on this researcher.");
					System.out.println("\t Name: " + found.getName() + " " + found.getSurname());
					System.out.println("\t Age: " + found.getAge());
				}
				else
				{
					System.out.println("There are no labs yet!");
				}
			}

			else if(numChoice == 4)
			{
				//Up to you to complete this requirement ;)
				double average = model.averageAgeDepartment();
				System.out.println("The average age of researchers in the department is " + average + "!");
			}

			else if(numChoice == 5)
			{
				//Up to you to complete this requirement ;)
				Laboratory mostPopulated = model.mostPopulatedLaboratory();
				if(mostPopulated != null)
				{
					System.out.println("The most populated laboratory is " + mostPopulated.getName() + "!");
				}
				else
				{
					System.out.println("There are no labs yet!");
				}
			}
			
			else if(numChoice == 6)
			{
				//Up to you to complete this requirement ;)
				System.out.println("What is the minimum age of researchers you'd like to find?");
				String txtAge = userInput.nextLine();
				int age = Integer.parseInt(txtAge);
				
				int researchers = model.olderResearchers(age);
				System.out.println("The number of researchers older than " + age + " is " + researchers + "!");
			}
			
			else if(numChoice == 7)
			{
				keepWorking = false;
				System.out.println("Okay! Have a wonderful day! :-)");
				userInput.close();
			}
		}
		

	}
}