/*
*	Chipok Tsang
*
*	This program tokenize comma seperated values entered
*	by the user.
*/

import java.util.*;
public class Question5{

	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		input.useDelimiter(",|\\n");
		System.out.println("Please enter values seperated by commas:");
		
		while(input.hasNext()){
			System.out.println(input.next());
		}
		
		input.close();
	}
}