//*******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                April 27, 2009
//Program Description: This is a Passenger class that implements the
//							  Comparable interface.
//*******************************************************************

public class Passenger implements Comparable
{
	// global variables
	private String lastName;
	private String firstName;
	private int numTix;
	
	/************************************************************
	Passenger()		  - Passenger constructor
	Input Parameters - String ln, the lastName
								String fn, the firstName
								int num, the numTix
	Output			  - none
	*************************************************************/
	public Passenger(String ln, String fn, int num)
	{
		lastName = ln;
		firstName = fn;
		numTix = num;
	}// end Passenger constructor
	
	//Getter methods
	/************************************************************
	getLastName()	  - returns this Passenger's last name
	Input Parameters - none
	Output			  - String, the lastName
	*************************************************************/
	public String getLastName()
	{
		return this.lastName;
	}// end getLastName()
	
	/************************************************************
	getFirstName()   - returns this Passenger's first name
	Input Parameters - none
	Output			  - String, the firstName
	*************************************************************/
	public String getFirstName()
	{
		return this.firstName;
	}// end getFirstName()
	
	/************************************************************
	getTix()			  - returns this Passenger's number of 
								tickets purchased
	Input Parameters - none
	Output			  - int, the numTix
	*************************************************************/
	public int getTix()
	{
		return this.numTix;
	}// end getTix()
	
	//Setter methods
	/************************************************************
	setLastName()	  - sets this Passenger's last name to a
								certain value
	Input Parameters - String ln, Passenger's last name
	Output			  - none
	*************************************************************/
	public void setLastName(String ln)
	{
		lastName = ln;
	}// end setLastName()
	
	/************************************************************
	setFirstName()	  - sets this Passenger's first name to a 
								certain value
	Input Parameters - String fn, Passenger's first name
	Output			  - none
	*************************************************************/
	public void setFirstName(String fn)
	{
		firstName = fn;
	}// end setFirstName()
	
	/************************************************************
	setNumTix()		  - sets this Passenger's number of tickets
								purchased to a certain value
	Input Parameters - int num, number of tickets purchased
	Output			  - none
	*************************************************************/
	public void setNumTix(int num)
	{
		numTix = num;
	}// end setNumTix()
	
	/************************************************************
	compareTo()		  - a user-defined interface that compares
								this Passenger to another object which 
								is then parsed into the Passenger class
	Input Parameters - Object obj, parsed to a Passenger
								instance
	Output			  - int, 0 if the objects are the same, a
								positive value if	this object is greater
								then, or a negative value if	this
								object is less then
	*************************************************************/
	public int compareTo(Object obj)
	{
		// instance variables
		int result = -999;
		Integer temp = -999;
		Integer temp2 = -999;
				
		// reference variable
		Passenger passB;
		
		// parses the input obj to a Passenger instance variable
		passB = (Passenger) obj;
		
		// compares the last names of both
		// Passengers and sets the int variable
		// result equal to a positive or a negative
		// number, or 0 if they are equal
		result = (this.lastName).compareTo(passB.lastName);
		
		// if the last names are equal then 
		// this will check the first names
		// setting result to the same values
		if(result == 0)
			result = (this.firstName).compareTo(passB.firstName);
		
		// if the first names are equal then
		// this will check the number of tickets
		// purchased to make sure the Passengers are
		// in fact the same
		if(result == 0)
		{
			// uses a the Integer wrapper class
			// to change the ints into Integer objects
			temp = (Integer) this.getTix();
			temp2 = (Integer) passB.getTix();
		
			// determines equivalence
			result = (temp).compareTo(temp2);
		}// end if
		
		// return statement
		return result;
	}// end compareTo()
}// end Passenger class