package controller;

import view.Frame;
import model.Department;
import model.Laboratory;
import model.Researcher;

public class ControlClass 
{
	private Department department;
	private Frame frame;
	
	public ControlClass()
	{
		department = new Department();
		frame = new Frame(this);
		frame.setVisible(true);
	}
	
	public void reqAddLab(String pNameLaboratory)
	{
		try
		{
			department.addNewLaboratory(pNameLaboratory);
			String message = "The lab was successfully added";
			int n = department.getNumberOfLabs();
			frame.refreshInfoPanel(n);
			frame.displayMessageToUser(message);
		}
		catch (Exception e)
		{
			frame.displayErrorToUser(e.getMessage());
		}
	}
	
	public void reqAddResearcher(String pNameLaboratory, String pName, String pSurname, int pAge)
	{
		try
		{
			department.addNewResearcher(pNameLaboratory, pName, pSurname, pAge);
			String message = "The researcher was successfully added";
			int n = department.getNumberOfLabs();
			frame.refreshInfoPanel(n);
			frame.displayMessageToUser(message);
		}
		catch (Exception e)
		{
			frame.displayErrorToUser(e.getMessage());
		}
	}
	
	public void reqYoungest()
	{
		try
		{
			Researcher found = department.findYoungestResearcher();
			String message = "The youngest researcher is " + found.getName() + " " + found.getSurname() + " who is " + found.getAge();
			int n = department.getNumberOfLabs();
			frame.refreshInfoPanel(n);
			frame.displayMessageToUser(message);
		}
		catch (Exception e)
		{
			frame.displayErrorToUser(e.getMessage());
		}
	}
	
	public void reqAverage()
	{
		try
		{
			double average = department.averageAgeDepartment();
			String message = "The average age is " + average;
			int n = department.getNumberOfLabs();
			frame.refreshInfoPanel(n);
			frame.displayMessageToUser(message);
		}
		catch (Exception e)
		{
			frame.displayErrorToUser(e.getMessage());
		}
	}
	
	public void reqOlder(int pAge)
	{
		try
		{
			int older = department.olderResearchers(pAge);
			String message = "The number of older researchers is " + older;
			int n = department.getNumberOfLabs();
			frame.refreshInfoPanel(n);
			frame.displayMessageToUser(message);
		}
		catch (Exception e)
		{
			frame.displayErrorToUser(e.getMessage());
		}
	}
	
	public void reqPopulated()
	{
		try
		{
			Laboratory populated = department.mostPopulatedLaboratory();
			String message = "The most populated lab is " + populated.getName();
			int n = department.getNumberOfLabs();
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
