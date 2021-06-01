package com.bluesnap.task2.model;

public class Main {

	public static void main(String[] args) {
		int[] possibleMoves = new int[] { 1, 2, 4 };
		MySticksGame game = new MySticksGame(possibleMoves);

		MySticksGame.winStatic(300, possibleMoves);

		for (int i = 1; i <= 9; i++) {
			System.out.println(i + " sticks: there is " + (game.win(i) ? "a" : "no") + " path that guarantees win");
		}
	}
}
