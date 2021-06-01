package com.bluesnap.task.model;

public class Main {

	public static void main(String[] args) {
		int m = 3;
		int n = 4;

		// can be Integer or Character
		MyMatrix<Character> myMatrix = new MyMatrix<>(char.class, m, n);

		myMatrix.printMatrix();
		
		myMatrix.printSpiral();
	}
}
