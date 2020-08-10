package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import controller.ControlClass;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActionsPanel jpActions;
	private InfoPanel jpInfo;
	
	private ControlClass controller;
	
	public Frame(ControlClass pController)
	{
		controller = pController;
		setLayout(new BorderLayout());
		jpActions = new ActionsPanel(this);
		jpInfo = new InfoPanel();
		
		add(jpActions, BorderLayout.CENTER);
		add(jpInfo, BorderLayout.SOUTH);
		
		setTitle("Computing Department");
		setSize(new Dimension(250,320));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}
	
	public void requestLab()
	{
		String nameLaboratory = JOptionPane.showInputDialog(this, "Please input the name:");		
	
		controller.reqAddLab(nameLaboratory);
	}
	
	public void requestResearcher()
	{
		String nameLaboratory = JOptionPane.showInputDialog(this, "Please input the lab:");
		String name = JOptionPane.showInputDialog(this, "Please input the name:");
		String surname = JOptionPane.showInputDialog(this, "Please input the surname:");
		String txtAge = JOptionPane.showInputDialog(this, "Please input the age:");
		int age = -1;
		try
		{
			age = Integer.parseInt(txtAge);
			controller.reqAddResearcher(nameLaboratory, name, surname, age);
		}
		catch(Exception e)
		{
			displayErrorToUser("The age input is incorrect!");
		}
		
		
	}
	
	public void requestYoungest()
	{	
		controller.reqYoungest();
	}
	
	public void requestAverage()
	{
		controller.reqAverage();
	}
	
	public void requestOlder()
	{
		String txtAge = JOptionPane.showInputDialog(this, "Please input the age:");
		int age = -1;
		try
		{
			age = Integer.parseInt(txtAge);
			controller.reqOlder(age);
		}
		catch (Exception e)
		{
			displayErrorToUser("The age input is incorrect!");
		}
	}
	
	public void requestPopulated()
	{
		controller.reqPopulated();
	}
	
	public void displayMessageToUser(String pMessage)
	{
		JOptionPane.showMessageDialog(this, pMessage);
	}
	
	public void displayErrorToUser(String pMessage)
	{
		JOptionPane.showMessageDialog(this, pMessage, "Warning!", JOptionPane.ERROR_MESSAGE);
	}
	
	public void refreshInfoPanel(int pNumberOfLabs)
	{
		jpInfo.updateNumber(pNumberOfLabs);
	}

}
