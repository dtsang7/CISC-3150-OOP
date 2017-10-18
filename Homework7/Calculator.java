/*
*	Chipok Tsang
*
*	This is a command line calculator class. That accepts a mathemetical expression in quotation
*	marks. It evaluates the expression and returns the result of the computation. This class 
*	supports the following operations: +, -, *, /, %, (, and ). It accepts both integer and double
*	values.
*/

import java.util.*;

public class Calculator{
	
	public static void main(String[] args){
		
		if(args.length == 1){
			StringTokenizer tkn = new StringTokenizer(args[0]);
			String[] arg = new String[tkn.countTokens()];
			for(int i = 0; i < arg.length; i++){
				arg[i] = tkn.nextToken();
			}	
			
			try{
				checkIfValid(arg);
				double result = evaluatePostfix(toPostfix(arg));
				if(result % 1 != 0){
					System.out.println(result);
				}
				else{
					System.out.println((int)result);
				}
			}
			catch(IllegalOperationException ioe){
				System.out.println(ioe.getMessage());
			}
			catch(LookAtMrAlgebraOverHereException lama){
				System.out.println(lama.getMessage());
			}
			catch(UserIsADumbassException uida){
				System.out.println(uida.getMessage());
			}
			catch(DivisionByZeroException dbz){
				System.out.println(dbz.getMessage());
			}

		}
		else if(args.length == 0){
			System.out.println("Please pass expression to the program in quotation marks");
		}
		else{
			System.out.println("Please put expression in quotation marks");
		}
	}

	public static void checkIfValid(String[] arg){
		checkSpacing(arg);
		checkParanthesis(arg);
		checkExpression(arg);
	}

	public static void checkSpacing(String[] arg){

		for(int i = 0; i < arg.length; i++){
			String s = arg[i];
			if(s.length() > 1){
				if(!isNumber(s)){
						System.out.println("Invalid expression. Seperate each indiviual element with a space");
						System.exit(0);
				}
			}
		}
	}

	public static void checkParanthesis(String[] arg){
		int openPar = 0;
		int closePar = 0;

		for(int i = 0 ; i < arg.length; i++){
			if(arg[i].equals("(")){
				openPar++;
				
			}
			if(arg[i].equals(")")){
				closePar++;
			}
		}

		if(openPar != closePar){
			System.out.println("Invalid expression. Missing paranthesis");
			System.exit(0);
		}
	}

	public static void checkExpression(String[] arg) throws UserIsADumbassException, LookAtMrAlgebraOverHereException{
		int numOperands = 0;
		int numOperators = 0;
		boolean operand;

		if(isNumber(arg[0])){
			operand = true;
			numOperands++;
		}
		else{
			operand = false;
			if(!arg[0].equals("(") && !arg[0].equals(")")){
				numOperators++;
			}
		}
		
		for(int i = 1; i < arg.length; i++){
			String s = arg[i];
			
			if(operand){
			 	if(!isNumber(s)){
			 		if(!s.equals("(") && !s.equals(")")){
						operand = false;
						numOperators++;	
					}
				}
				else{
					throw new LookAtMrAlgebraOverHereException("Okay... Mr. Algebra");
				}
			}
			else{
				if(isNumber(s)){
					numOperands++;
					operand = true;
				}
				else{
					if(!s.equals("(")){
						throw new LookAtMrAlgebraOverHereException("Okay... Mr. Algebra");
					}
				}
			}
		}
		
		if(numOperands - 1 != numOperators){
			throw new UserIsADumbassException("Missing number.");
		}
	}

	public static boolean isNumber(String s){
		try{
			int num = Integer.parseInt(s);

		}catch(NumberFormatException e){
			try{
				double num = Double.parseDouble(s);

			}catch(NumberFormatException ex){
				return false;
			}
		}
		return true;
	}

	public static int precedence(String s){
		switch(s){
			case "+": return 1; 
			case "-": return 1; 
			case "*": return 2; 
			case "/": return 2; 
			case "%": return 2; 
			default: return -1;
		}
	}

	public static String toPostfix(String[] arg){
		String postfix = "";
		Stack<String> stack = new Stack<String>();

		for(int i = 0; i < arg.length; i++){
			String s = arg[i];

			if(isNumber(s)){
				postfix += s + " ";
			}
			else if(s.equals("(")){
				stack.push(s);
			}
			else if(s.equals(")")){

				while(!stack.isEmpty() && !stack.peek().equals("(")){
					postfix += stack.pop() + " ";
				}
				stack.pop();
			}
			else{
				while(!stack.isEmpty() && precedence(s) <= precedence(stack.peek())){
					postfix += stack.pop() + " ";
				}
				stack.push(s);
			}
		}
		while(!stack.isEmpty()){
			postfix += stack.pop() + " ";
		}
		return postfix;
	}
	public static double evaluatePostfix(String exp) throws DivisionByZeroException, IllegalOperationException{
		Stack<Double> stack = new Stack<Double>();
		StringTokenizer tkn = new StringTokenizer(exp);

		while(tkn.hasMoreTokens()){
			String token = tkn.nextToken();
			if(isNumber(token)){
				stack.push(Double.parseDouble(token));
			}
			else{
				double num2 = stack.pop();
				double num1 = stack.pop();
				switch(token){
					case "+": stack.push(num1 + num2); break;
					case "-": stack.push(num1 - num2); break;
					case "*": stack.push(num1 * num2); break;
					case "%": stack.push(num1 % num2); break;
					case "/": 
							if(num2 != 0){
								stack.push(num1 / num2);
							}
							else{
								throw new DivisionByZeroException("Division by zero exception was caught");
							}
							break;
					default: 
							throw new IllegalOperationException(token + " Operation is not supported");
				}
			}
		}
		return stack.pop();
	}

	static class LookAtMrAlgebraOverHereException extends IllegalArgumentException{

		public LookAtMrAlgebraOverHereException(String msg){
			super(msg);
		}
	}
	static class IllegalOperationException extends IllegalArgumentException{

		public IllegalOperationException(String msg){
			super(msg);
		}
	}
	static class UserIsADumbassException extends IllegalArgumentException{

		public UserIsADumbassException(String msg){
			super(msg);
		}
	}
	static class DivisionByZeroException extends ArithmeticException{

		public DivisionByZeroException(String msg){
			super(msg);
		}
	}
}