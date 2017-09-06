/*
*	Reads input from system.in and prints the contents 
*	to the screen.
*/
import java.util.*;

public class Question4{
	
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		while(input.hasNext()){
			System.out.println(input.next());
		}
		input.close();
	}
}
