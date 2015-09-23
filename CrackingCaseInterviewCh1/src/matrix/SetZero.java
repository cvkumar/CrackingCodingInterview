package matrix;

import java.util.Arrays;

public class SetZero {
	
	static void set_zero(int matrix[][]) {
		
		if(matrix == null)
			return;
		
		int row_length = matrix.length;
		int column_length = matrix[0].length;
		boolean[][] zeroes = new boolean[row_length][column_length];
		
		for (int i = 0; i < row_length; i++) {
			for (int j = 0; j < column_length ; j++) {
				if (matrix[i][j] == 0) {
					zeroes[i][j] = true;
					break;
				}
				else
					zeroes[i][j] = false;
			}
		}
		
		for (int i = 0; i < row_length; i++) {
			for (int j = 0; j < column_length ; j++) {
				if (zeroes[i][j])
					set_row_col_zero(matrix, i, j);
			}
		}
	}
	
	static void set_row_col_zero(int matrix[][], int row, int column) {
		
		int row_length = matrix.length;
		int column_length = matrix[0].length;
		System.out.println("row: " + row + " column: " + column);
		for(int i = 0; i < column_length; i++) {
			matrix[row][i] = 0;
		}
		
		for(int i = 0; i < row_length; i++) {
			matrix[i][column] = 0;
		}
		
	}
	
	static void book_set_zero (int matrix[][]) {
		
		int row_length = matrix.length;
		int col_length = matrix[0].length;
		
		boolean[] zero_rows = new boolean[row_length];
		boolean[] zero_columns = new boolean[col_length];
		
		for (int i = 0; i < row_length; i++) {
			for (int j = 0; j < col_length ; j++) {
				if (matrix[i][j] == 0) {
					System.out.println(j);
					zero_rows[i] = true;
					zero_columns[j] = true;
				}
			}
		}
		
		for (int i = 0; i < row_length; i++) {
			if (zero_rows[i])
				set_row_zero(matrix, i);
		}
		
		for (int i = 0; i < col_length; i++) {
			if (zero_columns[i])
				set_column_zero(matrix, i);
		}
	}
		
	static void set_row_zero(int matrix[][], int row) {
		for (int i=0; i < matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
	}
	
	static void set_column_zero(int matrix[][], int col) {
		for (int i=0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}
	
	static void print_matrix(int matrix[][]) {
		System.out.println();
		for(int row[]: matrix) {
			for(int val: row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int [][] test1 = {{1,2,3}, {1,2,3}, {1,2,3}};
		int [][] test2 = {{0,2}, {1,2}, {1,2}};
		int [][] test3 = {{1,2,3,4}, {1,2,0,4}, {1,2,3,4}};
		int [][] test4 = {{1,2,3,4,5}, {1,2,3,4,5}, {1,2,3,0,5}, {1,2,3,4,0}};
		
		print_matrix(test1);
		book_set_zero(test1);
		print_matrix(test1);
		
		print_matrix(test2);
		book_set_zero(test2);
		print_matrix(test2);
		
		print_matrix(test3);
		book_set_zero(test3);
		print_matrix(test3);
		
		print_matrix(test4);
		book_set_zero(test4);
		print_matrix(test4);
		
	}
}
