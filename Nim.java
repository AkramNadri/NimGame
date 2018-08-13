// Akram Nadri
// Section 310
// Proff. Rosenblum


import java.util.Random;
import java.util.Scanner;

public class Nim {

	private Pile pileA; //first pile
	private Pile pileB; //second pile
	private Pile pileC; //third pile
	private Random rnd = new Random(); //random number generator
	private Scanner input = new Scanner(System.in); //scanner for all user input


	public Nim() { //default constructor //constructs 3 piles
		this.pileA = new Pile();
		this.pileB = new Pile();
		this.pileC = new Pile();

	}

	public boolean PlayerMove() { //All the rules to handle user input
		System.out.print("Select a pile: "); //prompts user to select pile
		String pile = input.next();

		switch (pile) {
		case "a":
		case "A":
			if (pileA.getSize() == 0) {
				System.out.println("Pile A is empty, pick another");
				printPiles();
				return false;
			}else
				break;

		case "b":
		case "B":
			if (pileB.getSize() == 0) {
				System.out.println("Pile B is empty, pick another");
				printPiles();
				return false;
			}else
				break;

		case "c":
		case "C":
			if (pileC.getSize() == 0) {
				System.out.println("Pile C is empty, pick another");
				printPiles();
				return false;
			} else
				break;

		default:
			System.out.println("Invalid pile letter, pick a, b or c");
			printPiles();
			return false;
		}

		System.out.print("How many do you want to remove? ");
		int amount1 = input.nextInt();

		if (pile.toLowerCase().equals("a")) {
			if (amount1 <= 0 || amount1 > pileA.getSize()) {
				System.out.println("Pick a number between 1 and "+pileA.getSize());
				printPiles();
				return false;

			} pileA.remove(amount1);
		}

		if (pile.toLowerCase().equals("b")) {
			while (amount1 <= 0 || amount1 > pileB.getSize()) {
				System.out.println("Pick a number between 1 and "+pileB.getSize());
				printPiles();
				return false;

			} pileB.remove(amount1);
		}

		if (pile.toLowerCase().equals("c")) {
			while (amount1 <= 0 || amount1 > pileC.getSize()) {
				System.out.println("Pick a number between 1 and "+pileC.getSize());
				printPiles();
				return false;				

			} pileC.remove(amount1);
		}

		if (done() == true) {
			System.out.println("Sorry: you lose");
		} 		else printPiles();

		return true; // ?? to be changed... 

	}

	public void computerRandomMove() { //computer move if done randomly
		int pile =  rnd.nextInt(3) +1; //computer selects random pile from 1-3
		int amountPicked = 0;
		boolean flag = true;

		while (flag) {
			if (pile == 1 && pileA.getSize() == 0) {
				pile =  rnd.nextInt(3) +1;

			}
			else if (pile == 2 && pileB.getSize() == 0) {
				pile =  rnd.nextInt(3) +1;

			}
			else if (pile == 3 && pileC.getSize() == 0) {
				pile =  rnd.nextInt(3) +1;

			}else flag = false;
		}

		switch (pile){ 

		case 1:{
			amountPicked = rnd.nextInt(pileA.getSize())+1; //computer random pick from pile A
			pileA.remove(amountPicked);
			System.out.println("Computer takes " +amountPicked+ " from pile A");
			break;
		}

		case 2:{ 
			amountPicked = rnd.nextInt(pileB.getSize())+1; //computer random pick from pile B
			pileB.remove(amountPicked);
			System.out.println("Computer takes " +amountPicked+ " from pile B"); 
			break;
		}

		case 3:{
			amountPicked = rnd.nextInt(pileC.getSize())+1; //computer random pick from pile C
			pileC.remove(amountPicked); // removes random amount from pile 
			System.out.println("Computer takes " +amountPicked+ " from pile C"); //print out of amount removed from pile by computer
			break;
		}

		}

		if (done() == true) {
			System.out.println("Congrats: you win ");
		}
		else printPiles();
	}

	public boolean done() { //is the game done ?

		boolean gameOverMan = false;
		if (pileA.getSize() == 0 && pileB.getSize() == 0 && pileC.getSize() == 0)  gameOverMan = true; // game over piles == 0.
		//if (pileA.getSize() > 0 || pileB.getSize() > 0 || pileC.getSize() > 0) gameOverMan = false; // game continues piles > 0.

		return gameOverMan; // gameOver when all piles = 0

	}

	public void computerMove() { //All rules to handle computer

	}

	public void printPiles() { //Print the current state of the piles
		System.out.println("	A         B        C");
		System.out.println("	"+pileA.getSize()+"        "+pileB.getSize()+"       "+pileC.getSize()+"\n");
	}
}

