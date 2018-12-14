package runner;
import java.util.ArrayList;
import java.util.Scanner;

import logic.ttt.HumanPlayer;
import logic.ttt.InputScanner;
import logic.ttt.TicTacToe;

public class GameRunner {
	private HumanPlayer player1 = new HumanPlayer("X", "Player 1");
	private HumanPlayer player2 = new HumanPlayer("O", "Player 2");
	private TicTacToe game;
	private Scanner input = new Scanner(System.in);
	private InputScanner scanner = new InputScanner();

	public GameRunner() {
	}

	public InputScanner getScanner() {
		return scanner;
	}

	public HumanPlayer getPlayer1() {
		return player1;
	}

	public void setPlayer1(HumanPlayer player1) {
		this.player1 = player1;
	}

	public HumanPlayer getPlayer2() {
		return player2;
	}

	public void setPlayer2(HumanPlayer player2) {
		this.player2 = player2;
	}

	public TicTacToe getGame() {
		return game;
	}

	public void setGame(TicTacToe game) {
		this.game = game;
	}

	public static void main(String[] args) throws Exception {
		Scanner inputTmp = new Scanner(System.in);
		GameRunner runner = new GameRunner();
		String inputString = "";
		while (!inputString.equals("q")) {
			clearScreen();
			System.out.println("___  ___ _____ _   _ _   _ \r\n"
					+ "|  \\/  ||  ___| \\ | | | | |\r\n"
					+ "| .  . || |__ |  \\| | | | |\r\n" 
					+ "| |\\/| ||  __|| . ` | | | |\r\n"
					+ "| |  | || |___| |\\  | |_| |\r\n" 
					+ "\\_|  |_/\\____/\\_| \\_/\\___/ \r\n"
					+ "                           \r\n"
					+ "                           ");
			System.out.println("1 - TicTacToe\n"
					+ "2 - Player settings\n"
					+ "q - Quit\n");
			inputString = inputTmp.nextLine();
			switch (inputString) {
			case "1":
				System.out.print("TicTacToe board's dimension, cannot be 1 (3 - 3x3, 4 - 4x4, etc.): ");
				int dimensions = runner.getScanner().positiveIntegerInput();
				while(dimensions == 1) {
					System.out.println("Board's dimension cannot be 1.");
					dimensions = runner.getScanner().positiveIntegerInput();
				}
				do {
					runner.setGame(new TicTacToe(dimensions));
					runner.run();
				} while (runner.playAgain());
				runner.resetWins();
				break;
			case "2":
				runner.playerSettings();
				break;
			case "q":
				inputTmp.close();
				System.exit(2);
				break;
			default:
				System.out.println("Please choose one of the listed options.");
				break;
			}
		}
	}

	public void run() {
		ArrayList<HumanPlayer> players = new ArrayList<HumanPlayer>();
		players.add(player1);
		players.add(player2);
		while (!game.isGameOver()) {
			for (HumanPlayer p : players) {
				game.playTurn(p);
				if (game.isGameOver()) {
					break;
				}
			}
		}

		System.out.println("");
		System.out.println(player1.getWinsCount() + ":" + player2.getWinsCount());
	}

	public boolean playAgain() {
		System.out.print("Rematch? (y/n): ");
		String inputString = input.nextLine();
		while (true) {
			if (inputString.equals("y")) {
				return true;
			} else if (inputString.equals("n")) {
				return false;
			} else {
				System.out.println("Please choose y/n\n" + "y - rematch\n" + "n - go back to main menu\n");
				inputString = input.nextLine();
			}
		}
	}
	
	public void playerSettings() {
		String inputSettings = "";
		while (!inputSettings.equals("q")) {
			clearScreen();
			System.out.println("Player settings\n"
					+ "\n"
					+ "1 - Change player 1 name\n"
					+ "2 - Change player 1 symbol\n"
					+ "3 - Change player 2 name\n" + "4 - Change player 2 symbol\n"
					+ "q - Back to main menu\n");
			inputSettings = input.nextLine();
			switch (inputSettings) {
			case "1":
				player1.setName(scanner.nameInput());
				break;
			case "2":
				player1.setPlayerSymbol(scanner.symbolInput());
				break;
			case "3":
				player2.setName(scanner.nameInput());
				break;
			case "4":
				player2.setPlayerSymbol(scanner.symbolInput());
				break;
			case "q":
				break;
			default:
				System.out.println("Please choose one of the listed options.");
				break;
			}
		}
	}
	
	private static void clearScreen() {
		for(int i = 0; i <= 50; i++)
			System.out.println("");
	}
	
	private void resetWins() {
		player1.setWinsCount(0);
		player2.setWinsCount(0);
	}

}