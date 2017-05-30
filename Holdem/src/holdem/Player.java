package holdem;

import java.util.ArrayList;

public class Player extends Rule{
	public String name;
	public ArrayList<Tuple> card;

	public Player(String name) {
		this.name = name;
		card = new ArrayList<Tuple>(8);
	}
}