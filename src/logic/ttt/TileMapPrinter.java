package logic.ttt;

public class TileMapPrinter {
	private String wallSymbol = "|";
	private String floorSymbol = "-";
	
	public TileMapPrinter() {
		
	}
	
	public String getWallSymbol() {
		return wallSymbol;
	}

	public void setWallSymbol(String wallSymbol) {
		this.wallSymbol = wallSymbol;
	}

	public String getFloorSymbol() {
		return floorSymbol;
	}

	public void setFloorSymbol(String floorSymbol) {
		this.floorSymbol = floorSymbol;
	}

	public void printMap(TileMap board) {
		for(int i = 0; i < board.getMapRows(); i++) {
			for(int j = 0; j < board.getMapColumns(); j++) {
				System.out.print(board.getTileMap()[i][j]);
				
				if(j != board.getMapColumns() - 1) {
					System.out.print(wallSymbol);
				}
				if(j == board.getMapColumns() - 1 && i != board.getMapRows() - 1) {
					System.out.println();
					printMapFloor(board);
					System.out.println();
				}
			}
		}
		System.out.println();
		System.out.println();
		
	}
	
	private void printMapFloor(TileMap board) {
		for(int i = 0; i < board.getMapColumns(); i++) {
			System.out.print(floorSymbol);
			if(i != board.getMapColumns() - 1) {
				System.out.print(" ");
			}
		}
	}

}
