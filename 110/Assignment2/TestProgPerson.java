//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                October 30, 2008
//Program Description: This program tests the Person Class.
//Question:				  Ch 8, Ex 4b, Pg 545
//***********************************************************

public class TestProgPerson
{
	public static void main(String[ ]args)
	{
		//instance variables
		Person name = new Person();
		
		Person dude = new Person("Mike","W", "Bush");
		
		Person peeps1 = new Person("J.", "W.", "Wash");
		
		Person peeps2 = new Person("J.", "W.", "Wash");
		
		String Names = "J." + " W." + " Wash";
			
		boolean equality;
		
		//determines whether peeps1 and Names are the same
		/*if(peeps1.equals(Names))
			System.out.println("True"); 
		
		else		
			System.out.println("False"); 
		*/
		
		equality = peeps1.equals(Names);
		System.out.println(equality);
		
		//sets name to Frank Mayor
		name.setName("Frank", "Mayor");
		
		//sets dude to Joe Jimmy John
		dude.setName("Joe", "Jimmy", "John");
		
		//outputs
		System.out.println(name);
		System.out.println(dude);
		}
}



// outputs
/*
False
Frank Mayor 
Joe John Jimmy
*/