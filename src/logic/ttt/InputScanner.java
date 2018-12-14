package logic.ttt;
import java.util.Scanner;

public class InputScanner {
	private Scanner input = new Scanner(System.in);
	
	public InputScanner() {
		
	}
	
	public Integer[] validInput(TileMap board){
		Integer[] in = {0, 0};
		while((in[0] < 1 || in[0] > board.getMapRows()) && (in[1] < 1 || in[1] > board.getMapColumns())){
			System.out.println("Select a position");
			System.out.print("Row: ");
			in[0] = input.nextInt();
			System.out.print("Column: ");
			in[1] = input.nextInt();
		}
		return in;
	}
	
	public int positiveIntegerInput()
	{
		String integerInput = "a";
		while(!isNumeric(integerInput)) {
			System.out.println("Please input a positive integer.");
			integerInput = input.nextLine();
		}
	    return Integer.parseInt(integerInput);
	}
	
	private static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) {
	        	return false;
	        }
	    }
	    return true;
	}
	
	public String nameInput() {
		String name = "";
		while(name.isEmpty() || name.length() > 18) {
			System.out.println("Please input a name. (18 characters max)");
			name = input.nextLine();
		}
		return name;
	}
	
	public String symbolInput() {
		String symbol = "";
		while(symbol.isEmpty() || symbol.length() > 1) {
			System.out.println("Please input a player's symbol. (1 character)");
			symbol = input.nextLine();
		}
		return symbol;
	}

}
