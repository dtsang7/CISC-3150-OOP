/*
*	Chipok Tsang
*	
*	This program reads in an integer input from the user then displays
*	a pyramid of that size on the screen that counts up on the left and 
*	counts down on the right.
*/
import java.util.*;
public class Question1{

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		System.out.println("How tall of a pyramid do you want?");
		
		if(input.hasNextInt()){
			
			drawPyramid(input.nextInt());
		}
		else{
			System.out.println("Invalid input");
		}
		input.close();
	}
	
	public static void drawPyramid(int height){
		int elementsOnLevel = 1;
		int level = 1;
		drawPyramid(height, elementsOnLevel, level);
	}
	public static void drawPyramid(int height, int elementsOnLevel, int level){
		if(height == 0){
			return;
		}
		int num = 1;
		boolean levelUp = true;

		System.out.printf("%"+height*3+"d", num);
		num++;

		for(int i = 1; i < elementsOnLevel ; i++){
			System.out.printf("%3d",num);
			if(num >= level){
				levelUp = false;
			}
			if(levelUp){
				num++;
			}
			else{
				num--;
			}
		}
		System.out.println();
		drawPyramid(height-1, elementsOnLevel+2, level+1);
	}
}