package model;

public class Apartment 
{
	//These are fields
	private int assignedRooms;
	private Room roomA, roomB, roomC;
	private Roommate roommate;
	
	public Apartment() //This is the constructor method
	{
		assignedRooms = 0;
	}

	//Method 1 (Getter)
	public int getAssignedRooms()
	{ 	
		return assignedRooms;
	}
			
	//Method 2
	public boolean addRoom(char pID, double pPrice)
	{
		boolean response = false;
		Room existingRoom = searchRoom(pID);
		
		if(existingRoom == null)
		{
			if(roomA == null)
			{
				roomA = new Room(pID, pPrice);
				response = true;
				assignedRooms++;
			}
			else if(roomB == null)
			{
				roomB = new Room(pID, pPrice);
				response = true;
				assignedRooms++;
			}
			else if(roomC == null)
			{
				roomC = new Room(pID, pPrice);
				response = true;
				assignedRooms++;
			}
		}

		return response;		
	}
	
	//Method 3
	public Room searchRoom(char pID)
	{
		Room response = null; //Must see if each Room exists first
		
		if(roomA != null && roomA.getID() == pID)
		{
			response = roomA;
		}
		if(roomB != null && roomB.getID() == pID)
		{
			response = roomB;
		}
		if(roomC != null && roomC.getID() == pID)
		{
			response = roomC;
		}
				
		return response;
		
	}
	
	//Method 4
	public boolean addRoommate(String pName, String pSurname, int pAge, char pID)
	{
		boolean response = false;
		Room room = searchRoom(pID);
				
		if(roomA != null && roomA.getRoommate() == null)
		{
			response = room.assignRoommate(pName, pSurname, pAge);
		}
		
		else if(roomB != null && roomB.getRoommate() == null)
		{
			response = room.assignRoommate(pName, pSurname, pAge);
		}
		
		else if(roomC != null && roomC.getRoommate() == null)
		{
			response = room.assignRoommate(pName, pSurname, pAge);
		}
				
		return response;
	}
	
	//Method 5
	public Roommate searchRoommate(String pName, String pSurname)
	{
		Roommate response = null;
			
		if(roommate != null && roommate.getName().equals(pName) && roommate.getSurname().equals(pSurname))
		{
			response = roommate;
		}
		
		return response;
		
	}
	
	//Method 6
	public boolean emptyRoom(char pID)
	{
		boolean response = false;
		Room existingRoom = searchRoom(pID);
		Roommate existingRoommate = null;
		
		if(existingRoom != null)
		{
			existingRoommate = existingRoom.getRoommate();
		}
		
		if(existingRoommate != null && existingRoom != null)
		{
			response = existingRoom.deleteRoommate();
		}
		
		return response;
	}
	
	//Method 7
	public Roommate getRoommateWhoPaysMost()
	{
		Roommate response = null;
		double mostExpensiveRoom = 0;
		if(roomA != null && roomA.getPrice() > mostExpensiveRoom)
		{
			mostExpensiveRoom = roomA.getPrice();
			response = roomA.getRoommate();
		}
		if(roomB != null && roomB.getPrice() > mostExpensiveRoom)
		{
			mostExpensiveRoom = roomB.getPrice();
			response = roomB.getRoommate();
		}
		if(roomC != null && roomC.getPrice() > mostExpensiveRoom)
		{
			mostExpensiveRoom = roomC.getPrice();
			response = roomC.getRoommate();
		}
		
		return response;
	
	}
	
}