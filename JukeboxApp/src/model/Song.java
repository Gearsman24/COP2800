package model;

public class Song 
{
	private String name;
	private int duration;
	
	
	public Song(String pName, int pDuration) //This is a constructor
	{
		name = pName;
		duration = pDuration;
	}

	//These are Getters
	
	public String getName() 
	{
		return name;
	}

	public int getDuration() 
	{
		return duration;
	}
}
