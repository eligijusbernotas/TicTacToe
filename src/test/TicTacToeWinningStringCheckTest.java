package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.ttt.Player;
import logic.ttt.TicTacToe;

class TicTacToeWinningStringCheckTest {

	@Test
	public void test() {
		TicTacToe tester1 = new TicTacToe(4);
		TicTacToe tester2 = new TicTacToe(3);
		TicTacToe tester3 = new TicTacToe(5);
		Player testerPlayer = new Player("X");
		
		assertEquals(true, tester1.checkWinningString("XXXX", testerPlayer), "X symbol's winning string bust be XXXX in a 4x4 board.");
		assertEquals(false, tester2.checkWinningString("XX ", testerPlayer), "X symbol's winning string bust be XXX in a 3x3 board.");
		assertEquals(false, tester3.checkWinningString("XX XX", testerPlayer), "X symbol's winning string bust be XXXXX in a 5x5 board.");
		assertEquals(true, tester3.checkWinningString("XXXXX", testerPlayer), "X symbol's winning string bust be XXXXX in a 5x5 board.");
		assertEquals(true, tester2.checkWinningString("XXX", testerPlayer), "X symbol's winning string bust be XXX in a 3x3 board.");
		assertEquals(false, tester2.checkWinningString("XOX", testerPlayer), "X symbol's winning string bust be XXX in a 3x3 board.");
		assertEquals(false, tester2.checkWinningString("XOO", testerPlayer), "X symbol's winning string bust be XXX in a 3x3 board.");
	}

}
