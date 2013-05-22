//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                October 30, 2008
//Program Description: This program creates the Class Person.
//Question:				  Ch 8, Ex 4a, Pg 545
//***********************************************************

public class Person
{
	//instance variables
	private String firstName;
	private String middleName;
	private String lastName;
	
	//default constructor
	public Person()
	{
		firstName = "";
		middleName = "";
		lastName = "";
	}
	
	//other constructors
	public Person(String first, String middle, String last)
	{
		setName(first, middle, last);
	}
	
	//methods	
	public String toString()
	{
		return(firstName + " " +lastName + " " + middleName);
	}
	
	public void setName(String first, String last)
	{
		firstName = first;
		lastName = last;
	}

	public void setName(String first, String middle, String last)
	{
		firstName = first;
		middleName = middle;
		lastName = last;
	}
	
	public void setFirstName(String first)
	{
		firstName = first;
	}
	
	public void setMiddleName(String middle)
	{
		middleName = middle;
	}
	
	public void setLastName(String last)
	{
		lastName = last;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public boolean equals(String name1, String name2)
	{
		if(name1 == name2)
			return true;
		else
			return false;
	}
	
	public void makeCopy(String name)
	{
		String Name;
		Name = name;
	}
	
	public String getCopy()
	{
		String Name = "";
		return Name;
	}
	
	public Person(Person otherPerson)
	{
		firstName = otherPerson.firstName;
		middleName = otherPerson.middleName;
		lastName = otherPerson.lastName;
	}
}