/*
*	Chipok Tsang
*	
*	This program has 4 different threads. Each thread has an array of letters.
*	The threads are synchronized so that all letters are printed out in alphabetical order.
*/

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class MultiThread{
	
	public static void main(String[] args){
		char[] array1 = {'A','E','I','M','Q','U','Y'};
		char[] array2 = {'B','F','J','N','R','V','Z'};
		char[] array3 = {'C','G','K','O','S','W'};
		char[] array4 = {'D','H','L','P','T','X'};

		PrintArray pa1 = new PrintArray(array1, 0);
		PrintArray pa2 = new PrintArray(array2, 1);
		PrintArray pa3 = new PrintArray(array3, 2);
		PrintArray pa4 = new PrintArray(array4, 3);

		pa1.next = pa2;
		pa2.next = pa3;
		pa3.next = pa4;
		pa4.next = pa1;

		Thread t1 = new Thread(pa1);
		Thread t2 = new Thread(pa2);
		Thread t3 = new Thread(pa3);
		Thread t4 = new Thread(pa4);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class PrintArray implements Runnable{

	int priority;
	char[] c;
	PrintArray next;

	public PrintArray(){}

	public PrintArray(char[] array, int priority){
		this.priority = priority;
		c = array; 
	}

	public void run(){
		try{
			Thread.sleep(priority*10);
		}catch(InterruptedException ex){}

		synchronized(this){

			for(int i = 0; i < c.length; i++){
				System.out.println(c[i]);
				
				synchronized(next){
					next.notify();
				}

				if(i < c.length - 1){
					try{
						wait();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		}
	}
}


