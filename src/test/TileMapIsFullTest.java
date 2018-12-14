package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.ttt.TileMap;

class TileMapIsFullTest {

	@Test
	void test() {
		TileMap testMap1 = new TileMap(3);
		TileMap testMap2 = new TileMap(4);
		TileMap testMap3 = new TileMap(10);
		
		fillMapFull(testMap1);
		fillMapFull(testMap2);
		fillMapFull(testMap3);
		
		assertEquals(true, testMap1.isFull(), "A map full of symbols must be recognised as full");
		assertEquals(true, testMap2.isFull(), "A map full of symbols must be recognised as full");
		assertEquals(true, testMap3.isFull(), "A map full of symbols must be recognised as full");
		
		fillMapNotFull(testMap1);
		fillMapNotFull(testMap2);
		fillMapNotFull(testMap3);
		
		assertEquals(false, testMap1.isFull(), "A map partialy full of symbols must be recognised as not full");
		assertEquals(false, testMap2.isFull(), "A map partialy full of symbols must be recognised as not full");
		assertEquals(false, testMap3.isFull(), "A map partialy full of symbols must be recognised as not full");
		
		
		
	}
	
	public void fillMapFull(TileMap map) {
		String[][] temp = new String[map.getMapColumns()][map.getMapRows()];
		for(int i = 0; i < map.getMapRows(); i++) {
			for(int j = 0; j < map.getMapRows(); j++) {
				temp[i][j] = "X";
			}
		}
		map.setTileMap(temp);
	}
		
		public void fillMapNotFull(TileMap map) {
			String[][] temp = new String[map.getMapColumns()][map.getMapRows()];
			for(int i = 0; i < map.getMapRows(); i++) {
				for(int j = 0; j < map.getMapRows(); j++) {
					if(i == 0) {
						temp[i][j] = " ";
					}
					else {
						temp[i][j] = "X";
					}
				}
			}
		
		map.setTileMap(temp);
	}

}
