public class Stack {

	private int[] elements;
 	private int top;
 	private int maxSize;
 	private int currentSize;
 
 	public Stack(int max) {
  		top = -1;
 		maxSize = max;
 		currentSize =0;
 		elements = new int[maxSize];
	}

	public boolean isEmpty(){
		return( currentSize == 0);
	}

	public boolean isFull() {
		return (currentSize == maxSize);
	}

	public int count() {
 		return (currentSize);
	}

	public void push(int newValue) {
  		if ( this.isFull()) {
   		System.out.println("The stack is full");
   		return;
  		}
  
  		++top;
  		elements[top] = newValue;
  
  		++currentSize;
	}

	public int pop() {
 		int tempValue = -999;
 
 		if (this.isEmpty()) {
  			System.out.println("The stack is empty");
  			return tempValue;
 		}
 
 		tempValue = elements[top];
 		--top;
 
 		--currentSize;
 
 		return tempValue;
	}
 
	public void printStack()		//might not work 
 	{
		int temp;
		
		Stack b = new Stack(this.count());
		
		while(this.count() != 0)
		{
			temp = this.pop();
			
			System.out.print(temp + " ");
			
			b.push(temp);
		}
	}
} // end stack