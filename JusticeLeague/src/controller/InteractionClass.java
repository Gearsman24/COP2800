package controller;

import java.util.Scanner;
import model.League;
import model.Member;


public class InteractionClass 
{
	public static void main(String[] args)	//Begins the program
	{
		League model = new League();
		Scanner input = new Scanner(System.in);
		
		boolean continueExecution = true;
		while(continueExecution == true)
		{
			System.out.println("Welcome to the Justice League! Choose one of the follwing.");
			System.out.println("Add a new hero [1]");
			System.out.println("Search for a member [2]");
			System.out.println("Count the number of heroines in the League [3]");
			System.out.println("Calculate average income of male heroes [4]");
			System.out.println("Calculate average age of male heroes [5]");
			System.out.println("Find the youngest member of the League [6]");
			System.out.println("Close the applications [7]");
			
			String txtResponse = input.nextLine();
			int intResponse = Integer.parseInt(txtResponse);
			
			if(intResponse == 1)
			{
				System.out.println("Let's add a hero to the League!");
				System.out.println("What is their alias?");
				String memberAlias = input.nextLine();
				System.out.println("What is their real name?");
				String memberName = input.nextLine();
				System.out.println("What is their surname?");
				String memberSurname = input.nextLine();
				System.out.println("Input 1 for Female or 2 for Male");
				String txtBioSex = input.nextLine();
				int memberBioSex = Integer.parseInt(txtBioSex);
				System.out.println("What is their age?");
				String txtAge = input.nextLine();
				int memberAge = Integer.parseInt(txtAge);
				System.out.println("What is their income?");
				String txtIncome = input.nextLine();
				double memberIncome = Double.parseDouble(txtIncome);
				
				try 
				{
					boolean methodAnswer = model.addNewMember(memberAlias, memberName, memberSurname, memberBioSex, memberAge, memberIncome);
					
					if(methodAnswer == true)
					{
						System.out.println("The hero was successfully added to the League!");
					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
			}
			
			else if(intResponse == 2)
			{
				System.out.println("What is the alias of the member you want to search for?");
				String memberAlias = input.nextLine();
				
				Member searchedMember = model.searchMember(memberAlias);
				System.out.println("Here is information on " + searchedMember.getAlias() + "!");
				System.out.println("\t Age: " + searchedMember.getAge());
				if(searchedMember.getBioSex() == 1)
				{
					System.out.println("\t Sex: Female" );
				}
				else
				{
					System.out.println("\t Sex: Male");
				}
				System.out.println("\t Income: " + searchedMember.getIncome());
			}
			
			else if(intResponse == 3)
			{
				int countHeroine = model.countHeroines();
				System.out.println("The number of heroines in the League is " + countHeroine + "!");
			}
			
			else if(intResponse == 4)
			{
				System.out.println("The average male income is " + model.maleAverageIncome() + ".");
			}
			
			else if(intResponse == 5)
			{
				System.out.println("The average male age is " + model.maleCalculateAverageAge() + ".");
			}
			
			else if(intResponse == 6)
			{
				Member youngestMember = model.findYoungestMember();
				System.out.println("The youngest member in the League is " + youngestMember.getAlias());
			}
			
			else if(intResponse == 7)
			{
				continueExecution = false;
				input.close();
			}
		}
	}
}
