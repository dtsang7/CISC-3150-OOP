
import java.util.Scanner;
public class NQueens {
	private int count = 0;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of Queens:");

		if(input.hasNextInt()){
			int n = input.nextInt();
			if(n < 1){
				System.out.println("Invalid input");
			}
			else if(n == 1){
				System.out.println("Solutions: " + n);
			}
			else if(n == 2 || n == 3){
				System.out.println("Solutions: " + 0);
			}
			else{
				NQueens board = new NQueens();
				board.solutions(n);
				System.out.println("Solutions: " + board.getCount());
			}
		}
		else{
			System.out.println("Invalid input!");
		}
		
		input.close();
	}
	
	public void solutions(int n){
		int[][] b = new int[n][n];
		placeQueen(b, 0, 0, n);
	}
	
	public void placeQueen(int[][] board, int row, int column, int queens){

		if(row == board.length || column == board.length){
			return;
		}
		for(int i = row; i < board.length; i++){
			if(checkPlacement(board, i, column)){
				int[][] copy = copyBoard(board);
				copy[i][column] = 1;
				if(queens - 1 == 0){
					count++;
					printBoard(copy);
					System.out.println();
					break;
				}
				else{
					placeQueen(copy, 0, column +1, queens - 1);
				}
			}
		}
	}
	
	public boolean checkPlacement(int[][] b, int row, int column){
		if(checkRow(b, row)){
			if(checkColumn(b, column)){
				if(checkDiagonal(b, row, column)){
					return true;
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public boolean checkRow(int[][] board, int row){
		for(int i = 0; i < board.length; i++){
			if(board[row][i] == 1){
				return false;
			}
		}
		return true;
	}
	public boolean checkColumn(int[][] board, int column){
		for(int i = 0; i < board[0].length; i++){
			if(board[i][column] == 1){
				return false;
			}
		}
		return true;
	}
	public boolean checkDiagonal(int[][] board, int row, int column){
		for(int i = 1; i < board.length ; i++){
			if(row+i < board.length && column+i < board.length){
				if(board[row+i][column+i] == 1){
					return false;
				}
			}
			else{
				break;
			}
		}
		for(int i = 1; i < board.length ; i++){
			if(row-i > -1 && column-i > -1){
				if(board[row-i][column-i] == 1){
					return false;
				}
			}
			else{
				break;
			}
		}
		for(int i = 1; i < board.length ; i++){
			if(row+i < board.length && column-i > -1){
				if(board[row+i][column-i] == 1){
					return false;
				}
			}
			else{
				break;
			}
		}
		for(int i = 1; i < board.length ; i++){
			if(row-i > -1 && column+i < board.length){
				if(board[row-i][column+i] == 1){
					return false;
				}
			}
			else{
				break;
			}
		}
		return true;
	}
	
	
	public void printBoard(int[][] b){
		for(int i = 0; i < b.length; i++){
			for(int j = 0; j < b.length; j++){
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public int[][] copyBoard(int[][] board){
		int[][] copy = new int[board.length][board.length];
		for(int i = 0; i < copy.length; i++){
			for(int j = 0; j < copy.length; j++){
				copy[i][j] = board[i][j];
			}
		}
		return copy;
	}

	public int getCount(){
		return count;
	}
}
