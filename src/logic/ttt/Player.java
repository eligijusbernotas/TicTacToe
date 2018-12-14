package logic.ttt;

public class Player {
	private String playerSymbol;
	private int winsCount = 0;
	
	public int getWinsCount() {
		return winsCount;
	}

	public void setWinsCount(int winsCount) {
		this.winsCount = winsCount;
	}

	public Player(String symbol) {
		this.playerSymbol = symbol;
	}

	public String getPlayerSymbol() {
		return playerSymbol;
	}

	public void setPlayerSymbol(String playerSymbol) {
		this.playerSymbol = playerSymbol;
	}

}
