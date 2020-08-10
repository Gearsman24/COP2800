package model;

public class Album 
{
	private String name;
	private String genre;
	private double price;
	private int numberOfSongs;
	
	private Interpreter interpreter;
	
	private Song song1, song2, song3, song4, song5;
	
	
	public Album(String pName, String pGenre, double pPrice, Interpreter pInterpreter)	//This is a constructor
	{
		name = pName;
		genre = pGenre;
		price = pPrice;
		interpreter = pInterpreter;
		numberOfSongs = 0;
	}
	
	//Method 1
	
	public boolean addSong(Song pSong)
	{
		boolean response = false;
		
		Song existingSong = searchSong(pSong.getName());	//This is a local variable
		
		if(existingSong == null) 
		{
			if(song1 == null)
			{
				song1 = pSong;
				response = true;
				numberOfSongs++;
			}
			
			else if(song2 == null)
			{
				song2 = pSong;
				response = true;
				numberOfSongs++;
			}
			
			else if(song3 == null)
			{
				song3 = pSong;
				response = true;
				numberOfSongs++;
			}
			
			else if(song4 == null)
			{
				song4 = pSong;
				response = true;
				numberOfSongs++;
			}
			
			else if(song5 == null)
			{
				song5 = pSong;
				response = true;
				numberOfSongs++;
			}
		}
		
		return response;
	}
	
	//Method 2
	
	public Song searchSong(String pName)
	{
		Song response = null; //Must see if each song exists first
		
		if(song1 != null && song1.getName().equals(pName))
		{
			response = song1;
		}
		
		else if(song2 != null && song2.getName().equals(pName))
		{
			response = song2;
		}
		
		else if(song3 != null && song3.getName().equals(pName))
		{
			response = song3;
		}
		
		else if(song4 != null && song4.getName().equals(pName))
		{
			response = song4;
		}
		
		else if(song5 != null && song5.getName().equals(pName))
		{
			response = song5;
		}
		
		return response;
	}

	//These are Getters
	
	public String getName() 
	{
		return name;
	}

	public String getGenre() 
	{
		return genre;
	}

	public double getPrice() 
	{
		return price;
	}

	public int getNumberOfSongs() 
	{
		return numberOfSongs;
	}

	public Interpreter getInterpreter() 
	{
		return interpreter;
	}

	public Song getSong1() 
	{
		return song1;
	}

	public Song getSong2() 
	{
		return song2;
	}

	public Song getSong3() 
	{
		return song3;
	}

	public Song getSong4() 
	{
		return song4;
	}

	public Song getSong5() 
	{
		return song5;
	}
	
	
}
