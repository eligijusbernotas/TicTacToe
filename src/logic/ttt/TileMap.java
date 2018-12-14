package logic.ttt;

public class TileMap {
	private int mapRows;
	private int mapColumns;
	private String[][] tileMap;

	public TileMap(int dimensions) {
		this.mapRows = dimensions;
		this.mapColumns = dimensions;
		this.tileMap = new String[dimensions][dimensions];
		for (int i = 0; i < dimensions; i++) {
			for (int j = 0; j < dimensions; j++) {
				this.tileMap[i][j] = " ";
			}
		}
	}

	public int getMapRows() {
		return mapRows;
	}

	public void setMapRows(int mapRows) {
		this.mapRows = mapRows;
	}

	public int getMapColumns() {
		return mapColumns;
	}

	public void setMapColumns(int mapColumns) {
		this.mapColumns = mapColumns;
	}

	public String[][] getTileMap() {
		return tileMap;
	}

	public void setTileMap(String[][] tileMap) {
		this.tileMap = tileMap;
	}

	public void addToMap(int row, int column, Player player) {
		tileMap[row][column] = player.getPlayerSymbol();

	}

	public boolean isFull() {
		int tempCount = 0;
		for (int i = 0; i < mapRows; i++) {
			for (int j = 0; j < mapColumns; j++) {
				if (tileMap[i][j].equals(" ")) {
				} else {
					tempCount++;
				}
			}
		}
		if (tempCount == mapRows * mapColumns) {
			return true;
		} else {
			return false;
		}
	}

}
