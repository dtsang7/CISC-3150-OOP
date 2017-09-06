/*
*	Generate a random integer between 1 and 12 and
*	display the english name of that month.
*/
public class Question3{
	
	public static void main(String[] args){
		
		String[] months = {"January","February","March","April","May","June","July",
							"August","September","October","November","December"};
		
		int random = (int)(Math.random()*12 + 1);
		System.out.println(months[random - 1]);
	}
}
