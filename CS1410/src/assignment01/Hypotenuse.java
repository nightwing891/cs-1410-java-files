package assignment01;

import java.util.Scanner;

/**
 * This class solves the pythagorean theorem with two given sides with the user input and solves the hypotenuse.
 *
 * @author  Henry Doan
 * @version January 17, 2017
 */

public class Hypotenuse {

	/**
	 * Main method to run all the other methods in order.
	 */
	
	public static void main(String[] args) {
		welcome();
		calculation();
	}
	
	/**
	 * welcome method shows a welcome text in a string and a line separation.
	 */
	
	public static void welcome() {
		System.out.println("Hello! Welcome to the Hypotenuse,\nwhere this program will calculate the Hypotenuse with any given two sides!");
		System.out.println("----------------------------------------------------------------------------");
	}
	
	/**
	 * Calculation method where the program gets the user input and used a scanner to do so and initialize the scanner as a integer variable for 
	 * shorter code. then use math library and logic to get the end result.
	 */ 
	
	public static void calculation() {
		// message prompt to get the first user input.
		System.out.println("Enter the first side for the program to be calculated: ");
		
		// initializing a new scanner with the user input to be a int, scanning the next input in the console for the integer for the one of the sides all in one line.
		int userFirstSide = new Scanner(System.in).nextInt();
		
		// message prompt to get the second user input.
		System.out.println("Enter the second side for the program to be calculated: ");
		
		// initializing a new scanner with the user input to be a int, scanning the next input in the console for the integer for the other side all in one line.
		int userSecondSide = new Scanner(System.in).nextInt();
		
		// square roots the first and second side with math pow and what power I want to use, in this case 2 for being squared. Then set it to a variable as a double
		double userFirstSideSquared = Math.pow(userFirstSide, 2);
		double userSecondSideSquared = Math.pow(userSecondSide, 2);
		
		// added both of the side after being squared
		double userFirstSideSquaredPlusUserSecondSideSquared = userFirstSideSquared + userSecondSideSquared;
		
		// to the hypotenuse you will have to square root the result of the other two sides
		double hypotenuse = Math.sqrt(userFirstSideSquaredPlusUserSecondSideSquared);
		
		// messages for the thought process
		System.out.println("You entered the first side to be: " + userFirstSide);
		System.out.println("and the second side to be: " + userSecondSide);
		
		System.out.println(userFirstSide + " squared is: " + userFirstSideSquared );
		System.out.println(userSecondSide + " squared is: " + userSecondSideSquared);
		
		// answer
		System.out.println("Which has a hypotenuse of: " + hypotenuse);
	}
}
