//*******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                April 27, 2009
//Program Description: This dLinkedList is a doubly linked list 
//							  that utilizes the DoubleCruiseNode class and
//							  creates a linked list of cruise nodes.
//*******************************************************************

public class dLinkedList
{
	// global variables
	private DoubleCruiseNode head;
	private DoubleCruiseNode tail;
	private int count;
	
	/************************************************************
	dLinkedList()	  - dLinkedList constructor
	Input Parameters - none
	Output			  - none
	*************************************************************/
	public dLinkedList()
	{
		count = 0;
		head = null;
		tail = null;
	}// end dLinkedList constructor
	
	/************************************************************
	size()	 		  - returns the size of this dLinkedList
	Input Parameters - none
	Output			  - int, the size
	*************************************************************/
	public int size()
	{
		return this.count;
	}// end size()
	
	/************************************************************
	insert()			  - inserts a newValue into its correct
								ordered location in the dLinkedList
	Input Parameters - Cruise newValue, the cruise
	Output			  - none
	*************************************************************/
	public void insert(Cruise newValue)
	{
		// reference variables
		DoubleCruiseNode newNode;
		DoubleCruiseNode previousNode = null;
		DoubleCruiseNode nextNode = null;
		
		// instantiates a new DoubleCruiseNodenode
		// with the item set to newValue
		newNode = new DoubleCruiseNode(newValue);
		
		// if there is nothing in the list
		// this sets the head and tail to
		// address the newly allocated
		// node
		if(count == 0)
		{
			head = newNode;
			tail = newNode;
			count++;
		}// end if
		
		// if the cruiseID in the head of the 
		// list is greater then the 
		// cruiseID of the newly allocated
		// node then this places the newNode
		// before the head node and makes
		// head to point to the newNode
		else if((head.getItem()).getID() > (newNode.getItem()).getID())
		{
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
			count++;
		}// end else if
		
		// if the cruiseID in the tail of the
		// list is less then the cruiseID
		// of the newly allocated node then
		// this places the newNode after the 
		// node at the tail end of the list
		// and makes tail point to the newNode
		else if((newNode.getItem()).getID() > (tail.getItem()).getID())
		{
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
			count++;
		}// end else if
		
		// otherwise the node will be placed
		// somewhere in the middle of the list
		else
		{
			// sets nextNode to address the head 
			// of the list so the head reference
			// will not be lost
			nextNode = head;
			
			// while the end of the list has not been 
			// reached and the nextNode's cruiseID is 
			// less then the newNode's cruiseID then
			// nextNode will be set to its next node
			while(nextNode != null && (nextNode.getItem()).getID() < (newNode.getItem()).getID())
			{
				nextNode = nextNode.getNext();
			}// end while
			
			// saves nextNode's previous node to 
			// previousNode
			previousNode = nextNode.getPrev();
			
			// sets nextNode's previous node
			// to the newNode
			nextNode.setPrev(newNode);
			
			// sets newNode's next node to 
			// nextNode
			newNode.setNext(nextNode);
			
			// sets newNode's previous node
			// to previousNode
			newNode.setPrev(previousNode);
			
			// sets previousNode's next node
			// to newNode
			previousNode.setNext(newNode);
			count++;
		}// end else
	}// end insert()
	
	/************************************************************
	delete()			  - finds the cruise identified by its ID
								number, and dislocates the cruise node
								from the dLinkedList
	Input Parameters - int id, the cruise ID
	Output			  - none
	*************************************************************/
	public void delete(int id)
	{
		// reference variables
		DoubleCruiseNode nextNode = null;
		DoubleCruiseNode foundNode = null;
		int temp = 0;
		
		// calls the method find() to 
		// find the cruise distinguished 
		// by its id and sets the address
		// to the variable foundNode
		foundNode = this.find(id);
		
		// if the cruise was not found 
		// an error message is given
		if(foundNode == null)
		{
			System.out.println("ERROR:  cruise not found");
			System.out.println();
		}// end if
		
		else
		{
			// if the desired cruise is the only
			// cruise in the list and the cruiseID
			// is equal to the given id then it sets
			// head and tail to null, dropping the
			// node from the list
			if(count == 1 && (head.getItem()).getID() == id)
			{
				head = null;
				tail = null;
				--count;
			}// end if
			
			// if the given id is equal to the id
			// of the cruise at the head of the 
			// list then this sets the new head
			// to be the head's next node and sets
			// that node's previous node to null
			else if((head.getItem()).getID() == id)
			{
				head = head.getNext();
				head.setPrev(null);
				--count;
			}// end else if
			
			// if the given id is equal to the id
			// of the cruise at the tail of the 
			// list then this sets the new tail
			// to be the tail's previous node and
			// sets that node's next node to null
			else if((tail.getItem()).getID() == id)
			{
				tail = tail.getPrev();
				tail.setNext(null);
				--count;
			}// end else if
			
			// otherwise
			else
			{
				// nextNode is set to have the 
				// same address as head
				nextNode = head;
				
				// while the end of the list has not
				// been reached and nextNode's cruiseID
				// is still less then the search id
				while(nextNode != null  && (nextNode.getItem()).getID() < id)
				{
					// nextNode will be set to 
					// nextNode's next node
					nextNode = nextNode.getNext();
				}// end while
				
				// if the end of the list has been reached
				// or nextNode's cruiseID is greater then 
				// the search id
				if(nextNode == null || (nextNode.getItem()).getID() > id)
				{
					// an error message will be displayed
					System.out.println("ERROR:  cruise not found");
				}// end if
				
				// otherwise if the node is found
				else
				{
					// links around the node being deleted
					// and sets that node's next and previous
					// pointers to null
					(nextNode.getNext()).setPrev(nextNode.getPrev());
					(nextNode.getPrev()).setNext(nextNode.getNext());
					nextNode.setNext(null);
					nextNode.setPrev(null);
					count--;
				}// end else
			}// end else
		}// end else
	}// end delete()
	
