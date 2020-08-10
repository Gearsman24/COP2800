package model;

public class Room 
{
	//These are fields
	private char ID;
	private double price;
	private Roommate roommate;
	
	//These are methods
	public Room(char pID, double pPrice)	//This is the constructor method
	{
		ID = pID;
		price = pPrice;
	}

	//These are Getters
	public char getID() 
	{
		return ID;
	}

	public double getPrice() 
	{
		return price;
	}
	
	public Roommate getRoommate() 
	{
		return roommate;
	}
	
	//Method 1 Assign a Roommate
	public boolean assignRoommate(String pName, String pSurname, int pAge)
	{
		boolean response = false;
		Roommate existingRoommate = getRoommate();

		if(existingRoommate == null)
		{
				existingRoommate = new Roommate(pName, pSurname, pAge);
				response = true;
		}
		
		return response;
	}
	
	//Method 2 Delete a Roommate
	public boolean deleteRoommate()
	{
		boolean response = false;
		Roommate existingRoommate = getRoommate();
		
		if(existingRoommate != null)
		{
			existingRoommate = null;
			response = true;
		}
		
		return response;
	}
}