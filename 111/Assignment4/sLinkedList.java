//*******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                April 27, 2009
//Program Description: This sLinkedList is a singly linked list
//							  that utilizes the PassNode class and creates
//							  a linked list of passenger nodes.
//*******************************************************************

public class sLinkedList
{
	// global variables
	private PassNode head;
	private int count;
	
	/************************************************************
	sLinkedList()	  - sLinkedList constructor
	Input Parameters - none
	Output			  - none
	*************************************************************/
	public sLinkedList()
	{
		count = 0;
		head = null;
	}// end sLinkedList constructor
	
	/************************************************************
	size()			  - returns the size of this sLinkedList
	Input Parameters - none
	Output			  - int, the size
	*************************************************************/
	public int size()
	{
		return this.count;
	}// end size()
	
	/************************************************************
	insertOrdered()  - inserts a newValue into its correct 
								ordered location in the sLinkedList
	Input Parameters - Passenger newValue, the passenger
	Output			  - none
	*************************************************************/
	public void insertOrdered(Passenger newValue)
	{	
		// reference variables
		PassNode newNode;
		PassNode previousNode = null;
		PassNode nextNode = null;

		// sets nextNode to address the head
		// of the list so the head reference
		// will not be lost
		nextNode = head;
			
		// while the end of the list has not been
		// reached and until the new passenger's
		// location in the list has been reached
		while(nextNode != null && ((nextNode.getItem()).compareTo(newValue)) <= 0)
		{
			// previousNode and nextNode will
			// inch through the list until
			// the location for which the 
			// newNode will be placed is found
			previousNode = nextNode;
			nextNode = nextNode.getNext();
		}// end while
		
		// instantiates a new PassNode
		// with the item set to newValue
		newNode = new PassNode(newValue);	

		// if newNode will be inserted
		// into an otherwise empty list
		if(head == null)
		{
			// head is then set to address
			// the newNode
			head = newNode;
			++count;
		}// end if

		// if newNode will be inserted at the
		// head of an existing list
		else if(previousNode == null && nextNode != null)
		{
			// the newNode's next reference
			// is set to address the head
			// of the list
 			newNode.setNext(head);
			
			// head is then set to address
			// the newNode
			head = newNode;
			++count;
		}// end else if
 
		// if newNode will be inserted at the 
		// end of an existing list
		else if(nextNode == null && previousNode != null)
		{
			// the helper variable previousNode's
			// next reference is then set to 
			// address newNode
 			previousNode.setNext(newNode);
 			++count;
		}// end else if

		// otherwise newNode will be placed
		// somewhere in the middle of the list
		else
		{
			// previousNode's next reference 
			// is set to address the newNode
			// and newNode's next reference
			// is set to address the nextNode
 			previousNode.setNext(newNode);
			newNode.setNext(nextNode);
			++count;
		}// end else
	}// end insertOrdered()
	
	/************************************************************
	deletePassenger()- finds the passenger by comparing it to
								another copy of itself, and then 
								dislocates the passenger node from the
								sLinkedList
	Input Parameters - Passenger aPass, the passenger 
	Output			  - int, a negative number if the passenger
								was not found, or a positive number
								if the passenger was found
	*************************************************************/
	public int deletePassenger(Passenger aPass)
	{
		// reference variables
		PassNode previousNode = null;
		PassNode nextNode = null;
		
		// instance variable
		int temp = -999;
		
		// sets nextNode to address the head
		// of the list so the head reference
		// will not be lost
		nextNode = head;
		
		// while the end of the list has not been
		// reached and the nextNode's passenger
		// information is a lesser value 
		// alphabetically then the newNode's
		// passenger then previousNode is set to
		// nextNode and nextNode will be set to
		// its next node
		while(nextNode != null && (nextNode.getItem()).compareTo(aPass) < 0)
		{
			previousNode = nextNode;
			nextNode = nextNode.getNext();
		}// end while
		
		// if the end of the list has been reached
		// or nextNode's passenger is aplhabetically
		// greater then the newNode an error message
		// will be displayed
		if(nextNode == null || (nextNode.getItem()).compareTo(aPass) > 0)
		{
			System.out.println();
			System.out.println("ERROR:  passenger not found");
		}// end if
		
		// otherwise the node has been found
		// and will be deleted after the following
		else
		{
			// if the node to be deleted is at the 
			// head of the list then the head is set
			// to the head's next reference and the
			// count is decremented 
			if(previousNode == null && (nextNode.getItem()).compareTo(aPass) == 0)
			{
				head = nextNode.getNext();
				--count;
				temp = 100;
			}// end if
			
			// otherwise the previousNode's next
			// reference is set to nextNode's next
			// reference
			else
			{
				previousNode.setNext(nextNode.getNext());
				--count;
				temp = 1;
			}// end else
		}// end else
		
		// return statement
		return temp;
	}// end deletePassenger()

	/************************************************************
	getItem()		  - traverses through a singly linked list
								and returns each item thoughout the
								list
	Input Parameters - int position, the position in the list
	Output			  - Passenger
	*************************************************************/
	public Passenger getItem(int position)
	{
		// reference variables
		Passenger returnValue = null;
 		PassNode nextNode;
		
		// instance variable
		int num = 0;
 
 		// if the position is greater then 
		// the count of the list then the 
		// position is invalid and will
		// result in a error message
  		if(position > count)
			System.out.println("ERROR:  invalid position");
 		
		// otherwise the position was valid and
		// this will traverse the list until the
		// correct position is reached and then 
		// return the item within that node
		else
		{
			// sets nextNode to address the head
			// of the list so the head referenece
			// will not be lost
  	  		nextNode = head;
	 
  			for(int i = 2; i <= position; i++)
				nextNode = nextNode.getNext();
		
			returnValue = nextNode.getItem();
		}// end else
  
  		// return statement
 		return returnValue;
 	}// end getItem()
		
	/************************************************************
	printPassengerList()- prints the passenger list in 
									alphabetical order
	Input Parameters 	  - none
	Output			  	  - none
	*************************************************************/
	public void printPassengerList()
	{
		// instance variable
		int num = 1;
		
		// reference variable
		PassNode printNode = head;
		
		// the header for the passenger list
		// display
		System.out.println("   Last Name \t  First Name \t   Number of Tix");
		System.out.println("====================================================");
		
		// displays all of the passengers in
		// the cruise list 
		while(num <= this.size())
		{
			System.out.printf("%-2d %-18s %-16s %-3d%n", num, ((this.getItem(num)).getLastName()),
										((this.getItem(num)).getFirstName()), ((this.getItem(num)).getTix()));			
			
			printNode = printNode.getNext();
			num++;
		}// end while
		
		System.out.println();
	}// end display()
}// end sLinkedList class