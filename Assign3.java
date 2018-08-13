

public class Assign3 {

	public static void main (String [] args) {
		boolean nextMove = false;

		// boolean lastMove = true; //boolean to check last move for who wins or loses.
		Nim get = new Nim();

		System.out.println("Welcome to the NIM game\n"
				+ "We play by the misère rules");

		get.printPiles();

		while(get.done() == false) {
			nextMove = get.PlayerMove();
			if (nextMove == true) get.computerRandomMove();
		}

		
	}
}
