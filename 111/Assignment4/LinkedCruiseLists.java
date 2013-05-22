//*******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                April 27, 2009
//Program Description: This program displays a menu to the user
//							  asking for some information regarding a cruise
//							  and its passengers and places them into the 
//							  appropriate lists.  It also prints the cruise
//							  list forwards and backwards.  The user also 
//							  has the option to print a detailed list of
//							  a specific cruise and its passengers or a
//							  summarized list of just one cruise.
//*******************************************************************

// import statements
import java.util.*;
import java.io.*;

public class LinkedCruiseLists
{
	// class data member
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException
	{
		// instance variables
		int del = 0;
		int num = 1;
		int book = 0;
		int choice = -999;
		int count, id, max, temp, tx;
		boolean done = false;
		
		// reference variables
		String name, date, port;
		String fn, ln, inData;
		
		// instantiates a new instance
		// of a doubly linked list
		dLinkedList cruiseList = new dLinkedList();
		
		// asks for the file location and stores
		// it into a variable
		System.out.print("Where is the file located: ");
		inData = console.next();
		System.out.println();
		
		// imports the .txt file into a variable
		Scanner inFile = new Scanner(new FileReader(inData));
		
		// while the inFile has more data each line
		// will be broken up into sections and stored
		// into the appropriate variables and then
		// used to call the Cruise constructor and
		// then insert the cruise into the doubly
		// linked list in ascending order by cruiseID
		while(inFile.hasNext())
		{	
			id = inFile.nextInt();
			name = inFile.next();
			date = inFile.next();
			port = inFile.next();
			max = inFile.nextInt();
			
			Cruise newCruise = new Cruise(id, name, date, port, max, book);
			
			cruiseList.insert(newCruise);
			num++;
		}// end while
		
		// while the user is not done manipulating 
		// the cruises the following menu will be diplayed
		while(!done)
		{
			System.out.print("Choose from the following options.");
			System.out.println();
			System.out.println("Add a cruise	-1-");
			System.out.println("Delete a cruise	-2-");
			System.out.println("Add a passenger	-3-");
			System.out.println("Delete a passenger	-4-");
			System.out.println("Print forward	-5-");
			System.out.println("Print backwards	-6-");
			System.out.println("Detailed printout	-7-");
			System.out.println("Summary printout	-8-");
			System.out.println("Exit		-0-");
			System.out.println();
			System.out.print("What would you like to do: ");
			choice = console.nextInt();
			System.out.println();
			
			switch(choice)
			{
				// list manipulation has been completed
				case 0:
					done = true;
					break;
				
				// adding a new cruise
				case 1:
					System.out.println("Please enter the following information:");
					System.out.print("Cruise ID:         ");
					id = console.nextInt();					
					System.out.print("Cruise Name:       ");
					name = console.next();
					System.out.print("Depature Date:     ");
					date = console.next();
					System.out.print("Depature Port:     ");
					port = console.next();
					System.out.print("Max Passengers:    ");
					max = console.nextInt();

					// calls the Cruise constructor with the
					// inputs indicated by the user
					Cruise newCruise = new Cruise(id, name, date, port, max, book);
					
					// inserts the cruise in an ordered
					// fashion into the doubly linked list
					cruiseList.insert(newCruise);
					System.out.println();
					break;
					
				// deleting an existing cruise
				case 2:
					System.out.print("Enter the Cruise ID number: ");
					id = console.nextInt();
					System.out.println();
					
					// calls the delete method which finds
					// and deletes the cruise indicated by 
					// it id number
					cruiseList.delete(id);
					break;
					
				// add a passenger to a cruise
				case 3:
					System.out.print("Enter the Cruise ID number: ");
					id = console.nextInt();
					System.out.println();
					
					// if the find method returns null as
					// the position of the cruise node then 
					// an error message will be displayed
					if(cruiseList.find(id) == null)
					{
						System.out.println("ERROR:  cruise not found");
					}// end if
					
					// otherwise the user is then prompted for 
					// the new passenger information
					else
					{
						System.out.println("Enter the following information");
						System.out.println("   about the passenger.");
						System.out.print("First Name: ");
						fn = console.next();
						System.out.print("Last Name:  ");
						ln = console.next();
						System.out.print("Tickets Purchased: ");
						tx = console.nextInt();
						
						// a new Passenger is then created with the
						// inputs from the user
						Passenger cPass = new Passenger(ln, fn, tx);
		
						// finds the cruise indicated by the user
						// and returns its position
						DoubleCruiseNode cNode = cruiseList.find(id);
							
						// stores the cruise instance in the node to
						// a variable
						Cruise cCruise = cNode.getItem();
						
						// if the number of tickets purchased by one person
						// plus the number of guests booked exceeds the 
						// maximum passenger capacity then an error will be
						// displayed
						if(tx + cCruise.getBookedPassenger() > cCruise.getMaxPassenger())
						{
							System.out.println();
							System.out.println("ERROR:  ticket count exceeds maximum capacity");
						}// end if
						
						// otherwise the passenger will be placed into
						// the cruise's passengerList
						else
						{											
							(cCruise.getPassList()).insertOrdered(cPass);
							
							temp = cCruise.getBookedPassenger();
							cCruise.setBookedPassenger(temp + tx);
						}// end else
					}// end else
					
					System.out.println();
					break;
				
				// delete a passenger from a cruise
				case 4:
					System.out.print("Enter the Cruise ID number: ");
					id = console.nextInt();
					
					// if the find method returns null as
					// the position of the cruise node then 
					// an error message will be displayed
					if(cruiseList.find(id) == null)
					{
						System.out.println();
						System.out.println("ERROR:  cruise not found");
					}// end if
					
					// otherwise the user is then prompted for 
					// the new passenger information
					else
					{
						System.out.println("Enter the following information");
						System.out.println("   about the passenger.");
						System.out.print("First Name: ");
						fn = console.next();
						System.out.print("Last Name:  ");
						ln = console.next();
						System.out.print("Tickets Purchased: ");
						tx = console.nextInt();
						
						// a new passenger is created with the inputs
						// from the user
						Passenger dPass = new Passenger(ln, fn, tx);
	
						// the cruise is then found and the node is
						// stored to a variable
						DoubleCruiseNode dNode = cruiseList.find(id);
						
						// the node's cruise is then stored to
						// another variable
						Cruise dCruise = dNode.getItem();
						
						del = (dCruise.getPassList()).deletePassenger(dPass);
						
						// if the deletePassenger method returns a
						// number greater then 0 then the amount of
						// passengers booked is decreased by the amount
						// of tickets that particular passenger purchased
						if(del > 0)
						{
							temp = dCruise.getBookedPassenger();
							dCruise.setBookedPassenger(temp - tx);
						}// end if
					}// end else
					
					System.out.println();
					break;
					
				// print all the cruises forward
				case 5:
					cruiseList.printForward();
					break;
				
				// print all the cruises backwards
				case 6:
					cruiseList.printBackwards();
					break;
					
				// prints a cruise and its passengers
				case 7:
					System.out.print("Enter the Cruise ID number: ");
					id = console.nextInt();
					
					// if the find method returns null as
					// the position of the cruise node then 
					// an error message will be displayed
					if(cruiseList.find(id) == null)
					{
						System.out.println();
						System.out.println("ERROR:  cruise not found");
						System.out.println();
					}// end if
					
					// otherwise the cruise is found and
					// the printDetail method is called
					else
					{					
						DoubleCruiseNode aNode = cruiseList.find(id);
						
						Cruise aCruise = aNode.getItem();
						
						aCruise.printDetail();
					}// end else
					break;
					
				// prints a cruise summary
				case 8:
					System.out.print("Enter the Cruise ID number: ");
					id = console.nextInt();
					
					// if the find method returns null as
					// the position of the cruise then 
					// an error message will be displayed
					if(cruiseList.find(id) == null)
					{
						System.out.println();
						System.out.println("ERROR:  cruise not found");
						System.out.println();
					}// end if
					
					// otherwise the cruise is found and
					// prints off a summarized version
					// of the cruise's information
					else
					{
						DoubleCruiseNode bNode = cruiseList.find(id);
						
						Cruise bCruise = bNode.getItem();
						
						bCruise.printSummary();
					}// end else
					break;
					
					// if the input by the user is not a number 0 - 8
					// then an error message will be displayed 
					// and the menu will be reshown
					default:
						System.out.println();
						System.out.println("ERROR:  invalid entry");
						System.out.println();
			}// end switch
		}// end while
	}// end main()
}// end LinkedCruiseLists class