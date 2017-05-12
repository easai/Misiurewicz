package com.github.easai.math;

//Misiurewicz.java  -- Tests c is a Misiurewicz point where f(z)=z*z+c. 

//Copyright (c) 2013 Erica Asai

//Author: easai 
//Website: easai.web.fc2.com/homepage/javadev/Trig/
//Created: Fri Dec 20 07:02:25 2013
//Keywords: Misiurewicz, pre-periodic, complex numbers

//Commentary:
//
//The Misiurewicz class tests if the point c in the complex plane is
//a Misiurewicz point or not.  The series is pre-periodic if it goes
//periodic but not entirely periodic i.e. takes other values before
//going periodic.
//

//Code:

/**
* The <tt>Misiurewicz</tt> class tests if the point c in the complex plane is a
* Misiurewicz point or not. The series is pre-periodic if it goes periodic but
* not entirely periodic i.e. takes other values before going periodic.
*
* @author easai
*/
public class Misiurewicz {
	/**
	 * Indicates if the point c is periodic, pre-periodic, or not periodic.
	 */
	public enum Periodic {
		/**
		 * Indicates the function f(z) is periodic.
		 */
		PERIODIC,
		/**
		 * Indicates the function f(z) is pre-periodic.
		 */
		PREPERIODIC,
		/**
		 * Indicates the function f(z) is not periodic.
		 */
		NONPERIODIC
	};

	/**
	 * Calculates f(z)=z*z+c.
	 */
	public static Complex f(Complex z) {
		// f=z+i
		// return z.multiply(z).add(new Complex(0,1));
		// f=z-1
		return z.multiply(z).add(new Complex(-1, 0));
	}

	/**
	 * Returns <em>PERIODIC</em>, <em>PREPERIODIC</em>, or <em>NONPERIODIC</em>
	 * if the function f(z)=z*z+c is periodic, pre-periodic, or not periodic.
	 */
	public Periodic isPeriodic() {
		int maxiter = 10;
		Complex[] res = new Complex[maxiter];
		Complex z = new Complex(0, 0);
		System.out.println(z.toString());
		Complex zz;
		int index = 0;
		res[index++] = z;
		Periodic periodic = Periodic.NONPERIODIC;
		boolean found = false;
		do {
			zz = f(z);
			System.out.println(zz.toString());
			z = zz;
			int i = 0;
			while (!res[i].equals(zz) && ++i < index)
				;
			if (i < index) {
				found = true;
				if (i == 0)
					periodic = Periodic.PERIODIC;
				else
					periodic = Periodic.PREPERIODIC;
			}
			res[index++] = z;
		} while (!found && index < maxiter);
		return periodic;
	}

	/**
	 * Tests if the give function f(z)=z*z+c is periodic, pre-periodic, or not
	 * periodic.
	 */
	public void test() {
		switch (isPeriodic()) {
		case PERIODIC:
			System.out
					.println("f is periodic. The point c: f=z+c is NOT a Misiurewicz point.");
			break;
		case NONPERIODIC:
			System.out
					.println("f is not periodic. The point c: f=z+c is NOT a Misiurewicz point.");
			break;
		case PREPERIODIC:
			System.out
					.println("f is pre-periodic but not periodic.  The point c: f=z+c is a Misiurewicz point.");
			break;
		}
	}

	/**
	 * Tests if the give function is a Misiurewicz point or not.
	 *
	 * If successfully compiled and executed, the program should print out the
	 * following. 0.0 + 0.0*I -1.0 + 0.0*I 0.0 + 0.0*I f is periodic. The point
	 * c: f=z+c is NOT a Misiurewicz point.
	 */
	public static void main(String args[]) {
		Misiurewicz m = new Misiurewicz();
		m.test();
		try
		{
		System.in.read();
		}
		catch(Exception e){}
}
}

//Misiurewicz.java ends here