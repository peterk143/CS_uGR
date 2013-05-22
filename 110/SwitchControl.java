//******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                October 10, 2008
//Program Description: This program uses switch statements, and then
//                     tests them with different values.
//******************************************************************

import java.util.*;

public class SwitchControl
{
 static Scanner console = new Scanner(System.in);
 
 public static void main(String[ ] args)
 {
   int x;
   
   System.out.println();
   System.out.println("Model 100 comes with remote control, timer,");
   System.out.println("     and stereo sound and costs $1000.");
   
   System.out.println("Model 200 come with all features of model 100,");
   System.out.println("     plus picture-in-picture; it costs  $1200.");
   
   System.out.println("Model 300 comes with all features of model 200,");
   System.out.println("     plus HDTV, flat screen, and 16 x 9 aspect,");
   System.out.println("     ratio; it costs $2400.");
   
   System.out.println();
   System.out.print("Please enter the model number chosen: ");
   x = console.nextInt();
   
   switch(x)
   {
     case 100:
       System.out.println("Model 100 comes with remote control, timer,");
       System.out.println("     and stereo sound and costs $1000.");
       break;
     case 200:
       System.out.println("Model 200 come with all features of model 100,");
       System.out.println("     plus picture-in-picture; it costs  $1200.");
       break;
     case 300:
       System.out.println("Model 300 comes with all features of model 200,");
       System.out.println("     plus HDTV, flat screen, and 16 x 9 aspect,");
       System.out.println("     ratio; it costs $2400.");
       break;
     default:
       System.out.println("Invalid Entry.");
   }
 }
}