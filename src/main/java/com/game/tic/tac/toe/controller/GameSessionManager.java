package com.game.tic.tac.toe.controller;

import java.util.ArrayList;
import java.util.List;

import com.game.tic.tac.toe.models.GameTicTacToe;

public class GameSessionManager {
	private static List<GameTicTacToe> activeGameSessions = new ArrayList<>();

	public static void addActiveSession(GameTicTacToe session) {
		activeGameSessions.add(session);
	}

	public static void removeActiveSession(GameTicTacToe session) {
		activeGameSessions.remove(session);
	}

	public static GameTicTacToe findActiveSession(String sessionId) {
		for (GameTicTacToe session : activeGameSessions) {
			if (session.getSessionId().equals(sessionId)) {
				return session;
			}
		}
		return null;
	}
}
