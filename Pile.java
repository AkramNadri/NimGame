// Akram Nadri
// Section 310
// Proff. Rosenblum

public class Pile {


	private int size; // The current size of the pile

	public Pile() { // Default constructor
		size = 10;
	}

	public Pile(int size) { //initial constructor
		this.size = size;
	}

	public int getSize() { // get current size of pile
		return size;
	}

	public void remove(int pileAmount) { //remove the amount from pile
		size -= pileAmount;
	}
}

