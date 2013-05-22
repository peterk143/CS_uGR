public class SortedList{
/**
_This class implements a sorted, array based list of integers
_@author  Camille Hayhurst
_@version  1.0
*/

// Data members

int currentSize; // current #of elements in the lsit
int maxSize;  // maximum number of elements the list can hold
int[] elements; // storage for elements


/**
_Constructor which creates a new list, & initializes data members
_
_Preconditions:  maxsize >=0;
_
_@param maxSize maximum number of elements in the list
_
_*/

public SortedList(int maxElements) {
currentSize =0;
maxSize = maxElements;
elements = new int[maxSize];
}

 

/**
_This method returns true if the current number of elements in the
_list equals the maximum number of elements in the list, thus
_indicating that the list is full
_
_@return boolean, true if # of elements equals maximum

*/
public boolean isFull() {
return (currentSize == maxSize);
}

/**
_This method returns true if the current number of elements in the
_list is zero.

_@return boolean,  true of # of elements equals zero
*/
public boolean isEmpty(){
return (currentSize == 0);
}


/** 
_Retrieves the number of elements in the list
_
_@return  current element count
*/
public int size() {
return (currentSize);
}

/**
_Retrieves the maximum number of elements the list can contain
_@return  maximum element count
*/
public int getMaxSize() {
return(maxSize);
}

public int find(int value) {

// initialize the return value to not found
int location= -999;

//Begin searching at the first element, to the last
for (int i=0;  i <= this.currentSize-1; i++) {
if (this.elements[i] == value) {
location = i+1;
break;  // if found exit loop
}
} // end for

return location;
}// end find

public void insertAscending(int value){

 int insertLocation;
 // test if the list is full
 
 if (this.isFull())
 System.out.println("Insert failed, list full");

else { //not full
 
  // Added first element to an empty list
  if (currentSize ==0) this.elements[0] = value;
  
  // add new element at end.
  else if(value >= this.elements[currentSize-1])
  	this.elements[currentSize] = value;

// else adding in middle
else{

insertLocation=0;

while(this.elements[insertLocation] < value) 
insertLocation++;


//insert location will contain the position of the first 
//element greater than our new value, so we move over 
// elements past this location to make room for the new 
// value.


for(int i=currentSize-1; i >= insertLocation; i--)
     this.elements[i+1] = this.elements[i];

// add the new value

this.elements[insertLocation] = value;

}// end add in middle

this.currentSize++;
}// end else not full
}// end insert Ascending
}