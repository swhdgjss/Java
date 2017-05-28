package holdem;

import java.util.ArrayList;

public class Player extends Rule{
	public String name;
	public ArrayList<Tuple> hand;

	public Player(String name) {
		this.name = name;
		hand = new ArrayList<Tuple>(8);
	}
}