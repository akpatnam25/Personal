package computations;

/**
 * This class represents simple arithmetic computations that are utilized in the calculators.
 * @author Aravind
 *
 */
public class Arithimetic {
	
	/**
	 * adds 2 numbers
	 * @param num1 1st number to be added
	 * @param num2 2nd number to be added
	 * @return the sum of the 2 numbers
	 */
	public double add(double num1 , double num2) {
		return num1 + num2;
	}
	
	/**
	 * subtracts 2 numbers
	 * @param num1 1st number to be subtracted
	 * @param num2 2nd number to be subtracted
	 * @return the difference of the 2 numbers
	 */
	public double subtract(double num1 , double num2) {
		return num1 - num2;
	}
	
	/**
	 * multiplies 2 numbers
	 * @param num1 1st number to be multiplied
	 * @param num2 2nd number to be multiplied
	 * @return the product of the 2 numbers
	 */
	public double multiply(double num1 , double num2) {
		return num1 * num2;
	}
	
	/**
	 * divides 2 numbers
	 * @param num1 1st number to be divided
	 * @param num2 2nd number to be divided
	 * @return the quotient of the 2 numbers
	 */
	public double divide(double num1 , double num2) {
		return num1 / num2;
	}
}
