package main;
import java.util.ArrayList;


public class Quadratic {

	private double a, b, c;
	private double x1, x2;
	private static double quadratic[] = new double[3];

	public Quadratic(){	
	}
	
	public Quadratic(double a){
		this.a= a;
	}
	
    public Quadratic(double a, double b){
		this.a=a;
		this.b=b;
	}
    
    public Quadratic(double a, double b, double c){
    	this.a=a;
		this.b=b;
		this.c=c;
    }
    
    public Quadratic(int a){
		this.a= a;
	}
	
    public Quadratic(int a, int b){
		this.a=a;
		this.b=b;
	}
    
    public Quadratic(int a, int b, int c){
    	this.a=a;
		this.b=b;
		this.c=c;
    }
    
    double getA() {
    	return a;
    }
    
    double getB() {
    	return b;
    }
    
    double getC() {
    	return c;
    }
    
    
    double getRoot1 () {
    	double rightTerm = Math.sqrt(Math.pow(b,2) - (4*a*c)) / (2*a);
    	x1 = ((-b)/2*a - rightTerm);
    	return x1;
    }
    double getRoot2 () {
    	double rightTerm = Math.sqrt(Math.pow(b,2) - (4*a*c)) / (2*a);
    	x2 = ((-b)/2*a  + rightTerm);
    	return x2;
    }
    
    boolean hasEqualRoots() {
    	if(getRoot1() == getRoot2())
    		return true;
    	else
    		return false;
    }
	
	public static Quadratic signAnalyze(String totalString) {
		ArrayList<Character> negativesArray = new ArrayList<Character>();
		
		//count Amount of Positives and Negatives, and drop in ArrayList
		for(int i=0; i<totalString.length()-1; i++) {
			if (totalString.charAt(i) == '+') 
			 negativesArray.add('+');
			
			else if (totalString.charAt(i) == '-') 
			 negativesArray.add('-');
			
			
			else 
				continue;
			
			continue;	
		}
        
		// if no value for a is entered
		if (totalString.charAt(0) == 'x') 
			quadratic[0] = 1.0;
		
        // if a value for a is entered
		else 
			quadratic[0] = Double.parseDouble(totalString.substring(0, totalString.indexOf('x')));
		
        
		// "ax^2 " term is cut out of string: "bx + c" 
		totalString = totalString.substring(totalString.indexOf(negativesArray.get(2)) + 2);
        
		//if no b value is entered
		if( totalString.charAt(0) == 'x')
			quadratic[1] = 1.0;
        
	    //if no b term is entered
		else if ( totalString.indexOf('x') == -1)
			quadratic[1] = 0.0;
		// if a value of b is entered
		else 
			quadratic[1] = Double.parseDouble(totalString.substring(0, totalString.indexOf('x')));
        totalString = totalString.substring(totalString.indexOf(negativesArray.get(3)) + 2);
        // if no c term is entered
		if(totalString.charAt(totalString.length()-1) == 'x' || totalString.contains("x "))
			quadratic[2] = 0.0;	

	    // if a value for c is entered
		else 
			quadratic[2] = Double.parseDouble(totalString.substring(totalString.lastIndexOf(' ')+1));
        
		
		//for loop that sets values for a ,b or c as negative if they are negative in the array
		for (int i =0; i <negativesArray.size(); i++) {
			if (negativesArray.get(i) == '-')
				quadratic[i] = -(quadratic[i]);
		}
		
		return new Quadratic(quadratic[0],quadratic[1],quadratic[2]);
	}
	
	@Override
	public String toString() {
		
		if (hasEqualRoots()) {
			return "a:" + getA() + "\nb:" + getB() + "\nc:" + getC() + "\nRoot:" + getRoot1();
		}
		
		else {
			return "a:" + getA() + "\nb:" + getB() + "\nc:" + getC() + "\nRoot 1:" + getRoot1() + " Root 2 :" + getRoot2();
		}
		
	}
	
}
