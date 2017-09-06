/*
*	Read in radius of a circle from user. Calculate
*	and output the area.
*/
import java.util.*;

public class Question2{

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			System.out.println(Math.PI * Math.pow((double)input.nextInt(), 2));
		}
		input.close();
	}
}