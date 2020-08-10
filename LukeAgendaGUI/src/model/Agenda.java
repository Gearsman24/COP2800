package model;

import java.util.ArrayList;

public class Agenda 
{
	public int numberOfFriends;
	private ArrayList<Friend> friends;
	
	public Agenda()
	{
		numberOfFriends = 0;
		friends = new ArrayList<Friend>();
	}
	
	public int getNumberOfFriends()
	{
		return numberOfFriends;
	}
	
	public boolean addFriend(String pName, String pPhoneNumber) throws Exception
	{
		boolean response = false;
		
		if(pName == null || pName.isEmpty())
		{
			throw new Exception("You have to input a name!");
		}
		
		if(pPhoneNumber == null || pPhoneNumber.isEmpty())
		{
			throw new Exception("You have to input a phone number!");
		}
	
		boolean alreadyExists = phoneNumberExists(pPhoneNumber);
		if(alreadyExists == true)
		{
			throw new Exception("Your friend already exists!");
		}
		
		Friend newFriend = new Friend(pName, pPhoneNumber);
		friends.add(newFriend);
		numberOfFriends++;
		response = true;
		
		
		return response;
	}
	
	private boolean phoneNumberExists(String pPhoneNumber)
	{
		boolean exists = false;
		
		for (int i = 0; i < friends.size() && exists == false; i++) 
		{
			Friend searchedFriend = friends.get(i);
			if(searchedFriend.getPhoneNumber().equals(pPhoneNumber))
			{
				exists = true;
			}
		}
		
		return exists;
	}
	
	public Friend searchFriend(String pName) throws Exception
	{
		Friend response = null;
		
		if(friends.isEmpty())
		{
			throw new Exception("You still have no friends in the agenda");
		}
		
		for (int i = 0; i < friends.size() && response == null; i++) 
		{
			Friend searchedFriend = friends.get(i);
			if(searchedFriend.getName().contentEquals(pName))
			{
				response = searchedFriend;
			}
		}
		
		if(response == null)
		{
			throw new Exception("You don't have a friend with that name");
		}
		
		return response;
	}
	
	public boolean removeFriend(String pName) throws Exception
	{
		boolean response = false;
		
		if(friends.isEmpty())
		{
			throw new Exception("You still have no friends in the agenda.");
		}
		
		Friend searchedFriend = searchFriend(pName);
		friends.remove(searchedFriend);
		numberOfFriends--;
		response = true;
		
		return response;
	}
	
	public void updatePhoneNumber(String pName, String pPhoneNumber) throws Exception
	{
		if(friends.isEmpty())
		{
			throw new Exception("You still have no friends in the agenda.");
		}
		
		Friend searchedFriend = searchFriend(pName);
		searchedFriend.setPhoneNumber(pPhoneNumber);
	}
	
	
	

}
