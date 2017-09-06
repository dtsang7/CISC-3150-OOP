/*
*	Read in radius of a circle from user. Calculate
*	and output the area.
*/
import java.util.*;

public class Question2{

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			if(input.hasNextInt()){
				System.out.println(Math.PI * Math.pow((double)input.nextInt(), 2));
			}
			else if(input.hasNextDouble()){
				System.out.println(Math.PI * Math.pow(input.nextDouble(), 2));				
			}
			else{
				System.out.println("Invalid input");
				input.next();
			}
		}
		input.close();
	}
}
