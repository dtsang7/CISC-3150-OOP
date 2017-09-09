/*
*	Chipok Tsang
*	
*	This program reads in a string input from the user
*	and checks wheter the string is a palindrome or not.
*/

import java.util.*;
public class Question3{

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a word: ");
		
		if(checkPalindrome(input.nextLine())){
			System.out.println("It is a palindrome");
		}
		else{
			System.out.println("It is NOT a palindrome");
		}
		
		input.close();
	}
	
	public static boolean checkPalindrome(String word){
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < word.length(); i++){
			builder.append(word.charAt(i));
		}
	
		String forward = builder.toString();
		String backward = builder.reverse().toString();	
		return 0 == forward.compareToIgnoreCase(backward);
	}
}
