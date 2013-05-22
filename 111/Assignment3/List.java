public class List{

// Description:  This class implements a list ADT, which can
// be used to store unordered series of integers. This list is based on the
// List ADT described in your text.

// Data members:
  private int currentSize;
  private int maxSize;
  private int[] elements;

public List(int maxElements) {
maxSize = maxElements;
elements = new int[maxSize];
}

public boolean isFull() {
return (currentSize == maxSize);
}

public boolean isEmpty() {
return (currentSize == 0);
}

public int count() {
return (currentSize);
}


public void insert( int newValue, int position) {
// if position is <=1 or > the current # of elements + 1
// print an error

if (position < 1 || position > currentSize +1) 
System.out.println(" Insert cancelled, Invalid position given");
else {
if (this.isFull()) System.out.println("Insert Cancelled, " +
"List is full.");
else {

// adding first element
if (currentSize == 0) this.elements[0] = newValue;
else { // adding at end
if (position == currentSize + 1)
this.elements[position-1] = newValue;
else { 
// shift elements to the left to make room for newValue.
for( int i= currentSize-1; i >= position-1; i--) 
this.elements[i+1] = this.elements[i];

this.elements[position-1]= newValue;
} // adding in middle
}// else adding at end

currentSize++;
}
}
} // end insert


public int retrieve(int position) {
return (this.elements[position-1]);
} // end of retrieve

public int find(int value) {

int location= -999;

for (int i=0;  i <= this.currentSize-1; i++) {
if (this.elements[i] == value) {
location = i+1;
break;
}
} // end for

return location;
}// end find



public int delete(int position) {

int tempValue;

if ( this.isEmpty() || position > currentSize || position < 1 )
System.out.println("This delete can not be performed "
+ "an element at position " + position 
+ " does not exist " );

tempValue = this.elements[position-1];

for (int i=position-1; i< currentSize-1; i++) 
this.elements[i] = this.elements[i+1];

this.elements[currentSize-1] = 0;
currentSize--;

return tempValue;
} // end delete

} // end of class
