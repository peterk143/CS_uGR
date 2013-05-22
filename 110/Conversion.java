//******************************************************************
//Programmer:          Peter Kirkpatrick
//Date:                September 10, 2008
//Program Description: This program converts 93 degrees F into its
//                     equivalent centigrade temperature.
//******************************************************************

public class Conversion
{
	public static void main (String[ ] args)
	{
		int num1;
		double centigrade;
		num1 = 93;
		
		centigrade = (num1 - 32) * (0.555555556);
		System.out.println("centigrade = " + centigrade);
	}
}