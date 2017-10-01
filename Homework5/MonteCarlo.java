/*
*	Chipok Tsang
*
*	The monte carlo class generates 4 billion random dots with x and y values inside a square 
*	with side length of 1 which overlaps a 1/4 of a circle with radius 1. Counts how 
*	many of those dots will fall inside and outside the circle. Get the ratio of dots inside 
*	circle to inside square and calculate the value of Pi.
*/
public class MonteCarlo {
	public static void main(String[] args){
		double quarterCircleArea = Math.PI * Math.pow(1,2)/4;
		double squareArea = Math.pow(1,2);
		System.out.println("Quarter circle area with radius 1: "+ quarterCircleArea);
		System.out.println("Square area with length 1: "+ squareArea);
		System.out.println("Ratio of area: " + quarterCircleArea/squareArea + " to 1\n");
	
		double numDots = 4000000000.0;
		System.out.println("Monte Carlo Pi value: "+ pi(numDots));
		
	}
	public static double pi(double numDots){
		//number of dots in circle
		double inCircle = 0.0;
		//number of dots outside circle
		double outCircle = 0.0;

		for(double i = 0.0; i < numDots; i++){
			//generate random x and y values
			double x = Math.random();
			double y = Math.random();
			//get the distance from point(0,0) to the random dot
			double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
			//radius of circle is 1. If distance is smaller than 1 then dot is inside circle.
			if(distance < 1){
				inCircle++;
			}
			else{
				outCircle++;
			}
		}
		System.out.println("Number of dots outside circle: " + outCircle);
		System.out.println("Number of dots inside circle: " + inCircle);
		double ratio = inCircle/numDots;
		System.out.println("Ratio of dots: " + ratio + " to 1");
		//calculate and return Pi value
		return ratio * 4.0;
	}
}

