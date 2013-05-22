//adds the numbers between start and end inclusively 
//DOES NOT WORK!

public class InclusiveRecurse
{
	public static void main(String[] args)
	{
		int start = 4;
		int end = 6;
		
		System.out.println(add(start, end));
	}
	
	public static int add(int start, int end)
	{
		if(start == end)
		{
			return start + end;
		}
		
		while(start < end){
			System.out.println("print");
				
			return start + add((start + 1), end);
		}
		
		return start + add((start + 1), end);
	}	
}