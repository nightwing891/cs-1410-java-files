package a7;

/**
 * This class initializes the variables and does simple calculations on them and have them display the wages
 * with the raise percentage for how ever many the years. This class will use the other comparison class and
 * takes the users input and give the right results based on the inputs.
 * 
 * @author Henry Doan
 *
 */

public class LifetimeEarnings {
	/*
	 * Private initializers of the double starterSalary and the double raisedPercentage as well as the integer
	 * of the current year.
	 */
	
	private double starterSalary;
	private double raisedPercentage;
	private int currentYear;
	
	
	/*
	 * This method is the setter for the variables above and set them into the values. The Starter salary
	 * is set to the parameter and the same goes with raised percentage. The current year is default to 0.
	 * 
	 * @params double _starterSalary,   is the starting salary of the first job
	 * @params double _raise ,          is the raise percent of each year
	 */
	
	public LifetimeEarnings(double _starterSalary, double _raise){
		starterSalary = _starterSalary;
		raisedPercentage = _raise;
		currentYear = 0;
	}
	
	/*
	 * This method use the currentSalary and has a variable of a double type of the final salary and set it equal
	 * to the starter Salary time the power of the raisedPercentage and take the decimal form of that and have it
	 * with the current year. There is a if statement at if the final salary is 1 then return the final salary
	 * to the starter salary or else return the final salary.
	 * 
	 * @return finalSalary as the starterSalary if the final salary is equal to 1
	 * @return the finalSalary with the math all calculated
	 */
	
	public double currentSalary() {
		double finalSalary = starterSalary * Math.pow((1.0 + raisedPercentage / 100.0), currentYear);
		if (finalSalary == 1.0) {
			return finalSalary = starterSalary;
		}
		return finalSalary;
	}
	
	/*
	 * This method is a void method that set the current year and now assign it to the years of earnings 
	 * 
	 * @params int yearsOfEarning, the integer input by the user for the year of earnings 
	 */
	
	public void setYear(int yearsOfEarning){
		currentYear =  yearsOfEarning;
	}
	
	/*
	 * This void method increment the current year by one.
	 * 
	 */
	
	public void incrementYear(){
		currentYear++;
	}
	
	/*
	 * This method is takes in the years of earnings as an integer param and does the logic of if the years of 
	 * earning is less than 0, such as a negative number, than set the year to 0. Then we make a double array
	 * variable called arr and make a new double array with all the years of earning. Then a for loop to iterate
	 * through the array as long as the array length and have the array index be the current salary as each year
	 * increments. Then return arr with the new values.
	 * 
	 * @params int yearsOfEarning, the input for the year of earnings 
	 * @return arr,                a double type array with the index values being the new calculated salary with how many year, for the index.
	 */
	
	public double[] computeLifetimeEarnings(int yearsOfEarning){
		
		if(yearsOfEarning < 0) {
			 yearsOfEarning = 0;
		}
		
		double[] arr = new double[yearsOfEarning];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] += currentSalary();
			incrementYear();
		}
		return arr;
	}
	
	/*
	 * This method is a String method and basically turns the final results into a more presentable type of
	 * a string and we have each return items from the method above and present them in a final result. 
	 * The income variable is a string with the quotes and the starterSalary. Same goes for the risePercent 
	 * and yearly variable. Finally with all the variables, the Results variables puts them all together in a nice
	 * understanding message.
	 * 
	 * @return results, which is the string with all of the variables in a presentable sentence. 
	 */
	
	public String toString() {
		String income = "" + starterSalary;
		String risePercent = "" + raisedPercentage;
		String Yearly = "" + currentYear;
		String results = "$" + income + "x" + risePercent + "%" + "for every" + Yearly + "years";
		
		return results;
	}
}
