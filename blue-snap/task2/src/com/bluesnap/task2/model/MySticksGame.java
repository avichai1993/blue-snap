package com.bluesnap.task2.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MySticksGame {

	private Set<Integer> possibleMoves = new HashSet<Integer>();
	private Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

	public MySticksGame(int[] possibleMoves) {
		for (int item : possibleMoves) {
			this.possibleMoves.add(item);
		}
	}

	public boolean win(int numberOfSticks) {
		if (numberOfSticks <= 0) {
			return false;
		}
		if (map.containsKey(numberOfSticks)) {
			return map.get(numberOfSticks);
		}
		if (possibleMoves.contains(numberOfSticks)) {
			map.put(numberOfSticks, true);
			return true;
		}

		for (int myMove : possibleMoves) {
			if (numberOfSticks - myMove >= 0) {
				boolean isAllWin = true;
				for (int opponentMove : possibleMoves) {
					int sticksLeft = numberOfSticks - myMove - opponentMove;
					if (sticksLeft >= 0) {
						isAllWin &= win(sticksLeft);
					}
				}
				if (isAllWin) {
					map.put(numberOfSticks, true);
					return true;
				}
			}
		}

		map.put(numberOfSticks, false);
		return false;
	}

	public static boolean winStatic(int numberOfSticks, int[] possibleMoves) {
		return winStatic(numberOfSticks, possibleMoves, new HashMap<Integer, Boolean>());
	}

	public static boolean winStatic(int numberOfSticks, int[] possibleMoves, Map<Integer, Boolean> map) {
		if (numberOfSticks <= 0) {
			return false;
		}
		if (map.containsKey(numberOfSticks)) {
			return map.get(numberOfSticks);
		}
		for (int item : possibleMoves) {
			if (item == numberOfSticks) {
				map.put(numberOfSticks, true);
				return true;
			}
		}

		for (int myMove : possibleMoves) {
			if (numberOfSticks - myMove >= 0) {
				boolean isAllWin = true;
				for (int opponentMove : possibleMoves) {
					int sticksLeft = numberOfSticks - myMove - opponentMove;
					if (sticksLeft >= 0) {
						isAllWin &= winStatic(sticksLeft, possibleMoves, map);
					}
				}
				if (isAllWin) {
					map.put(numberOfSticks, true);
					return true;
				}
			}
		}

		map.put(numberOfSticks, false);
		return false;
	}
}
