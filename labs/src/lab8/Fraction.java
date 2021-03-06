package lab8;

public class Fraction {
	private int numerator;
	private int denomentor;
	
	public Fraction(int _num, int _deno ) {
		numerator = _num;
		denomentor = _deno;
	}
	
	public int getNumerator(){
		return numerator; 
	}
	
	public void setNumerator(int num) {
		numerator = num;
	}
	
	public int getdenomentor(){
		return denomentor; 
	}
	
	public void setdenomentor(int num) {
		if (den != 0) {
			denomentor = num;
		}
	}
	
public String toString() {
		
		return numerator + "/ " + denomentor;
		
	}
public Double toDecimal() {
	return numerator / (double)denomentor;
}

public int toPercent() {
	return (int)(toDecimal() * 100);
}

public Fraction add(Fraction rhs) {
	int newDen = this.denomentor = rhs.denomentor;
	int num1 = this.numerator = rhs.denomentor;
	int num2 = this.numerator = this.denomentor;
	
	return num1 + num2 + newDen;
}

public static Fraction add(Fraction rhs, Fraction lhs) {
	int newDen = lhs.denomentor = rhs.denomentor;
	int num1 = lhs.numerator = rhs.denomentor;
	int num2 = this.numerator = lhs.denomentor;
	
	return num1 + num2 + newDen;
}
	
}