	/************************************************************
	find()			  - finds the cruise identified by its ID
								number and returns its address
	Input Parameters - int id, the cruiseID
	Output			  - DoubleCruiseNode
	*************************************************************/
	public DoubleCruiseNode find(int id)
	{
		// reference variables
		DoubleCruiseNode targetNode = null;
		
		// sets the targetNode to address
		// the head of the list
		targetNode = head;
		
		// while the end of the list has not
		// been reached and the targetnode's
		// cruiseID is less then or equal to
		// the search id value
		while(targetNode != null && ((targetNode.getItem()).getID()) <= id)
		{			
			// if the targetNode's cruiseID is equal
			// the the search id value
			if((targetNode.getItem()).getID() == id)
			{
				// then the targetNode's address
				// will be returned to the 
				// calling method
				return targetNode;
			}// end if
			
			// otherwise the targetNode is 
			// set to address the next
			// node in the list
			else
			{
				targetNode = targetNode.getNext();
			}// end else
		}// end while
		
		// if not found null is returned
		// to the calling method
		return null;
	}// end find()
	
	/************************************************************
	printForward()	  - prints the cruise list in ascending order
								with regards to the cruiseID
	Input Parameters - none
	Output			  - none
	*************************************************************/
	public void printForward()
	{
		// reference variables
		DoubleCruiseNode nextNode = null;
		
		// sets nextNode to address
		// the head of the list 
		nextNode = head;
		
		// the header for the cruise list
		// display 
		System.out.println("ID \t  NAME \t\t  DEPARTURE \t PORT \t\t CAPACITY \t BOOKED");
		System.out.println("---------------------------------------------------------------------------");
		
		// while the end of the list has 
		// not been reached each this will
		// print of the cruise's data members
		// in a formatted fashion
		while(nextNode != null)
		{
			System.out.printf("%-5d %-15s %-14s %-15s %-15d %-4d%n", ((nextNode.getItem()).getID()), 
										((nextNode.getItem()).getName()), ((nextNode.getItem()).getDeptDate()),
										((nextNode.getItem()).getDeptPort()), ((nextNode.getItem()).getMaxPassenger()),
										((nextNode.getItem()).getBookedPassenger()));
			
			// after the cruise is displayed to
			// the user the next cruise is then
			// accessed and printed until the
			// end of the list is reached
			nextNode = nextNode.getNext();
		}// end while 
		
		System.out.println();
	}// end printForward()
	
	/************************************************************
	printBackwards() - prints the cruise list in descending 
								order with regards to the cruiseID
	Input Parameters - none
	Output			  - none
	*************************************************************/
	public void printBackwards()
	{
		// reference variable
		DoubleCruiseNode previousNode = null;
		
		// sets previousNode to address
		// the tail of the list
		previousNode = tail;
		
		// the header for the cruise list
		// display
		System.out.println("ID \t  NAME \t\t  DEPARTURE \t PORT \t\t CAPACITY \t BOOKED");
		System.out.println("---------------------------------------------------------------------------");

		// while the end of the list has 
		// not been reached each this will
		// print of the cruise's data members
		// in a formatted fashion		
		while(previousNode != null)
		{	
			System.out.printf("%-5d %-15s %-14s %-15s %-15d %-4d%n", ((previousNode.getItem()).getID()), 
										((previousNode.getItem()).getName()), ((previousNode.getItem()).getDeptDate()),
										((previousNode.getItem()).getDeptPort()), ((previousNode.getItem()).getMaxPassenger()),
										((previousNode.getItem()).getBookedPassenger()));
				
			// after the cruise is displayed to
			// the user the next cruise is then
			// accessed and printed until the
			// beginning of the list is reached
			// in reverse order					
			previousNode = previousNode.getPrev();
		}// end while
		
		System.out.println();
	}// end printBackwards()
}// end dLinkedList class