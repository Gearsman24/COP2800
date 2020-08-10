package controller;

import view.Frame;
import model.Agenda;
import model.Friend;

public class ControlClass 
{
	private Agenda agenda;
	private Frame frame;
	
	public ControlClass()
	{
		//Model <-- Controller <--> View
		agenda = new Agenda();
		frame = new Frame(this);
		frame.setVisible(true);
	}
	
	public void reqAddFriend(String pName, String pPhoneNumber)
	{
		try 
		{
			agenda.addFriend(pName, pPhoneNumber);
			String message = "Your friend has been successfully added";
			int n = agenda.getNumberOfFriends();
			frame.refreshInfoPanel(n);
			frame.displayMessageToUser(message);
		} 
		catch (Exception e) 
		{
			frame.displayErrorToUser(e.getMessage());
		}
	}
	
	public void reqRemoveFriend(String pName)
	{
		try 
		{
			agenda.removeFriend(pName);
			String message = "Your friend was successfully removed";
			int n = agenda.getNumberOfFriends();
			frame.refreshInfoPanel(n);
			frame.displayMessageToUser(message);
		} 
		catch (Exception e) 
		{
			frame.displayErrorToUser(e.getMessage());
		}
	}
	
	public void reqSearchFriend(String pName)
	{
		try 
		{
			Friend searched = agenda.searchFriend(pName);
			String message = "Found: Name is " + pName + " and Number is "+ searched.getPhoneNumber();
			int n = agenda.getNumberOfFriends();
			frame.refreshInfoPanel(n);
			frame.displayMessageToUser(message);
		} 
		catch (Exception e) 
		{
			frame.displayErrorToUser(e.getMessage());
		}
	}
	
	public void reqUpdatePhoneNumber(String pName, String pPhoneNumber)
	{
		try 
		{
			agenda.updatePhoneNumber(pName, pPhoneNumber);
			String message = "Your friend's number was updated";
			int n = agenda.getNumberOfFriends();
			frame.refreshInfoPanel(n);
			frame.displayMessageToUser(message);
		} 
		catch (Exception e) 
		{
			frame.displayErrorToUser(e.getMessage());
		}
	}
	
	public static void main(String[] args) 
	{
		@SuppressWarnings("unused")
		ControlClass c = new ControlClass();
	}
	
}
