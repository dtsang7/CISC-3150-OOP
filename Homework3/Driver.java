package Homework3;
/*
 *	Chipok Tsang
 *
 * 	Driver class to show output of MyString class 
 */
public class Driver {
	public static void main(String[] args){
		
		char[] array = {'H','e','l','l','o',' ','W','o','r','l','d','!'};
		char[] array2 = {'G','o','o','d','b','y','e',' ','W','o','r','l','d','!'};
		MyString string = new MyString(array);
		MyString string2 = new MyString(array);
		MyString string3 = new MyString(array2);
		
		System.out.println("toString() output:\t" + string);
		System.out.println("toUpperCase() output:\t" + string.toUpperCase());
		System.out.println("toString() output:\t" + string);
		System.out.println("toLowerCase() output:\t" + string.toLowerCase());
		System.out.println("toString() output:\t" + string);
		System.out.println();
		System.out.println("charAt(10) output:\t" + string.charAt(10));
		System.out.println("length() output:\t" + string.length());
		System.out.println("substring(1,8) output:\t" + string.substring(1, 8));
		System.out.println("toString() output:\t" + string);
		System.out.println("equals() output:\t" + string.equals(string2));
		System.out.println("equals() output:\t" + string.equals(string3));
		System.out.println("getMyString() output:\t" + string.getMyString());
		System.out.println("valueOf() output:\t" + MyString.valueOf(4231));
		
	}
}
