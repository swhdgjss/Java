package holdem;

import java.util.ArrayList;

public class Player {
	public String name;
	public ArrayList<Integer> hand = new ArrayList<Integer>(8);

	public Player(String name) {
		this.name = name;
	}
}