/*
*	Read in three 2D points A, B, and C from user.
*	Calculate the lenght of each side of the triangle.
*	Check if it is a real triangle by showing that any 2 sides added together is
*	greater than the third side.
*/
import java.util.*;

public class Question5{
	
	public static void main(String[] args){
		double[] pointA = new double[2];
		double[] pointB = new double[2];
		double[] pointC = new double[2];
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter coordinates for point A(press ENTER after each value of x and y):");
		pointA[0] = (double)input.nextInt();
		pointA[1] = (double)input.nextInt();
		System.out.println("Please enter coordinates for point B(press ENTER after each value of x and y):");
		pointB[0] = (double)input.nextInt();
		pointB[1] = (double)input.nextInt();
		System.out.println("Please enter coordinates for point C(press ENTER after each value of x and y):");
		pointC[0] = (double)input.nextInt();
		pointC[1] = (double)input.nextInt();
		
		System.out.println("The triangle is: " + checkTriangle(lengthOfSides(pointA, pointB, pointC)));
		input.close();
	}
	public static double[] lengthOfSides(double[] A, double[] B, double[] C){
		double[] sides = new double[3];
		sides[0] = Math.sqrt(Math.pow((B[0]-A[0]), 2) + Math.pow((B[1]-A[1]), 2));
		sides[1] = Math.sqrt(Math.pow((C[0]-B[0]), 2) + Math.pow((C[1]-B[1]), 2));
		sides[2] = Math.sqrt(Math.pow((A[0]-C[0]), 2) + Math.pow((A[1]-C[1]), 2));		
		return sides;
	}
	public static boolean checkTriangle(double[] sides){
		if(sides[0]+sides[1] <= sides[2]){
			return false;
		}
		else if(sides[1]+sides[2] <= sides[0]){
			return false;
		}
		else if(sides[0]+sides[2] <= sides[1]){
			return false;
		}
		else{
			return true;
		}
	}
}
