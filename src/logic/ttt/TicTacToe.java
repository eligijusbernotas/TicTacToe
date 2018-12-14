package logic.ttt;

public class TicTacToe {
	private TileMap board;
	private boolean isGameOver = false;
	private TileMapPrinter printer = new TileMapPrinter(); 
	private InputScanner input = new InputScanner();
	
	public TicTacToe(int dimensions) {
		this.board = new TileMap(dimensions);
	}
	
	public TileMap getBoard() {
		return board;
	}

	public void setBoard(TileMap board) {
		this.board = board;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

	public void playTurn(HumanPlayer player) {
		if (board.isFull()) {
			System.out.println("The board is full, tie!");
			isGameOver = true;
			return;
		}
		clearScreen();
		System.out.println("\n" + player.getName() + "'s turn\n");
		printer.printMap(board);
		Integer[] in = input.validInput(board);
		while(!board.getTileMap()[in[0] - 1][in[1] - 1].equals(" ")) {
			System.out.println("\n"
					+ "This position is taken.\n");
			in = input.validInput(board);
		}
		board.addToMap(in[0] - 1, in[1] - 1, player);;
		clearScreen();
		printer.printMap(board);
		if (hasWon(player)) {
			isGameOver = true;
			player.setWinsCount(player.getWinsCount() + 1);
			System.out.println(player.getName() + " won!");
		}
	}
		

	public boolean hasWon(Player player) {
		String row = "";
		String column = "";
		String diagnalLeft = "";
		String diagnalRight = "";
		
		for(int i = 0; i < board.getMapRows(); i++) {
			for(int j = 0; j < board.getMapColumns(); j++) {
				row += board.getTileMap()[i][j];
				column += board.getTileMap()[j][i];
				
				if(i == j) {
					diagnalLeft += board.getTileMap()[i][j];
				}
				
				if(i + j == board.getMapColumns() - 1) {
					diagnalRight += board.getTileMap()[i][j];
				}
				
				if(row.length() == board.getMapColumns()) {
					if(checkWinningString(row, player)) {
						return true;
					}
					else {
						row = "";
					}
				}
				
				if(column.length() == board.getMapColumns()) {
					if(checkWinningString(column, player)) {
						return true;
					}
					else {
						column = "";
					}
				}
				
				if(diagnalLeft.length() == board.getMapColumns()) {
					if(checkWinningString(diagnalLeft, player)) {
						return true;
					}
				}
				if(diagnalRight.length() == board.getMapColumns()) {
					if(checkWinningString(diagnalRight, player)) {
						return true;
					}
				}
				
				
			}
		}
		return false;
		
			
		}
	
	private void clearScreen() {
		for(int i = 0; i <= 50; i++)
			System.out.println("");
	}
	
	public boolean checkWinningString(String string, Player player) {
		String winningString = "";
		for(int i = 0; i < board.getMapColumns(); i++) {
			winningString += player.getPlayerSymbol();
		}
		if(string.equals(winningString)){
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
}
