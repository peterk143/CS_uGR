//*******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                April 27, 2009
//Program Description: This is a Cruise class that implements the 
//                     Comparable interface.
//*******************************************************************

public class Cruise implements Comparable
{
	// global variables
	private int cruiseID;
	private String shipName;
	private String deptDate;
	private String deptPort;
	private int maxPass;
	private int passBooked;
	private sLinkedList passList;
	
	/************************************************************
	Cruise()	 		  - Cruise constructor
	Input Parameters - int id, the cruiseID
								String name, the shipName
								String date, the deptDate
								String port, the deptPort
								int max, the maxPass
								int booked, the passBooked
	Output			  - none
	*************************************************************/
	public Cruise(int id, String name, String date, String port,
								int max, int booked)
	{
		cruiseID = id;
		shipName = name;
		deptDate = date;
		deptPort = port;
		maxPass = max;
		passBooked = booked;
		passList = new sLinkedList();
	}// end Cruise constructor
	
	// Getter methods
	/************************************************************
	getID()	 		  - returns this cruise's ID number
	Input Parameters - none
	Output			  - int, the cruiseID
	*************************************************************/
	public int getID()
	{
		return this.cruiseID;
	}// end getID()
	
	/************************************************************
	getName()		  - returns this cruise's name
	Input Parameters - none
	Output			  - String, the shipName
	*************************************************************/
	public String getName()
	{
		return this.shipName;
	}// end getName()
	
	/************************************************************
	getDeptDate()	  - returns this cruise's departure date
	Input Parameters - none
	Output			  - String, the deptDate
	*************************************************************/
	public String getDeptDate()
	{
		return this.deptDate;
	}// end getDeptDate()
	
	/************************************************************
	getDeptPort()	  - returns this cruise's departure port
	Input Parameters - none
	Output			  - String, the deptPort
	*************************************************************/
	public String getDeptPort()
	{
		return this.deptPort;
	}// end getDeptPort()
	
	/************************************************************
	getMaxPassenger()- returns this cruise's maximum capacity
	Input Parameters - none
	Output			  - int, the maxPass
	*************************************************************/
	public int getMaxPassenger()
	{
		return this.maxPass;
	}// end getMaxPassenger()
	
	/************************************************************
	getBookedPassenger()- returns this cruise's number of booked
									passengers
	Input Parameters    - none
	Output			     - int, the passBooked
	*************************************************************/
	public int getBookedPassenger()
	{
		return this.passBooked;
	}// end getBookedPassenger()
	
	/************************************************************
	getPassList()	  - returns this cruise's passenger list
	Input Parameters - none
	Output			  - sLinkedList, the passList
	*************************************************************/
	public sLinkedList getPassList()
	{
		return this.passList;
	}// end getPassList()

	// Setter method
	/************************************************************
	setBookedPassenger()- sets the number of passengers booked
									to a certain value
	Input Parameters    - int num, number of passengers booked
	Output			     - none, void
	*************************************************************/
	public void setBookedPassenger(int num)
	{
		passBooked = num;
	}// end setBookedPassenger()
		
	/************************************************************
	compareTo()		  - a user-defined interface that compares
								this cruise to another object which
								is then parsed into the Cruise class
	Input Parameters - Object obj, parsed to a Cruise 
								instance
	Output			  - int, 0 if the objects are the same, 1 if 
								this object is greater then, or -1 if
								this object is less then 
	*************************************************************/
	public int compareTo(Object obj)
	{
		// reference variable
		Cruise aCruise;
		
		// parses the input obj to a Cruise instance variable
		aCruise = (Cruise) obj;
		
		// if the cruise id's are the same
		// return 0
		if(this.getID() == aCruise.getID())
			return 0;
		
		// if this cruise's id is greater then
		// return 1
		else if(this.getID() > aCruise.getID())
			return 1;
		
		// if the cruise's id is less then 
		// return -1
		else
			return -1;
	}// end compareTo()
	
	/************************************************************
	printDetail()	  - prints this cruise's information including
								the passenger list
	Input Parameters - none
	Output			  - none
	*************************************************************/
	public void printDetail()
	{	
		// prints this cruise's information
		System.out.println();
		System.out.println("ID \t  NAME \t\t  DEPARTURE \t PORT \t\t CAPACITY \t BOOKED");
		System.out.println("---------------------------------------------------------------------------");
		System.out.printf("%-5d %-15s %-14s %-15s %-15d %-4d%n", (this.getID()), 
										(this.getName()), (this.getDeptDate()),
										(this.getDeptPort()), (this.getMaxPassenger()),
										(this.getBookedPassenger()));
							
		System.out.println();
		
		// prints this cruise's passenger list
		passList.printPassengerList();
	}// end printDetail()
	
	/************************************************************
	printSummary()   - prints this cruise's information minus
								its passenger list
	Input Parameters - none
	Output			  - none
	*************************************************************/
	public void printSummary()
	{
		// prints this cruise's information
		System.out.println();
		System.out.println("ID \t  NAME \t\t  DEPARTURE \t PORT \t\t CAPACITY \t BOOKED");
		System.out.println("---------------------------------------------------------------------------");
		System.out.printf("%-5d %-15s %-14s %-15s %-15d %-4d%n", (this.getID()), 
										(this.getName()), (this.getDeptDate()),
										(this.getDeptPort()), (this.getMaxPassenger()),
										(this.getBookedPassenger()));
	
		System.out.println();
	}// end printSummary()
}// end Cruise class