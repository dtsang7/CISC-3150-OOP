public class MonteCarlo {
	public static void main(String[] args){
		double numDots = 4000000000.0;
		System.out.println("Math class pi value: " + Math.PI);
		System.out.println("Monte Carlo pi value: "+ pi(numDots));
		
	}
	public static double pi(double numDots){
		double inCircle = 0.0;
		
		for(double i = 0.0; i < numDots; i++){
			double x = random();
			double y = random();
			double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
			if(distance < 1){
				inCircle++;
			}
		}
		return inCircle/numDots * 4.0;
	}
	
	public static double random(){
		return Math.random() * 2 - 1;
	}
}