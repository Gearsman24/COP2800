package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import controller.ControlClass;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame extends JFrame //Frame will behave as a JFrame
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
		
		setTitle("Luke's Agenda");
		setSize(new Dimension(250,320));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}
	
	public void requestAdding()
	{
		String name = JOptionPane.showInputDialog(this, "Please input the name:");
		String phoneNumber = JOptionPane.showInputDialog(this, "Please input the phone number:");		
	
		controller.reqAddFriend(name, phoneNumber);
	}
	
	public void requestRemoval()
	{
		String name = JOptionPane.showInputDialog(this, "Please input the name:");
		
		controller.reqRemoveFriend(name);
	}
	
	public void requestSearching()
	{
		String name = JOptionPane.showInputDialog(this, "Please input the name:");
	
		controller.reqSearchFriend(name);
	}
	
	public void requestUpdate()
	{
		String name = JOptionPane.showInputDialog(this, "Please input the name:");
		String phoneNumber = JOptionPane.showInputDialog(this, "Please input the phone number:");		
		
		controller.reqUpdatePhoneNumber(name, phoneNumber);
	}
	
	public void displayMessageToUser(String pMessage)
	{
		JOptionPane.showMessageDialog(this, pMessage);
	}
	
	public void displayErrorToUser(String pMessage)
	{
		JOptionPane.showMessageDialog(this, pMessage, "Warning!", JOptionPane.ERROR_MESSAGE);
	}
	
	public void refreshInfoPanel(int pNumberOfFriends)
	{
		jpInfo.updateNumber(pNumberOfFriends);
	}


}
