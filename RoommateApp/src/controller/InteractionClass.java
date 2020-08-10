package controller;

import java.util.Scanner;
import model.Apartment;
import model.Roommate;
import model.Room;

public class InteractionClass 
{
	
	public static void main(String[] args) //Begins the program
	{
		Apartment apartment = new Apartment();
		Scanner input = new Scanner(System.in);
		
		boolean continueExecution = true;
		while(continueExecution == true)
		{
			//Things the client wants to do
			System.out.println("Welcome to RoommatesApp!");
			System.out.println("Please select one of the following actions.");
			System.out.println("Add a room in the apartment [1]");
			System.out.println("Search for a room in the apartment [2]");
			System.out.println("Add a roommate to an existing room [3]");
			System.out.println("Search for a roommate [4]");
			System.out.println("Empty a room [5]");
			System.out.println("Get the roommate who pays the most for a room in the apartment [6]");
			
			//For user to respond
			String txtResponse = input.nextLine();
			int response = Integer.parseInt(txtResponse);
			
			
			if(response == 1)
			{
				//Add a room in the apartment
				System.out.println("Let's create the room!");
				System.out.println("Please input the ID of the room.");
				
				//User inputs ID
				String txtID = input.nextLine();
				char IDRoom = txtID.charAt(0);
				
				System.out.println("Great! Now input the price of the room.");
				//User inputs Price
				String txtPrice = input.nextLine();
				double priceRoom = Double.parseDouble(txtPrice);
				
				boolean methodAnswer = apartment.addRoom(IDRoom, priceRoom);
				
				if(methodAnswer == true)
				{
					System.out.println("Fantastic! The room was successfully added.");
				}
				else
				{
					System.out.println("Uh-oh! The room could not be added.");
				}
				
			}
			
			else if(response == 2)
			{
				//Search for a room in the apartment
				System.out.println("Hope you find what you're looking for.");
				System.out.println("Please enter the ID of the room.");
				
				//User inputs ID
				String txtID = input.nextLine();
				char IDRoom = txtID.charAt(0);
				
				Room searchedRoom = apartment.searchRoom(IDRoom);
				
				if(searchedRoom == null)
				{
					System.out.println("Dang... we couldn't find a room with that ID.");
				}
				else
				{
					System.out.println("The room with ID " + IDRoom + " has the following information:");
					System.out.println("\t a. Price: " + searchedRoom.getPrice());
				}
				
			}
			
			else if(response == 3)
			{
				//Add a roommate to an existing room
				System.out.println("Let's add a roommate into the room.");
				
				System.out.println("Input the room ID that the roommate will be assigned to");
				//User inputs ID
				String txtID = input.nextLine();
				char IDRoom = txtID.charAt(0);
				
				System.out.println("Please input the roommate's name");
				//User inputs Name
				String nameRoommate = input.nextLine();
				
				System.out.println("Now input the roommate's surname");
				//User inputs Surname
				String surnameRoommate = input.nextLine();
				
				System.out.println("Input the roommate's age");
				//User inputs Age
				String txtAge = input.nextLine();
				int ageRoommate = Integer.parseInt(txtAge);
				
				boolean methodAnswer = apartment.addRoommate(nameRoommate, surnameRoommate, ageRoommate, IDRoom);
				
				if(methodAnswer == true)
				{
					System.out.println("Excellent! You added the roommate successfully.");
				}
				else
				{
					System.out.println("What the!? The roommate could not be added.");
				}
				
			}
			
			else if(response == 4)
			{
				//Search for a roommate
				System.out.println("Let's find that roommate!");
				
				System.out.println("What is the roommate's name?");
				//User inputs Name
				String nameRoommate = input.nextLine();
				
				System.out.println("What is the roommate's surname?");
				//User inputs Surname
				String surnameRoommate = input.nextLine();
				
				Roommate searchedRoommate = apartment.searchRoommate(nameRoommate, surnameRoommate);
				
				if(searchedRoommate == null)
				{
					System.out.println("Welp we couldn't find a roommate with that name...");
				}
				else
				{
					System.out.println("Here is information on " + nameRoommate + " " + surnameRoommate);
					System.out.println("\t a. Age: " + searchedRoommate.getAge());
				}
				
			}
			
			else if(response == 5)
			{
				//Empty a room
				System.out.println("Let's kick a roommate out!");
				
				System.out.println("Please input the room's ID.");
				//User inputs ID
				String txtID = input.nextLine();
				char IDRoom = txtID.charAt(0);
				
				boolean emptiedRoom = apartment.emptyRoom(IDRoom);
				
				if(emptiedRoom == false)
				{
					System.out.println("I'm sorry we couldn't kick out the roommate...");
				}
				else
				{
					System.out.println("Congrats! The roommate was kicked out.");
				}
				
			}
			
			else if(response == 6)
			{
				//Get the roommate who pays for a room in the apartment
				Roommate roommateWhoPaysMost = apartment.getRoommateWhoPaysMost();
				if(roommateWhoPaysMost == null)
				{
					System.out.println("How will there be a roommate who pays the most if there's no rooms yet!? Silly.");
				}
				else
				{
					System.out.println("Here is the information for the most expensive room");
					System.out.println("\t a. Roommate: " + roommateWhoPaysMost.getName() + " " + roommateWhoPaysMost.getSurname());
					System.out.println("\t b. Age: " + roommateWhoPaysMost.getAge());
				}
			}
			System.out.println("Do you want to continue using the app? (Y/N)");
			String responseContinue = input.nextLine();
			
			if(responseContinue.contentEquals("N"))
			{
				continueExecution = false;
			}
		}
	}
}

