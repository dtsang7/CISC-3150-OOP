/*
*	Chipok Tsang
*	
*	This program asks the user for the year and what day the first of January
*	fell on. It then displays a calendar with every month on the screen.
*/

import java.util.*;
public class Question2{
	int startDay;
	
	public static void main(String[] args){
		Question2 draw = new Question2();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the year in YYYY format: ");
		int year = -1;
		while(true){
			try{
				year = input.nextInt();
				break;
			}
			catch(InputMismatchException ex){
				System.out.println("Invalid input. Please enter the correct format 1");
				input.next();
			}
		}
		
		while(!draw.checkYear(year)){
			year = input.nextInt();
		}
		
		System.out.println("Enter the day of January 1 in \"su\",\"mo\",\"tu\",etc. format: ");
		int dayIndex = draw.checkDay(input.next());
		while(dayIndex == -1){
			dayIndex = draw.checkDay(input.next());
		}
			
		draw.printCalendar(year, dayIndex);
		input.close();
	}
	
	public void printCalendar(int year, int day){
		startDay = day;
		int startMonth = 0;
		printMonth(startMonth, year);
	}
	
	public void printMonth(int month, int year){
		if(month == 12){
			return;
		}
		String[] monthName = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		
		System.out.printf("\t%s", monthName[month]+" "+year+"\n");
		printDay(0, month, year);
		System.out.println("\n\n");
		printMonth(month+1, year);
	}
	
	public void printDay(int day, int month, int year){
		if(day == 7){
			System.out.println();
			printNumbers(month, year);
			return;
		}
		String[] dayName = {"Su","Mo","Tu","We","Th","Fr","Sa"};
		
		System.out.printf("%4s", dayName[day]);
		
		printDay(day+1, month, year);
	}
	
	public void printNumbers(int month, int year){
		
		for(int i = 0; i < startDay ; i++){
			System.out.print("    ");
		}
		int numberOfDays = getNumberOfDays(month, year);
		
		for(int i = 0; i < numberOfDays; i++){
			System.out.printf("%4d", i+1);
			startDay++;
			if(startDay%7 == 0){
				System.out.println();
			}
		}
		startDay = startDay%7;
	}
	public int getNumberOfDays(int month, int year){
		if(month == 1){
			if(checkLeapYear(year)){
				return 29;
			}
			else{
				return 28;
			}
		}
		else if(month == 3 || month == 5 || month == 8 || month == 10){
			return 30;
		}
		else{
			return 31;
		}
	}
	
	public int checkDay(String startDay){
		String[] nameOfDay = {"su","mo","tu","we","th","fr","sa"};
		for(int i = 0; i < nameOfDay.length; i++){
			if(startDay.equalsIgnoreCase(nameOfDay[i])){
				return i;
			}
		}
		System.out.println("Invalid input. Please enter the correct format");
		return -1;
	}
	
	public boolean checkYear(int year){
		if(year > 0 && year < 10000){
			return true;
		}
		else{
			System.out.println("Invalid input. Please enter the correct format2");
			return false;
		}
	}
	
	public boolean checkLeapYear(int year){
		if(year%4 == 0){
			if(year%100 == 0){
				if(year%400 == 0){
					return true;
				}
				else{
					return false;
				}
			}
			else{
				return true;
			}
		}
		else{
			return false;
		}
	}
}
