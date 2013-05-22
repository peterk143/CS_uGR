//*******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                April 27, 2009
//Program Description: This PassNode class is a revamped version
//							  of the IntNode class.
//*******************************************************************

public class PassNode
{
	// global variables
  	private Passenger item;
  	private PassNode next;
	
	/************************************************************
	PassNode()		  - PassNode constructor
	Input Parameters - Passenger newItem
	Output			  - none
	*************************************************************/
  	public PassNode(Passenger newItem)
	{
		item = newItem;
		next = null;
	}// end PassNode
	
	/************************************************************
	PassNode()		  - PassNode constructor
	Input Parameters - Passenger newItem
								PassNode nextNode
	Output			  - none
	*************************************************************/
	public PassNode(Passenger newItem, PassNode nextNode)
	{
   	item = newItem;
		next = nextNode;
	}// end PassNode constructor
	
	/************************************************************
	setItem()		  - sets the item within this node to the
								address of a specific Passenger
	Input Parameters - Passenger newItem, the passenger
	Output			  - none
	*************************************************************/
	public void setItem(Passenger newItem)
	{
		item = newItem;
	}// end setItem()
	
	/************************************************************
	getItem()		  - returns the item within this node
	Input Parameters - none
	Output			  - Passenger
	*************************************************************/
	public Passenger getItem()
	{
   	return this.item;
	}// end getItem()
	
	/************************************************************
	setNext()		  - sets this node's next reference to a 
								given address
	Input Parameters - PassNode newNode, the node
	Output			  - none
	*************************************************************/
	public void setNext(PassNode newNode)
	{
  		next = newNode;
  	}// end setNext()
 	
	/************************************************************
	getNext()		  - returns this node's next reference
	Input Parameters - none
	Output			  - PassNode
	*************************************************************/
 	public PassNode getNext()
	{
   	return this.next;
	}// end getNext()
}// end PassNode class