package model;

public class Movie 
{
	private String title;
	private int duration;
	private double price;
	private int numberOfCopies;
	
	public Movie(String pTitle, int pDuration, double pPrice, int pNumberCopies)
	{
		title = pTitle;
		duration = pDuration;
		price = pPrice;
		numberOfCopies = pNumberCopies;
	}

	public String getTitle() 
	{
		return title;
	}

	public int getDuration() 
	{
		return duration;
	}

	public double getPrice() 
	{
		return price;
	}

	public int getNumberOfCopies() 
	{
		return numberOfCopies;
	}
	
	

}
