package logic.ttt;

public class HumanPlayer extends Player {
	private String name;

	public HumanPlayer(String symbol, String name) {
		super(symbol);
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


}
