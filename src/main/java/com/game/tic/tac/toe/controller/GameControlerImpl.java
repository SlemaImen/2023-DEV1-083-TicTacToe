package com.game.tic.tac.toe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.game.tic.tac.toe.game.IGameService;
import com.game.tic.tac.toe.models.Cell;
import com.game.tic.tac.toe.models.GameTicTacToe;

@RestController
@RequestMapping("/api/game")
public class GameControlerImpl implements IGameControler {

	@Autowired
	private IGameService iGameService;

	public GameControlerImpl() {
		super();
	}

	public GameControlerImpl(IGameService iGameService) {
		super();
		this.iGameService = iGameService;
	}

	@GetMapping("/getCells")
	public List<Cell> initialiserCells() {
		return iGameService.initialiserCells();
	}

	@GetMapping("/getNewGame")
	public GameTicTacToe initialiserGame() {
		return iGameService.initialiserGame();
	}

	@GetMapping("/changePlayerTurn")
	public GameTicTacToe changePlayerTurn(@RequestParam(name = "id", required = true) Integer id,
			@RequestParam(name = "state", required = true) String state) {
		Cell squareClicked = new Cell(id, state);
		return iGameService.changePlayerTurn(squareClicked);
	}

	@GetMapping("/getGameOver")
	public boolean isGameOver() {
		return iGameService.isGameOver();
	}

	@GetMapping("/getWinner")
	public boolean isWinner() {
		return iGameService.isWinner();
	}

}
