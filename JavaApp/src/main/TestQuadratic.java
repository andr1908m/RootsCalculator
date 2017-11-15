package main;
import java.util.Scanner;

public class TestQuadratic {

	public static void main(String[] args) {

		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Input expression with format (include spaces):ax^2 + bx + c");
		String totalString = input.nextLine();
		input.close();
		
		Quadratic quadratic = Quadratic.signAnalyze(totalString);
		
		quadratic.toString();
	}

}
