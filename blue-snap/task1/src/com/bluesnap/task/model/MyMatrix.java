package com.bluesnap.task.model;

public class MyMatrix<T> {

	private enum StaticType {
		Row, Column
	}

	private int m;
	private int n;
	private T[][] matrix;

	public MyMatrix(Class<T> matrixType, int m, int n) {
		this.m = m;
		this.n = n;

		MatrixFactory matrixFactory = new MatrixFactory();
		this.matrix = matrixFactory.generateMatrix(matrixType, m, n);
	}

	public void printMatrix() {
		if (matrix != null) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					printCell(matrix, i, j);
				}
				System.out.println();
			}
		}
		System.out.println();
	}

	public void printSpiral() {
		if (matrix != null) {
			printSpiral(matrix, m, n, 0);
		}
		System.out.println();
	}

	private void printSpiral(T[][] matrix, int rows, int cols, int currentIndex) {
		if (rows <= 0 || cols <= 0 || currentIndex < 0 || currentIndex >= rows || currentIndex >= cols) {
			return;
		}

		if (currentIndex > cols - 1) {
			return;
		}
		printRow(matrix, currentIndex, currentIndex, cols - 1);

		if (currentIndex + 1 > rows - 1) {
			return;
		}
		printCol(matrix, cols - 1, currentIndex + 1, rows - 1);

		if (cols - 2 < currentIndex) {
			return;
		}
		printRow(matrix, rows - 1, cols - 2, currentIndex);

		if (rows - 2 < currentIndex + 1) {
			return;
		}
		printCol(matrix, currentIndex, rows - 2, currentIndex + 1);

		printSpiral(matrix, rows - 1, cols - 1, currentIndex + 1);
	}

	private void printRow(T[][] matrix, int row, int start, int end) {
		printRowOrCol(matrix, StaticType.Row, row, start, end);
	}

	private void printCol(T[][] matrix, int col, int start, int end) {
		printRowOrCol(matrix, StaticType.Column, col, start, end);
	}

	private void printRowOrCol(T[][] matrix, StaticType staticType, int staticIndex, int start, int end) {
		if (start <= end) {
			for (int i = start; i <= end; i++) {
				printCell(matrix, staticType, staticIndex, i);
			}
		} else { // start > end
			for (int i = start; i >= end; i--) {
				printCell(matrix, staticType, staticIndex, i);
			}
		}
	}

	private void printCell(T[][] matrix, StaticType staticType, int staticIndex, int dinemicIndex) {
		if (staticType == StaticType.Row) {
			printCell(matrix, staticIndex, dinemicIndex);
		} else if (staticType == StaticType.Column) {
			printCell(matrix, dinemicIndex, staticIndex);
		}
	}

	private void printCell(T[][] matrix, int i, int j) {
		System.out.printf("%-3s", matrix[i][j]);
	}
}
