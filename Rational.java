//package Project8;

	/*
	Defining a Rational number class

	Refer to the instructions on Canvas for more information.

	"I have neither given nor received help on this assignment."
	author: Sanaz Shaik
	*/

	public class Rational {
		
		/*
		  These are the instances variables defined for your class.  Don't change these lines!
		*/
		private int numerator;
		private int denominator;
		
		/*
		  Initialize a new Rational object with value iNum/iDen stored in the numerator and
		  denominator variables.  Calls the reduce() method to put the fraction in lowest terms.
		*/
		public Rational(int iNum, int iDen) {
			this.numerator = iNum;
			this.denominator = iDen;		
			this.reduce();
		} //Rational (constructor)
		
		public int getNumerator() {
			// Replace this return statement with the appropriate instruction		
			return this.numerator;
		} //getNumerator
		
		public void setNumerator(int n) {
			// Fill in the details for this method, and don't forget to call reduce!
			this.numerator = n;
			this.reduce();
		} //setNumerator
		
		public int getDenominator() {
			// Replace this return statement with the appropriate instruction		
			return this.denominator;
		} //getDenominator	
		
		public void setDenominator(int d) {
			// Fill in the details for this method, and don't forget to call reduce!
			this.denominator = d;
			this.reduce();
		} //setNumerator
		
		/*
		  There is no framework set up for the setDenominator() method -- this is up to you to fill in
		*/
		
		
		public boolean isValid() {
			// Instead of always returning true, this method should return false under the right conditions
			if (this.denominator == 0) {
				return false;
			}else {
				return true;
			}
		} //isValid
		
		public void add(Rational num2) {
			// Finish this implementation
			int newNum = this.numerator * num2.getDenominator() + num2.getNumerator() * this.denominator;
			int newDen = this.denominator * num2.getDenominator();
			this.numerator = newNum;
			this.denominator = newDen;
			this.reduce();
		} //add
		
		public void sub(Rational num2) {
			// Finish this implementation
			int newNum = this.numerator * num2.getDenominator() - num2.getNumerator() * this.denominator;
			int newDen = this.denominator * num2.getDenominator();
			this.numerator = newNum; 
			this.denominator = newDen;
			this.reduce();
		} //sub
		
		/*
		  There is no framework set up for the mult() and div() methods -- those are up to you to fill in
		*/
		public void mult(Rational num2) {
			// Finish this implementation
			int newNum = this.numerator * num2.getNumerator();
			int newDen = this.denominator * num2.getDenominator();
			this.numerator = newNum;
			this.denominator = newDen;
			this.reduce();
		}	
		public void div(Rational num2) {
			// Finish this implementation
			int newNum = this.numerator * num2.getDenominator(); 
			int newDen = this.denominator * num2.getNumerator();
			this.numerator = newNum;
			this.denominator = newDen;
			this.reduce();
		}
		
		/*******************************
		*    HELPER FUNCTIONS BELOW    *
		*******************************/
		
		/*
		  Reduces the Rational to lowest terms
	        - Checks if both the numerator and denominator are negative; if so, makes both positive
	        - Calls gcf() to find the greatest common factor between the numerator and denominator, and
	          continues to divide by that gcf until the greatest common factor is 1
		*/
		private void reduce() {
			if ((this.numerator < 0) && (this.denominator < 0)) {
				this.numerator = -this.numerator;
				this.denominator = -this.denominator;
			} //if
			
			int common = 0;
			while (common != 1) {
				common = this.gcf();
				this.numerator /= common;
				this.denominator /= common;
			} //while
			
		} //reduce
		
		/*
	      Determines the greatest common factor between the numerator and denominator
	        - Starts checking numbers counting downward from the smaller of the numerator,denominator pair
	        - When it finds a number divisble by both, it breaks the loop and returns that number
	        - The smallest number that can be returned is 1
		*/	
		private int gcf() {
			int commonFactor = 1;
			for (int i = Math.min(Math.abs(this.numerator), Math.abs(this.denominator)); i > 1; i--) {
				if ((this.numerator % i == 0) && (this.denominator % i == 0)) {
					commonFactor = i;
					break;
				} //if
			} //for
			return commonFactor;
		} //gcf
		
		/*
		  Returns a string representation of the Rational, e.g. "1/8"
		*/
		public String toString() {
			return Integer.toString(this.numerator) + "/" + Integer.toString(this.denominator);
		} //toString
		
		/*
		  Determines if two Rationals are exactly equal to each other (same numerator and same 
		  denominator, no consideration of reducing the numbers)
		*/
		public boolean equals(Object other) {
			Rational fraction = (Rational) other;
			if ((this.numerator == fraction.getNumerator()) && this.denominator == fraction.getDenominator()) {
				return true;
			} //if
			return false;
		} //equals
		
		
		/*******************************
		*     END HELPER FUNCTIONS     *
		*******************************/	
		
	} //Rational (class)
