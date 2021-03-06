package lab04;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class VerifyFileStructure {

	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser("/Users/Henry/Documents/workspace/CS1410/src/lab04");
		chooser.setDialogTitle("Which file would you like to verify?");
		
		int result;
		result = chooser.showOpenDialog(null);
		
		if (result == JFileChooser.CANCEL_OPTION) {
			return;
		}
		
		File inputFile;
		inputFile = chooser.getSelectedFile();
		System.out.println("You chose: " + inputFile);

		// create a scanner, read the file, print out the words, and close the scanner
		
		try {
			Scanner in = new Scanner(inputFile);
			
			while (in.hasNext()) {
				String word = in.next();
				if (isOpeningTag(word)) {
					String name = word.substring(1); // extract the tag name
					findClosingTag(in, name); // use the helper method to find the closing tag
				}
				
			}
			
			System.out.println("File verified ok.");
			
			in.close();
		
		} catch (IOException e) {
			System.out.println("Could not read the file: " + inputFile);
		}
	}
	
	/**
	 * Returns true if the parameter string represents an opening tag,
	 * such as "<name", or false otherwise.
	 * 
	 * @param s Any string
	 * @return true if the string is an opening tag.
	 */
	public static boolean isOpeningTag (String s) {
		if (s.length() >= 2 && s.startsWith("<") && s.charAt(1) != '/')
			return true;
		else 
			return false;
	}
	
	/**
	 * Returns true if the parameter string represents an closing tag,
	 * such as "</name", or false otherwise.
	 * 
	 * @param s Any string
	 * @return true if the string is an opening tag.
	 */
	public static boolean isClosingTag (String s) {
		if (s.length() >= 2 && s.startsWith("</") && s.charAt(1) == '/')
			return true;
		else 
			return false;
	}
	
	/**
	 * 
	 * 
	 */
	public static void findClosingTag (Scanner s, String openName) {
		// Loop as long as there are words in the file.
		
		while (s.hasNext()) {
			// get the next word
			
			String word = s.next();
			
			if (isOpeningTag(word)) {
				String name = word.substring(1); // extract the tag name
				findClosingTag(s, name); // use the helper method to find the closing tag
			}
			
			// if it is an opening tag, check it further.
			
			if (isClosingTag(word)) {
				// extract the name from the tag.
				
				String closeName = word.substring(2);
				
				// Make sure the closing tag name matched the opening tag name.
				
				if (closeName.equals(openName)) 
					return; // we're done looking for a closing tag, success.
				else {
					System.out.println("Closing tag " + closeName + " does not match opening tag " + openName + ".");
					
					System.exit(0);  // Rudely exits the app 
				}
			}
			
			// end of loop, go back and read another word
		}
		
		// if we get here , there was nothing else to scan in the file.
		
		System.out.println("Could not find closing tag for tag " + openName + ".");
		System.exit(0);
	}

}
