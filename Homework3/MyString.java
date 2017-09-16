package Homework3;

/*
 *	Chipok Tsang
 *
 *	The MyString class is my own version of the java String class.
 *	The class is immutable and has some similar methods that are in
 *	the java String class.
 */
import java.util.Stack;

public final class MyString {
	private final char[] str;
	
	public MyString(char[] chars){
		str = new char[chars.length];
		for(int i = 0; i < str.length ; i++){
			str[i] = chars[i];
		}
	}
	public char charAt(int index){
		return str[index];
	}
	public int length(){
		return str.length;
	}
	public MyString substring(int begin, int end){
		char[] sub = new char[end-begin];
		for(int i = 0; i < sub.length; i++){
			sub[i] = str[begin];
			begin++;
		}
		return new MyString(sub);
	}
	public MyString toLowerCase(){
		int ascii_A = 65;
		int ascii_Z = 90;
		char[] copy = new char[str.length];
		for(int i = 0; i < copy.length; i++){
			if(str[i] >= ascii_A && str[i] <= ascii_Z){
				int value = str[i] + 32;
				copy[i] = (char)value;
			}
			else{
				copy[i] = str[i];
			}
		}
		return new MyString(copy);
	}
	public MyString toUpperCase(){
		int ascii_a = 97;
		int ascii_z = 122;
		char[] copy = new char[str.length];
		for(int i = 0; i < copy.length; i++){
			if(str[i] >= ascii_a && str[i] <= ascii_z){
				int value = str[i] - 32;
				copy[i] = (char)value;
			}
			else{
				copy[i] = str[i];
			}
		}
		return new MyString(copy);
	}
	public boolean equals(MyString s){
		if(s == null || str.length != s.length()){
			return false;
		}
		for(int i = 0; i < str.length ; i++){
			if(str[i] != s.charAt(i)){
				return false;
			}
		}
		return true;
	}
	public MyString getMyString(){
		return new MyString(str);
		
	}
	public String toString(){
		return new String(str);
	}
	public static MyString valueOf(int i){
		Stack<Character> stack = new Stack<Character>();
		int length = 0;
		while(i != 0){
			stack.push((char)(i%10 + 48));	// add 48 to get the character from ascii table
			i = i/10;
			length++;
		}
		char[] values = new char[length];
		for(int j = 0; j < length; j++){
			values[j] = stack.pop();
		}
		return new MyString(values);
	}
}
