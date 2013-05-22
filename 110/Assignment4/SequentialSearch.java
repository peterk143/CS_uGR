//***********************************************************
//Programmer:			  Peter Kirkpatrick
//Date:					  November 28,	2008
//Program Description: This program	uses sequential search
//							  that can be used to search a string
//							  Vector object, and tests that program.
//Question:				  Ch 10, Ex 8, Pg 692
//***********************************************************

import java.util.*;

public class SequentialSearch
{
	static Scanner console = new Scanner(System.in);

	public static void main(String[] args)
	{
		Vector<String> stringList = new Vector<String>();
		
		stringList.addElement("Billy Bob");
		stringList.addElement("Jimmy John");
		stringList.addElement("1234567890");
		stringList.addElement("Peter Piper");
		stringList.addElement("  1032  ");
		
		