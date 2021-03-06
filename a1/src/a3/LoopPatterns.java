package a3;

import java.util.Scanner;

/**
 * A collection of methods for the tirdassignment of CS 1410. An assortment of 
 * methods that does multiple function and has different purposes.
 * 
 * @author Henry Doan
 */
public class LoopPatterns {
	
	public static void main(String[] args) { 
//		System.out.println(findSmallestPositiveNumber("1 7 5"));	 
//		System.out.println(isPalindrome("adsf"));
//		System.out.println(moreEvenThanOdd("2 4 6 9 7 1 3"));
//		System.out.println(camelCase("hi i like ice cream"));
//		System.out.println(lowestAlphabetically("bee cherry zoo apple pear"));
//		System.out.println(timesTable(3,4));

	}

	/*
	* This method takes in a string parameter of the input sentence with a list of numbers in a string
	* and have a scanner go through and do some logic to see if it is the smallest positive integer.
	* the variable small is the next integer in the scanner scan. The logic of the while loop ask if the 
	* scanner has the next scan be an integer, than have another variable a int type num of the next scanner 
	* number and if it is smaller and a positive number, re assign the small variable into the new number. 
	* Finally we will close the scanner and return the smallest number our of the string. 
	* 
	* @params sentence  a string with a list of numbers being compared
	*  return        the smallest value of the sentence
	*/
	public static int findSmallestPositiveNumber(String sentence) {
		Scanner s = new Scanner(sentence);
		int small = s.nextInt();
		while (s.hasNextInt()) {
			int num = s.nextInt();
			if (num < small && num > 0) {
				small = num;
			}
		}
		s.close();
		return small;
	}

	
	/*
	* This method is a boolean method that returns true or false of the condition. The parameter is a string 
	* type of a word. the first variable is a boolean called test, which tests whether the word is equal to 
	* the copy of the word in reverse in a string. Then returns the value of if it is a palindrome.
	* 
	* @params word  a string 
	*  return        the boolean value of true or false of the reversed copy of the original word compared to
	*                the original.
	*/
	public static boolean isPalindrome(String word) {
		boolean test = word.equals(new StringBuilder(word).reverse().toString());
	    return test;
	}
	
	/*
	* This method is another boolean method taking in a parameter of a sentence string full of numbers being 
	* compared. The variable of the boolean final num is the answer of whether or not there are more evens than
	* odds integers. The scanner looks at the numbers in the string individually and does the logic. A counter is
	* set for both odd and even numbers, both starting off at 0. The logic of the while loop checking to see if it
	* has a next integer or else it stop, is that the variable integer of num is the next integer in the scanner and
	* if it is even with the division of two with the remainder of 0 than have the counter go up by one. But if
	* the number with the division of two with the remainder of 1 than it is an odd number and the odds go up
	* by one. At the end of the while logic, The comparison of the final counter of both odds and evens are then
	* has a boolean value of if there are more evens than odds.
	* 
	* @params sentence  a string with a list of numbers being compared
	*  return        the boolean value if there are more evens numbers than odds.
	*/
	public static boolean moreEvenThanOdd(String sentence) {
		boolean finalNum;
	    Scanner s = new Scanner(sentence);
	    int oddNumbers = 0;
	    int evenNumbers = 0;
	    
	    while (s.hasNextInt()) {
	    	int num = s.nextInt();
		    
	    	if (num % 2 == 0) {
	    		evenNumbers++;
	 		};
	    	if (num % 2 == 1){ 
		        oddNumbers++;
		    } ;  		
		    
	    }
	    if (evenNumbers > oddNumbers) {
    		finalNum = true;
	    } else {
	    	finalNum = false;
	    };
	    s.close();
	    return finalNum;
	}

	/*
	* This method takes in the parameter of a string of a sentence and have a string builder of new string 
	* and builds a string copy with the original length. The For loop makes a variable word of when the sentence
	* is split by a space. if the word is not empty, the append the new string on the first character of each token
	* and the lower case the first character and if it is not the new string length is not equal to the original string 
	* length then take away the spaces with the variables and if loop. 
	* 
	* @params sentence a combo of words
	*  return        the camel casing of the sentence.
	*/
	public static String camelCase(String sentence){
		StringBuilder newString = new StringBuilder(sentence.length());
	    for (String word : sentence.split(" ")) {
	        if (!word.isEmpty()) {
	        	newString.append(word.substring(0, 1).toUpperCase());
	        	newString.append(word.substring(1).toLowerCase());
	        }
	        if (!(newString.length() == sentence.length())){
	        	newString.append(" ");
	            }
	       
	    }
	    
	    String finalWord = newString.toString();
	    String output = finalWord.replaceAll("\\s", "");
	    int outputLength = output.length();
	    String first = output.substring(0, 1).toLowerCase();
	    String finalOutput = first + output.substring(1, outputLength );
	    return finalOutput;
	}
	
	/*
	* This method takes in the parameter of a string of a sentence and have a scanner scan through the tokens
	* and set the next token be a variable of comes first. The while loop takes the next line and sets another 
	* variable of the next number and then compares the two value with the compare to element and if the number
	* is greater than the other that it comes before and then loops until it has a final result of the word that 
	* has the character with the highest before value. 
	* 
	* @params sentence a combo of words 
	*  return        the word that alphabetically comes first in the sentence.
	*/
	public static String lowestAlphabetically(String sentence) {
		Scanner s = new Scanner(sentence);
		String comesFirst = s.next();
		while(s.hasNextLine()) {
			String nextWord = s.next();
			if ( comesFirst.compareTo(nextWord) > 0) {
				comesFirst = nextWord;
			}
		}
		s.close();
		return comesFirst;
	}
	
	/*
	* This method takes in the parameter of a height and a width that does math as a times table. 
	* The string padding makes for the spacing and foundation of the table and the counters depends on how 
	* big and wide the top numbers and borders are. The while loop reiterates the foundation plus some spaces
	* plus the counter value and increments it at one until the width is met. The foundation then added a new
	* line and spacing to some good borders and separation. Then makes the top border from the increment value
	* of the height with the border design used. Then added a next then with the for loop making the height
	* be on the side with some borders and the using another method, call spacing which takes in an integer
	* value and compares it with a set number and returns the variable to do some math with it to get the middle
	* section with some space in the while loop incrementing the calc counter to loop all the way.
	* 
	* @params width  integer of the wideness
	* @params height integer of the height
	* @intergerValue  number value
	*  return        table of math of the width times the height.
	*/
	public static String spacingMath(int integerValue) {
		String space = new String();
		if (integerValue <= 10) {
			space = "  " + integerValue;
		} else if ( integerValue <= 100) {
			space = "  " + integerValue;
		} else {
			space = "" + integerValue;
		}
		return space;
	}
	
	public static String timesTable(int width , int height) {
		String padding = "     ";
		int topNumberCounter = 1;
		int topBorderCounter = 1;
		
		while (topNumberCounter <= width){
			padding = padding + "  " + topNumberCounter;
			topNumberCounter++;
		}
		padding = padding + "\n";
		padding = padding + "  ";
		while (topBorderCounter <= height){
			padding = padding + ("---");
			topBorderCounter++;
		}
		padding = padding + "\n";
		
		for (int sideNum = 1; sideNum <= height; sideNum++) {
			padding = padding + (spacingMath(sideNum) + "| ");
			int calc = 1;
			while(calc <= width) {
				padding = padding + (spacingMath(sideNum * calc) + "");
				calc++;
			}
			padding = padding + " \n";
		}
		return padding;
	}

}
