// Henry Doan Driving Cost Calculator CS 1410-001

package a1;

import javax.swing.JOptionPane;

public class DrivingCostCalculator {
	public static void welcomeMsg() {
		// Welcome message
		JOptionPane.showMessageDialog(null, "-------------------------------\n" + "Welcome to the Driving Cost Calulator\n" + "-------------------------------");
	}
	
	public static void displayBanner() {
		// Result message
		System.out.println("-------------------------------\n" + "Driving Cost Calulator Result\n" + "-------------------------------");
	}
	 public static int increment(int i) {
		 i = i + 1;
		 return i;
	 }
	
	public static void main(String[] args) {
		int x = 5;
		increment(x);
        System.out.println(x);
        
		welcomeMsg();
		
		// Get the Driving distances and set it to a variable.
		String drivingDistanceMsg = JOptionPane.showInputDialog("What is the driving distance in miles?");
		double drivingDistance;
		drivingDistance = Double.parseDouble(drivingDistanceMsg);

		// Get the Vehicles miles per gallon and set it to a variable.
		String vehicleMilesMsg = JOptionPane.showInputDialog("What is your vehicle's miles per gallon?");
		double vehicleMiles;
		vehicleMiles = Double.parseDouble(vehicleMilesMsg);

		// Get the Gas Price and set it to a variable.
		String gasPriceMsg = JOptionPane.showInputDialog("What is your gas price in dollars?");
		double gasPrice ;
		gasPrice = Double.parseDouble(gasPriceMsg);

//		double moneyTotal = drivingDistance * gasPrice / vehicleMiles;
		
		// Math for gallon and for cost
		double gallon = drivingDistance / vehicleMiles;
		double cost = gallon * gasPrice;
		
		// Print out cost message
		displayBanner();
		System.out.println("Your total is: $" + cost + " for your travel cost.");
	}
}
