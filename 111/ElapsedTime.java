//**************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                January 15, 2009
//Program Description: This program will prompt the user to 
//							  input the elapsed time for an event in 
//							  seconds, then it will output the time
//							  into hours, minutes, and seconds.
//Question:				  1
//**************************************************************

//import statements
import java.util.*;

public class ElapsedTime
{
	//new scanner
	static Scanner console = new Scanner(System.in);

 	//main method
  	public static void main(String[] args)
  	{
  		//variable declaration
    	int seconds;
    	int sec = 0;
		int min = 0;
		int hr = 0;
    
		//user prompt
  		System.out.println("Please enter elapsed");
  		System.out.print("    time in seconds:  ");
  		seconds = console.nextInt();

	 	//determines the amount of hours
	 	while(seconds >= 3600)
	 	{
	 		hr = hr + 1;
			seconds = seconds - 3600;
	 	}
	
	 	//determines the amount of minutes
	 	while(seconds >= 60)
	 	{
	 		min = min + 1;
			seconds = seconds - 60;
	 	}
	 
	 	//determines the amount of seconds
	 	sec = seconds;

	 	//output
	 	System.out.println(hr + ":" + min + ":" + sec);
   }//end of main
}//end of program