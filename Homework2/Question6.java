/*
*	Chipok Tsang
*
*	This program tokenize individual characters.
*/
import java.util.*;
public class Question6{

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		in.useDelimiter("");
		System.out.println("Enter a text: ");
		while(in.hasNext()){
			System.out.println(in.next());
		}
		
		in.close();
	}
}