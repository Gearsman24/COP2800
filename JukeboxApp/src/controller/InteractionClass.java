package controller;

import java.util.Scanner;

import model.Album;
import model.Interpreter;
import model.Jukebox;

public class InteractionClass 
{
	public static void main(String[] args)	//Begins the program
	{
		Jukebox model = new Jukebox();
		Scanner input = new Scanner(System.in);
		
		boolean continueExecution = true;
		while(continueExecution == true)
		{
			//Things that the client wants to do
			System.out.println("Welcome to JukeboxApp!");
			System.out.println("Please select one of the following actions:");
			System.out.println("Add a new album [1]");
			System.out.println("Add a new song to an existing album [2]");
			System.out.println("Search for an existing album [3]");
			System.out.println("Retrieve the most expensive album [4]");
			System.out.println("Retrieve the number of existing albums [5]");
			
			//For user to respond
			String txtResponse = input.nextLine();
			int response = Integer.parseInt(txtResponse);
			
			
			if(response == 1)
			{
				//Add a new album
				System.out.println("Let's create the interpreter first.");
				System.out.println("What is the name of the interpreter?");
				String nameInterpreter = input.nextLine();
				System.out.println("What is the surname of the interpreter?");
				String surnameInterpreter = input.nextLine();
				System.out.println("What is the age of the interpreter?");
				String txtAge = input.nextLine();
				int ageInterpreter = Integer.parseInt(txtAge);
				
				Interpreter interpreter = new Interpreter(nameInterpreter, surnameInterpreter, ageInterpreter);
				
				System.out.println("Perfect! Now, let's create the Album.");
				System.out.println("What is the name of the album?");
				String nameAlbum = input.nextLine();
				System.out.println("What is the genre of the album?");
				String genreAlbum = input.nextLine();
				System.out.println("What is the price of the album?");
				String txtPrice = input.nextLine();
				double priceAlbum = Double.parseDouble(txtPrice);
				
				boolean methodAnswer = model.addAlbum(nameAlbum, genreAlbum, priceAlbum, interpreter);
				
				if(methodAnswer == true)
				{
					System.out.println("Amazing! Your album was successfully added to the JukeBox! :)");
				}
				
				else
				{
					System.out.println("I am sorry :( The album was not added to the Jukebox");
				}
			}
			
			
			else if(response == 2)
			{
				//Add a new song to an existing album
				System.out.println("Please input the name of the album:");
				String nameAlbum = input.nextLine();
				
				System.out.println("Please input the name of the song:");
				String nameSong = input.nextLine();
				
				System.out.println("Please input the duration of the song:");
				String txtDuration = input.nextLine();
				int durationSong = Integer.parseInt(txtDuration);
				
				boolean methodResponse = model.addSong(nameSong, durationSong, nameAlbum);
						
				if(methodResponse == true)
				{
					System.out.println("Amazing! Your song was successfully added to the album! :)");
				}
				else
				{
					System.out.println("I am sorry :( The song was not added to the album");
				}
			}
			
			
			else if(response == 3)
			{
				//Search for  existing album
				System.out.println("Please input the name of the album:");
				String nameAlbum = input.nextLine();
				
				Album searchedAlbum = model.searchAlbum(nameAlbum);
				
				if(searchedAlbum == null)
				{
					System.out.println("We are sorry, but there is not an album with the name: " + nameAlbum);
				}
				else
				{
					System.out.println("The album named " + nameAlbum + " has the following details:");
					System.out.println("\t a. Genre: " + searchedAlbum.getGenre());
					System.out.println("\t b. Price: " + searchedAlbum.getPrice());
					System.out.println("\t c. Number of Songs: " + searchedAlbum.getNumberOfSongs());
					System.out.println("\t d. Interpreter: " + searchedAlbum.getInterpreter().getName());
				}
			}
			
			
			else if(response == 4)
			{
				//Most expensive album
				Album mostExpensive = model.getMostExpensiveAlbum();
				if(mostExpensive == null)
				{
					System.out.println("There are not albums in the jukebox yet :(");
				}
				else
				{
					System.out.println("The most expensive album is named " + mostExpensive.getName());
					System.out.println("\t a. Genre: " + mostExpensive.getGenre());
					System.out.println("\t b. Price: " + mostExpensive.getPrice());
					System.out.println("\t c. Number of Songs: " + mostExpensive.getNumberOfSongs());
					System.out.println("\t d. Interpreter: " + mostExpensive.getInterpreter().getName());
				}
			}
			
			
			else if(response == 5)
			{
				//Number of existing albums
				System.out.println("The number of existing albums is: " + model.getNumberOfAlbums());
			}
			
			System.out.println("Do you want to continue using the app? (Y/N)");
			String responseContinue = input.nextLine();
			
			if(responseContinue.contentEquals("N"))
			{
				continueExecution = false;
			}
		}
	}
}	//Careful with all the brackets
