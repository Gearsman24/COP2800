package model;


public class League 
{
	//These are the fields
	private int numberOfMembers;
	public int FEMALE = 1;
	public int MALE = 2;
	
	//Array of Members
	public static final int NUM_MEMBERS = 10000;
	private Member[] members;
	
	//This is the constructor method
	public League()
	{
		int numberOfMembers = 0;
		members = new Member[NUM_MEMBERS];
	}
	
	//Method 1
	public boolean addNewMember(String pAlias, String pName, String pSurname, int pBioSex, int pAge, double pIncome) throws Exception
	{
		boolean response = false;
		
		for(int i = 0; i < members.length && response == false; i++)
		{
			//Exception if the member is already in the system
			if(members[i] != null && members[i].getAlias().contentEquals(pAlias))
			{
				throw new Exception("The member is already in the system");
			}
			
			else if(members[i] == null)
			{
				members[i] = new Member(pAlias, pName, pSurname, pBioSex, pAge, pIncome);
				numberOfMembers++;
				response = true;
			}
		}
		
		return response;
	}
	
	//Method 2
	public Member searchMember(String pAlias)
	{
		Member response = null;
		
		for(int i = 0; i < members.length && response == null; i++)
		{
			if(members[i] != null && members[i].getAlias().contentEquals(pAlias))
			{
				response = members[i];
			}
		}
		
		return response;
	}
	
	//Method 3
	public int countHeroines()
	{
		int response = 0;
		
		for(int i = 0; i < members.length; i++)
		{
			if(members[i] != null && members[i].getBioSex() == 1)
			{
				response++;
			}
		}
		
		return response;
	}

	//Method 4
	public double maleAverageIncome()
	{
		double response = 0.0;
		double maleIncome = 0.0;
		int maleExist = 0;
		
		for(int i = 0; i < members.length; i++)
		{
			if(members[i] != null && members[i].getBioSex() == 2)
			{
				maleIncome = maleIncome + members[i].getIncome();
				maleExist++;
			}
		}
		
		if(maleExist != 0)
		{
			response = maleIncome/maleExist;
		}
		else
		{
			response = -1.0;
		}
		
		return response;
	}
	
	//Method 5
	public double maleCalculateAverageAge()
	{
		double response = 0.0;
		int memberAge = 0;
		int memberExist = 0;
		
		for(int i = 0; i < members.length; i++)
		{
			if(members[i] != null && members[i].getBioSex() == 2)
			{
				memberAge = memberAge + members[i].getAge();
				memberExist++;
			}
		}
		
		if(memberExist != 0);
		{
			response = memberAge/memberExist;
		}

		return response;
	}
	
	//Method 6
	public Member findYoungestMember()
	{
		Member response = null;
		int minAge = 1000000;
		
		for(int i = 0; i < members.length; i++)
		{
			if(members[i] != null && members[i].getAge() < minAge)
			{
				minAge = members[i].getAge();
				response = members[i];
			}
		}
		
		return response;
	}
}
