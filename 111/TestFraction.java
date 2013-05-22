public class TestFraction{


    public static void main(String[] args) {

	Fraction fractionA = new Fraction(1, 2);
	Fraction fractionB = new Fraction(-6, 30);


	//	System.out.println("Fraction a is " );
	//fractionA.print();


	System.out.println("Fraction b is " );
	fractionB.print();

	//Fraction result = fractionA.add(fractionB);

	//	System.out.println("The result is " );
	//result.print();

	//fractionB.reduce();
	//fractionB.print();
	//fractionA.multiply(fractionB);
	fractionA.divide(fractionB);

    }// end main
}// end class