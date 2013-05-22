//*******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                April 27, 2009
//Program Description: This DoubleCruiseNode class is a revamped 
//							  version of the DoubleIntNode class.
//*******************************************************************

public class DoubleCruiseNode
{
	// global variables
	private Cruise item;
  	private DoubleCruiseNode next;
  	private DoubleCruiseNode prev;
   
	/************************************************************
	DoubleCruiseNode()- DoubleCruiseNode constructor
	Input Parameters  - Cruise newItem
	Output			   - none
	*************************************************************/
  	public DoubleCruiseNode(Cruise newItem)
	{
   	item = newItem;
	 	next = null;
	 	prev = null;
	}// end DoubleCruiseNode constructor
	
	/************************************************************
	DoubleCruiseNode()- DoubleCruiseNode constructor
	Input Parameters  - Cruise newItem
								DoubleCruiseNode nextNode
								DoubleCruiseNode prevNode
	Output			   - none
	*************************************************************/
	public DoubleCruiseNode(Cruise newItem, DoubleCruiseNode nextNode, DoubleCruiseNode prevNode)
	{
   	item = newItem;
	 	next = nextNode;
	 	prev = prevNode;
	}// end DoubleCruiseNode constuctor
	
	/************************************************************
	setItem()		  - sets the item within this node to the 
								address of a specific Cruise
	Input Parameters - Cruise newItem, the cruise
	Output			  - none
	*************************************************************/
	public void setItem(Cruise newItem)
	{
		item = newItem;
	}// end setItem()
	
	/************************************************************
	getItem()		  - returns the item within this node
	Input Parameters - none
	Output			  - Cruise
	*************************************************************/
	public Cruise getItem()
	{
   	return this.item;
	}// end getItem()
	
	/************************************************************
	setNext()		  - sets this node's next reference to a 
								given address
	Input Parameters - DoubleCruiseNode newNode, the node
	Output			  - none
	*************************************************************/
	public void setNext(DoubleCruiseNode newNode)
	{
  		next = newNode;
  	}// end setNext()
 	
	/************************************************************
	getNext()		  - returns this node's next reference
	Input Parameters - none
	Output			  - DoubleCruiseNode
	*************************************************************/
 	public DoubleCruiseNode getNext()
	{
   	return this.next;
	}// end getNext()
	
	/************************************************************
	setPrev()		  - sets this node's previous reference to a
								given address
	Input Parameters - DoubleCruiseNode newNode, the node
	Output			  - none
	*************************************************************/
	public void setPrev(DoubleCruiseNode newNode)
	{
   	prev = newNode;
	}// end setPrev()
	
	/************************************************************
	getPrev()		  - returns this node's previous reference
	Input Parameters - none
	Output			  - DoubleCruiseNode
	*************************************************************/
	public DoubleCruiseNode getPrev()
	{
		return this.prev;
	}// end getPrev()
}// end DoubleCruiseNode class