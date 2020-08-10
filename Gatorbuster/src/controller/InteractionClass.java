package controller;

import java.util.Scanner;
import model.Store;
import model.Movie;

/**
 * Interaction class for the exercise
 * @author Pedro Feijoo
 */

public class InteractionClass 
{

	public static void main(String[] args) 
	{
		Store model = new Store();
		Scanner userInput = new Scanner(System.in);
		boolean keepWorking = true;
		
		while(keepWorking == true)
		{
			System.out.println("Welcome to Gatorbuster. Here are the possible actions:");
			System.out.println("1. Add a new movie to our collection.");
			System.out.println("2. Calculate average price of our collection.");
			System.out.println("3. Count the number of movies with a price equal or lower than an input price.");
			System.out.println("4. Find the most exotic movie.");
			System.out.println("5. Find a movie by title.");
			System.out.println("6. Remove a movie from our collection.");

			String choice = userInput.nextLine();
			int numChoice = Integer.parseInt(choice);
			
			
			if(numChoice == 1)
			{
				System.out.println("Please input the title of the movie: ");
				String pTitle = userInput.nextLine();
				
				System.out.println("Please input the duration of the movie: ");
				String txtDuration = userInput.nextLine();
				int pDuration = Integer.parseInt(txtDuration);
				
				System.out.println("Please input the price of the movie: ");
				String txtPrice = userInput.nextLine();
				double pPrice = Double.parseDouble(txtPrice);

				System.out.println("Please input the number of  copies it has: ");
				String txtNumberOfCopies = userInput.nextLine();
				int pNumberOfCopies = Integer.parseInt(txtNumberOfCopies);

				try 
				{
					boolean added = model.addMovie(pTitle, pDuration, pPrice, pNumberOfCopies);
					System.out.println("Your movie has been added to our collection.");
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}

				
			}

			else if(numChoice == 2)
			{
				//Up to you to complete this requirement ;)
				double averagePrice = model.calculateAveragePrice();
				System.out.println("The average price of movies in the store is " + averagePrice + "!");
			}

			else if(numChoice == 3)
			{
				//Up to you to complete this requirement ;)
				System.out.println("What is the price you want to find movies with a lower price than?");
				String txtPrice = userInput.nextLine();
				double price = Double.parseDouble(txtPrice);
				
				int numMovies = model.countNumberOfMoviesLowerPrice(price);
				System.out.println("The number of movies with a lower price than " + price + " is " + numMovies + "!");
			}

			else if(numChoice == 4)
			{
				//Up to you to complete this requirement ;)
				Movie mostExotic = model.findMostExoticMovie();
				if(mostExotic != null)
				{
				System.out.println("The most exotic movie in the store is " + mostExotic.getTitle() +"!");
				System.out.println("\t Copies: " + mostExotic.getNumberOfCopies());
				System.out.println("\t Price: " + mostExotic.getPrice());
				System.out.println("\t Duration: " + mostExotic.getDuration());
				}
				else
				{
					System.out.println("There are no movies in the store yet!");
				}
			}

			else if(numChoice == 5)
			{
				//Up to you to complete this requirement ;)
				System.out.println("What is the title of the movie you want to find?");
				String title = userInput.nextLine();
				
				Movie searchedMovie = model.findMovie(title);
				if(searchedMovie != null)
				{
					System.out.println("We found the following information on " + title + "!");
					System.out.println("\t Copies: " + searchedMovie.getNumberOfCopies());
					System.out.println("\t Price: " + searchedMovie.getPrice());
					System.out.println("\t Duration: " + searchedMovie.getDuration());
				}
				else
				{
					System.out.println("That  movie is not in the store yet!");
				}
				
			}
			
			else if(numChoice == 6)
			{
				//Up to you to complete this requirement ;)
				System.out.println("What is the title of the movie you want to remove?");
				String title = userInput.nextLine();
				
				boolean removed = model.removeMovie(title);
				if(removed == true)
				{
					System.out.println("The movie was successfully removed!");
				}
				else
				{
					System.out.println("That movie is already not in our store.");
				}
			}
			
			System.out.println("Do you want to quit the application? [y/n]");
			String userResponse = userInput.nextLine();
			
			if(userResponse.equalsIgnoreCase("y"))
			{
				keepWorking = false;
			}
		}
		
		System.out.println("Okay! Have a wonderful day! :-)");
		userInput.close();

	}
}