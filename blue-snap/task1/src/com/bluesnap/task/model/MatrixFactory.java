package com.bluesnap.task.model;

public class MatrixFactory {

	@SuppressWarnings("unchecked")
	public <T> T[][] generateMatrix(Class<T> matrixType, int m, int n) {
		if (n <= 0 || m <= 0) {
			System.out.println("Indalid matrix size");
			return null;
		}

		if (matrixType == Integer.TYPE) {
			return (T[][]) generateIntMatrix(m, n);
		}
		if (matrixType == Character.TYPE) {
			return (T[][]) generateCharMatrix(m, n);
		}

		System.out.println("Unknown matrix type");
		return null;
	}

	private static Integer[][] generateIntMatrix(int m, int n) {
		Integer[][] matrix = new Integer[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = i * n + j + 1;
			}
		}
		return matrix;
	}

	private static Character[][] generateCharMatrix(int m, int n) {
		Character[][] matrix = new Character[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = (char) (i * n + j + 'A');
			}
		}
		return matrix;
	}
}
