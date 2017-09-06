/*
*	Prompts user to enter the center coordinates and radiuses of 2 circles.
*	Determines wether the circles are seperate from, touching, overlapping or withing each other
*
*/
import java.util.*;
public class Question6{

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double[] centerA = new double[2];
		double[] centerB = new double[2];
		System.out.println("Please enter center coordinates of circle A (press Enter after each value): ");
		centerA[0] = input.nextInt();
		centerA[1] = input.nextInt();
		System.out.println("Please enter the radius of circle A: ");
		double radiusA = input.nextInt();
		System.out.println("Please enter center coordinates of circle B (press Enter after each value): ");
		centerB[0] = input.nextInt();
		centerB[1] = input.nextInt();
		System.out.println("Please enter the radius of circle B: ");
		double radiusB = input.nextInt();
		
		System.out.println("The circles are " + checkForOverlap(radiusA,radiusB,calcDistance(centerA, centerB)));
	}
	public static double calcDistance(double[] A, double[] B){
		
		return Math.sqrt(Math.pow((B[0]-A[0]), 2) + Math.pow((B[1]-A[1]), 2));
	}
	
	public static String checkForOverlap(double radiusA, double radiusB, double distanceOfCenters){
		double sumOfRadius = radiusA + radiusB;
		if(sumOfRadius == distanceOfCenters){
			return "touching each other";
		}
		else if(sumOfRadius < distanceOfCenters){
			return "seperate from each other";
		}
		else{
			if(2 * distanceOfCenters <= sumOfRadius){
				return "within each other";
			}
			else{
				return "overlapping each other";
			}
		}
	}
}
