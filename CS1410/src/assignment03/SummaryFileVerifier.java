package assignment03;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class SummaryFileVerifier {

	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser("/Users/Henry/Documents/workspace/CS1410/src/assignment03");
		chooser.setDialogTitle("Which file would you like to verify?");
		
		int result;
		result = chooser.showOpenDialog(null);
		
		if (result == JFileChooser.CANCEL_OPTION) {
			return;
		}
		
		File inputFile;
		inputFile = chooser.getSelectedFile();
		System.out.println("You chose: " + inputFile);
		try {
			Scanner in = new Scanner(inputFile);
			
			while (in.hasNextLine()) {
				String line = in.nextLine().trim();
				System.out.println(line);
				if (isSummary(line)) {
//					String name = word.substring(0); // extract the tag name
					System.out.println("this is the summary");
					moneyValue(in, line); // use the helper method to find the closing tag
				}
				
				if (isBuy(line)) {
					System.out.println("this is the buy");
				}
				
				if (isSell(line)) {
					System.out.println("this is the sell");
				}
				
			}
			
			System.out.println("File verified ok.");
			
			in.close();
		
		} catch (IOException e) {
			System.out.println("Could not read the file: " + inputFile);
		}
	}
	
	public static boolean isSummary (String s) {
		if (s.length() >= 2 && s.startsWith("SUM") && s.charAt(0) != '$')
			return true;
		else 
			return false;
	}
	
	public static boolean isBuy (String s) {
		if (s.length() >= 3 && s.startsWith("BUY") && s.charAt(0) != '$')
			return true;
		else 
			return false;
	}
	
	public static boolean isSell (String s) {
		if (s.length() >= 2 && s.startsWith("SELL") && s.charAt(0) != '$')
			return true;
		else 
			return false;
	}
	
	public static boolean moneySign (String s) {
		if (s.length() >= 2 && s.startsWith("$") && s.charAt(2) != '/')
			return true;
		else 
			return false;
	}

	public static void moneyValue (Scanner s, String openName) {
		// Loop as long as there are words in the file.
		
		while (s.hasNext()) {
			// get the next word
			
			String word = s.next();
			
//			
			if (moneySign(word)) {
				word = word.substring(1);
				double moneyTrans = Double.parseDouble(word);
				System.out.println(moneyTrans);
//				findClosingTag(s, name); // use the helper method to find the closing tag
			}
//			
//			// if it is an opening tag, check it further.
//			
//			if (isClosingTag(word)) {
//				// extract the name from the tag.
//				
//				String closeName = word.substring(2);
//				
//				// Make sure the closing tag name matched the opening tag name.
//				
//				if (closeName.equals(openName)) 
//					return; // we're done looking for a closing tag, success.
//				else {
//					System.out.println("Closing tag " + closeName + " does not match opening tag " + openName + ".");
//					
//					System.exit(0);  // Rudely exits the app 
//				}
//			}
//			
//			// end of loop, go back and read another word
		}
//		
//		// if we get here , there was nothing else to scan in the file.
//		
//		System.out.println("Could not find closing tag for tag " + openName + ".");
//		System.exit(0);
	}


}
