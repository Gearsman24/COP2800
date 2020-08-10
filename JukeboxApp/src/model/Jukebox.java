package model;

public class Jukebox 
{
	private int numberOfAlbums;
	private Album album1, album2, album3;
	
	public Jukebox()	//This is a constructor
	{
		numberOfAlbums = 0;
	}
	
	//Method 1, Getter
	
	public int getNumberOfAlbums()
	{
		return numberOfAlbums;
	}
	
	//Method 2
	
	public boolean addAlbum(String pName, String pGenre, double pPrice, Interpreter pInterpreter)
	{
		boolean response = false;
		
		Album existingAlbum = searchAlbum(pName);
		
		if(existingAlbum == null)
		{
			if(album1 == null)
			{
				album1 = new Album(pName, pGenre, pPrice, pInterpreter);
				response = true;
				numberOfAlbums++;
			}
			
			else if(album2 == null)
			{
				album2 = new Album(pName, pGenre, pPrice, pInterpreter);
				response = true;
				numberOfAlbums++;
			}
			
			else if(album3 == null)
			{
				album3 = new Album(pName, pGenre, pPrice, pInterpreter);
				response = true;
				numberOfAlbums++;
			}
		}
		
		return response;
	}
	
	//Method 3
	
	public Album searchAlbum(String pName)
	{
		Album response = null;	//Must see if each album exists first
		
		if(album1 != null && album1.getName().equals(pName))
		{
			response = album1;
		}
		
		else if(album2 != null && album2.getName().equals(pName))
		{
			response = album2;
		}
		
		else if(album3 != null && album3.getName().equals(pName))
		{
			response = album3;
		}
		return response;
	}
	
	//Method 4
	
	public boolean addSong(String pName, int pDuration, String pNameAlbum)
	{
		boolean response = false;
		
		Album album = searchAlbum(pNameAlbum);
		
		if(album != null)
		{
			Song newSong = new Song(pName, pDuration);
			response = album.addSong(newSong);
		}
		
		return response;
	}
	
	//Method 5
	
	public Album getMostExpensiveAlbum()
	{
		Album mostExpensiveAlbum = null;	//Must see if each album exists first
		double maxPrice = 0.0;
		
		if(album1 != null && album1.getPrice()>maxPrice)
		{
			mostExpensiveAlbum = album1;
			maxPrice = album1.getPrice();  //value that is greater than 0.0
		}
		
		if(album2 != null && album2.getPrice()>maxPrice)
		{
			mostExpensiveAlbum = album2;
			maxPrice = album2.getPrice();	//value greater than album1 price (or 0.0 if album 1 DNE)
		}
		if(album3 != null && album3.getPrice()>maxPrice)
		{
			mostExpensiveAlbum = album3;
			maxPrice = album3.getPrice();	//value greater than album2 price (or 0.0 if album 2 DNE)
		}
			
		return mostExpensiveAlbum;
	}
}



