package com.game.tic.tac.toe.game;

import java.util.List;

import org.springframework.stereotype.Service;

import com.game.tic.tac.toe.models.Cell;
import com.game.tic.tac.toe.models.GameTicTacToe;

@Service
public class GameServiceImpl implements IGameService {
	private GameTicTacToe game = new GameTicTacToe();

	public GameServiceImpl() {
		super();
	}

	@Override
	public List<Cell> initialiserCells() {
		game = new GameTicTacToe();
		return game.getBoard().getCells();
	}

	@Override
	public GameTicTacToe changePlayerTurn(Cell squareClicked) {
		int boardIndex = determineBoardIndex(game, squareClicked);
		game.getBoard().getCells().get(squareClicked.getId()).setState(squareClicked.getState());
		if (game.getBoardList().size() > boardIndex) {
			game.getBoardList().get(boardIndex).updateCellState(squareClicked.getId(), game.getActivePlayer());
		}
		if (isWinner()) {
			game.setWinner(true);
			game.setGameRunning(false);
			game.setGameOver(true);
		}
		if (!game.isGameOver()) {
			game.setActivePlayer(game.getActivePlayer().equals("X") ? "O" : "X");
		}
		game.setTurnCount(game.getTurnCount() + 1);
		game.setGameOver(game.isGameOver() ? true : false);

		return game;
	}

	private int determineBoardIndex(GameTicTacToe game, Cell squareClicked) {
		return 0;
	}

	@Override
	public boolean isGameOver() {
		return game.getTurnCount() > 8 || game.isWinner();
	}

	@Override
	public boolean isWinner() {
		return checkDiagonal() || checkRows("row") || checkRows("col");
	}

	private boolean checkRows(String mode) {
		boolean isRow = mode.equals("row");
		int dist = isRow ? 1 : 3;
		int inc = isRow ? 3 : 1;
		int numTimes = isRow ? 7 : 3;
		List<Cell> boardCells = game.getBoard().getCells();

		for (int i = 0; i < numTimes; i += inc) {
			String firstSquare = boardCells.get(i).getState();
			String secondSquare = boardCells.get(i + dist).getState();
			String thirdSquare = boardCells.get(i + dist * 2).getState();

			if (firstSquare != null && secondSquare != null && thirdSquare != null && firstSquare.equals(secondSquare)
					&& secondSquare.equals(thirdSquare)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkDiagonal() {
		int timesRun = 2;
		String midSquare = game.getBoard().getCellState(4);
		List<Cell> boardCells = game.getBoard().getCells();

		for (int i = 0; i <= timesRun; i += 2) {
			String upperCorner = boardCells.get(i).getState();
			String lowerCorner = boardCells.get(8 - i).getState();

			if (midSquare != null && upperCorner != null && lowerCorner != null && midSquare.equals(upperCorner)
					&& upperCorner.equals(lowerCorner)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public GameTicTacToe initialiserGame() {
		return game = new GameTicTacToe();
	}

}
