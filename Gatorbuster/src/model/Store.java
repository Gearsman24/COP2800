package model;

import java.util.ArrayList;

public class Store 
{
	public ArrayList<Movie> movies;
	
	public Store()
	{
		movies = new ArrayList<Movie>();
	}
	
	public boolean addMovie(String pTitle, int pDuration, double pPrice, int pNumberCopies) throws Exception
	{
		boolean response = false;
		
		//Exception if movie exists in store already
		for (int i = 0; i < movies.size(); i++) 
		{
			Movie searchedMovie = movies.get(i);
			if(searchedMovie != null && searchedMovie.getTitle().contentEquals(pTitle))
			{
				throw new Exception("The movie is already in the store!");
			}
			
		}
		
		Movie newMovie = new Movie(pTitle, pDuration, pPrice, pNumberCopies);
		movies.add(newMovie);
		response = true;
		
		return response;
	}
	
	public double calculateAveragePrice()
	{
		double response = 0.0;
		int numMovies = 0;
		double price = 0.0;
		
		for (int i = 0; i < movies.size(); i++) 
		{
			Movie searchedMovie = movies.get(i);
			if(searchedMovie != null)
			{
				numMovies = numMovies + searchedMovie.getNumberOfCopies();
				price = price + searchedMovie.getPrice()*searchedMovie.getNumberOfCopies();
			}
			
		}
		
		if(numMovies != 0)
		{
			response = price/numMovies;
		}
		
		return response;
	}
	
	public int countNumberOfMoviesLowerPrice(double pPrice)
	{
		int response = 0;
		
		for (int i = 0; i < movies.size(); i++) 
		{
			Movie searchedMovie = movies.get(i);
			if(searchedMovie != null && searchedMovie.getPrice() < pPrice)
			{
				response++;
			}
			
		}
		
		return response;
	}
	
	public Movie findMostExoticMovie() //Least copies
	{
		Movie response = null;
		int minCopy = 100000;
		
		for (int i = 0; i < movies.size(); i++) 
		{
			Movie searchedMovie = movies.get(i);
			if(searchedMovie != null && searchedMovie.getNumberOfCopies() < minCopy)
			{
				response = searchedMovie;
				minCopy = searchedMovie.getNumberOfCopies();
			}
			
		}
		
		return response;
	}
	
	public Movie findMovie(String pTitle)
	{
		Movie response = null;
		
		for (int i = 0; i < movies.size() && response == null; i++) 
		{
			Movie searchedMovie = movies.get(i);
			if(searchedMovie != null && searchedMovie.getTitle().contentEquals(pTitle))
			{
				response = searchedMovie;
			}
			
		}
		
		return response;
	}
	
	public boolean removeMovie(String pTitle)
	{
		boolean response = false;
		Movie searchedMovie = findMovie(pTitle);
		if(searchedMovie != null)
		{
			movies.remove(searchedMovie);
			response = true;
		}
		
		return response;
	}

}
