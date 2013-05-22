public class sLinkedList {

 private IntNode head;
 private int count;
 
 public sLinkedList(){
 count =0;
 head = null;
}

public int size() {
 return count;
 }
 
 
/*************** insert at head****************/
public void insertAtHead(int newValue) {
IntNode newNode;

if (head == null) {
head = new IntNode( newValue);
++count;
}
else {
newNode = new IntNode(newValue);
newNode.setNext(head);

head = newNode;
++count;
}
}// end insertAtHead;


/***************** insert at tail ******************/

public void insertAtEnd(int newValue) {

IntNode newNode,nextNode;

if (head == null) {
head = new IntNode( newValue);
++count;
}
else {
nextNode = head;

while (nextNode.getNext() != null) {
nextNode = nextNode.getNext();
}

newNode = new IntNode(newValue);
nextNode.setNext( newNode);
count++;

}
} // end insertATEnd;

/*************** insert ordered ************/
public void insertOrdered(int newValue) {

IntNode newNode;
IntNode previousNode=null, nextNode=null;

nextNode = head;

while( nextNode != null && nextNode.getItem() < newValue) {
previousNode = nextNode;
nextNode = nextNode.getNext();
}
newNode =new IntNode(newValue);

// see if inserting first element
if (head == null){
head = newNode;
++count;
}

// see if inserting at head of existing list

else if (previousNode == null && nextNode != null) {
  newNode.setNext(head);
  head = newNode;
  ++count;
}
 
// see if inserting at end of existing list

else if (nextNode == null && previousNode != null) {
  previousNode.setNext(newNode);
  ++count;
}

// else adding in middle

else {
  previousNode.setNext(newNode);
  newNode.setNext(nextNode);
  ++count;
 }

} // end insert ordered

/******  delete *****/
public void delete(int aValue) {

IntNode previousNode = null, nextNode = null;

// look through the list for a value >= aValue
nextNode = head;

while (nextNode != null && nextNode.getItem() < aValue) {
previousNode = nextNode;
nextNode = nextNode.getNext();
}

if (nextNode == null  || nextNode.getItem() > aValue){
System.out.println("The value was not found and could not" 
+ " be deleted. " );
return;
}
//  A node was found
// check to see if it was the head of the list.
if (previousNode == null) {
head = nextNode.getNext();
--count;
}
else {
previousNode.setNext( nextNode.getNext());;
--count;
}
} // end delete


public int getValue(int position) {
 
 int returnValue=-999;
 IntNode nextNode;
 
 if(position > count) System.out.println("No such node,position too big");
 else{
     nextNode = head;
   
    for(int i=2; i<= position; i++){
   nextNode = nextNode.getNext();
  }
  
  returnValue = nextNode.getItem();
  
  }// end else
  
  return returnValue;
  }// end getvalue
} // end sLinkedList
