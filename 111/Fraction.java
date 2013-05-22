//***********************************************************
//Programmer:          Peter Kirkpatrick
//Date:                February 5, 2009
//Program Description: Fracion Class
//***********************************************************

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
	    numerator = num;
	    denominator = denom;

	}// end constructor

    public int getNumerator() {
	return this.numerator;
    }// end getNumerator

    public int getDenominator() {
	return this.denominator;
    }
    public void print() {

	System.out.println( "print1 " + this.numerator + " / " + this.denominator);

	// inside the body of a method, you CAN call another method
	// in the class

	System.out.println( "print2 " + this.getNumerator() + " / " + getDenominator() );
    }// end print

    public double convertToDecimal() {

	//Preconditions:  Denominator != 0
	//Postconditions:  double value returned = numerator divided by denominator

	if ( denominator == 0) {
	    System.out.println("ERROR, denominator can not be zero");
	    return(0.0000001);}
	else return( (double)numerator / (double)denominator) ;
    }// end convert

    // ADD GOES HERE
    public Fraction add(Fraction B) {

	Fraction result;

	int num1, num2;
	int denom1, denom2;
	int resultnum=0, resultdenom=0;

	num1 = this.numerator;
	denom1 = this.denominator;

	num2 = B.numerator;
	denom2 = B.denominator;

	if ( denom1 == denom2){
	    resultnum = num1 + num2;
	    resultdenom = denom1;
	}
	else {
	    int commondenom = denom1 * denom2;
	    num1 = num1 * denom2;
	    num2 = num2 * denom1;
	    denom1 = commondenom;
	    denom2 = commondenom;

	    resultnum = num1 + num2;
	    resultdenom = commondenom;

	}// end else
	return result = new Fraction ( resultnum, resultdenom);
    }// end of add


    public void setNumerator(int num) {
	this.numerator = num;
    }// end setNumerator

    public void setDenominator(int denom) {
	this.denominator = denom;
    }

    // reduce goes here
    public void reduce()
    {
	int num = this.numerator;
	int denom = this.denominator;
	char c;
	
	if(this.numerator < 0)
	{
		c = '-';
		num = Math.abs(num);
	}//end if
	
	if( num >= denom)
	    System.out.println("Not today");
	else
       	{
	    for(int i = num; i > 1; i--)
		{
		    if(num % i == 0 && denom % i == 0)
			{
			    num /= i;
			    denom /= i;
			    i = num + 1;
			}//end if

		}//end for loop
		
		if(this.numerator < 0)
		{
	  	  	this.numerator = -num;
	   	this.denominator = denom;
		}
		
			else
			{
				this.numerator = num;
	   		this.denominator = denom;
			}
	}//end else

	
    }//end reduce
	 
	 public void multiply(Fraction frac)
	 {
	 	int num1, num2;
		int den1, den2;

		
		num1 = this.getNumerator();
		den1 = this.getDenominator();
		
		num2 = frac.getNumerator();
		den2 = frac.getDenominator();
		
		num1 = num1 * num2;
		den1 = den1 * den2;
		
		this.numerator = num1;
		this.denominator = den1;
		
		System.out.println( "multiply " + this.getNumerator() + " / " + this.getDenominator() );
	}// end multiply

	 public void divide(Fraction frac)
	 {
	 	int num1, num2;
		int den1, den2;

		
		num1 = this.getNumerator();
		den1 = this.getDenominator();
		
		num2 = frac.getNumerator();
		den2 = frac.getDenominator();
		
		num1 = num1 * den2;
		den1 = num2 * den1;
		
		this.numerator = num1;
		this.denominator = den1;
		
		System.out.println( "divide " + this.getNumerator() + " / " + this.getDenominator() );
	}// end multiply

		
		
}// end fraction