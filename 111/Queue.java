public class Queue {					//QUEUE FOR INTEGERS

	private int[] elements;
	private int maxSize;
	private int currentSize;
	private int front;
	private int rear;

public Queue(int max) {
	maxSize = max;
 	currentSize = 0;
 	front= 0;
 	rear = 0;
 	elements = new int[maxSize];
}// end constructor

public boolean isFull() {
	return ( currentSize == maxSize);
}
  
public boolean isEmpty() {
	return (currentSize == 0);
}

public int count(){
	return currentSize;
}

public void enqueue( int newValue) {
	if ( this.isFull()) {
   	System.out.println("The queue is full the value can not be added");
   return;
	}
  
  	if (currentSize < maxSize && rear == maxSize) rear = 0;
   	elements[rear] = newValue;
     	++currentSize;
     	++rear;
	}

public int dequeue(){
	int tempValue = -999;
 
 	if (this.isEmpty()) {
  		System.out.println("The queue is empty,there is nothing to remove");
  		return tempValue;
 	}
 
 	tempValue = elements[front];
 
 	++front;
 	--currentSize;
 
 	if (front == maxSize) front=0;
  		return tempValue;
}

}// end queue   