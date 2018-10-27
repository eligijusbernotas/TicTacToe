import java.util.Scanner;

public class Main {
	private static Scanner input = new Scanner(System.in);
	private static boolean gameOver;
	private static boolean boardIsFull;
	private static boolean playAgain;
	
	public static void main(String[] args) throws Exception {
		do {
		String [][] tileMap = {
				{" ", " ", " "},
				{" ", " ", " "},
				{" ", " ", " "},
		};
		gameOver = false;
		playAgain = false;
		boardIsFull = false;
		draw(tileMap);
		String player = "X";
		runGame(tileMap, player);
		} while (playAgain);
	}

	private static void runGame(String[][] tileMap, String player) {
		while(!gameOver && !boardIsFull) {
			switch(player) {
			case "X":
				System.out.println("\n"
						+ player + " eile\n");
				Integer[] in = validInput();
				while(!tileMap[in[0] - 1][in[1] - 1].equals(" ")) {
					System.out.println("\n"
							+ "Sis laukas uzimtas.\n");
					in = validInput();
				}
				tileMap[in[0] - 1][in[1] - 1] = player;
				clrScrn();
				draw(tileMap);
				gameOver = hasWon(tileMap, gameOver, player);
				boardIsFull = isFull(tileMap);
				if(gameOver || boardIsFull) {
					break;
				}
				player = "O";
				break;
			case "O":
				System.out.println(player + " eile\n");
				Integer[] in1 = validInput();
				while(!tileMap[in1[0] - 1][in1[1] - 1].equals(" ")) {
					System.out.println("Sis laukas uzimtas.");
					in1 = validInput();
				}
				tileMap[in1[0] - 1][in1[1] - 1] = player;
				clrScrn();
				draw(tileMap);
				gameOver = hasWon(tileMap, gameOver, player);
				boardIsFull = isFull(tileMap);
				if(gameOver || boardIsFull) {
					break;
				}
				player = "X";
				break;
			}
			
		}
		System.out.println("");
		System.out.print("Ar norite pakartoti? (y/n): ");
		input.nextLine();
		if(input.nextLine().equals("y")){
			playAgain = true;
		}
	}
	
private static boolean hasWon(String[][] tileMap, boolean gameOver,String player) {
	String winningChars = player + player + player;
	if((tileMap[0][0] + tileMap[0][1] + tileMap[0][2]).equals(winningChars)) {
		System.out.println(player + " laimejo!\n");
		gameOver = true;
	}
	if((tileMap[1][0] + tileMap[1][1] + tileMap[1][2]).equals(winningChars)) {
		System.out.println(player + " laimejo!\n");
		gameOver = true;
	}
	if((tileMap[2][0] + tileMap[2][1] + tileMap[2][2]).equals(winningChars)) {
		System.out.println(player + " laimejo!\n");
		gameOver = true;
	}
	if((tileMap[0][0] + tileMap[1][0] + tileMap[2][0]).equals(winningChars)) {
		System.out.println(player + " laimejo!\n");
		gameOver = true;
	}
	if((tileMap[0][1] + tileMap[1][1] + tileMap[2][1]).equals(winningChars)) {
		System.out.println(player + " laimejo!\n");
		gameOver = true;
	}
	if((tileMap[0][2] + tileMap[1][2] + tileMap[2][2]).equals(winningChars)) {
		System.out.println(player + " laimejo!\n");
		gameOver = true;
	}
	if((tileMap[0][0] + tileMap[1][1] + tileMap[2][2]).equals(winningChars)) {
		System.out.println(player + " laimejo!\n");
		gameOver = true;
	}
	if((tileMap[0][2] + tileMap[1][1] + tileMap[2][0]).equals(winningChars)) {
		System.out.println(player + " laimejo!\n");
		gameOver = true;
	}
	return gameOver;
		
	}

private static void draw(String[][] tileMap) {
		System.out.println(tileMap[0][0] + "|" + tileMap[0][1] + "|" +tileMap[0][2] + "\n"
								+ "- - -\n"
								+ tileMap[1][0] + "|" + tileMap[1][1] + "|" + tileMap[1][2] + "\n"
								+ "- - -\n"
								+ tileMap[2][0] + "|" + tileMap[2][1] + "|" + tileMap[2][2]);
	}
private static Integer[] validInput(){
	Integer[] in = {5, 5};
	while((in[0] < 1 || in[0] > 3) && (in[1] < 1 || in[1] > 3)){
		System.out.println("Iveskite kordinates");
		System.out.print("Eilute: ");
		in[0] = input.nextInt();
		System.out.print("Stulpelis: ");
		in[1] = input.nextInt();
	}
	return in;
}
private static void clrScrn() {
	for(int i = 0; i <= 50; i++)
		System.out.println("");
}
private static boolean isFull(String[][] tileMap) {
	int tempCount = 0;
	for(int i = 0; i <= 2; i++) {
		for(int j = 0; j <= 2; j++) {
			if(tileMap[i][j].equals(" ")) {
		} else {
			tempCount++;
		}
		}
	}
	if(tempCount == 9) {
		System.out.println("\n"
				+ "Zaidimo lenta pilna!");
		return true;
	}else {
	return false;
	}
}
}
