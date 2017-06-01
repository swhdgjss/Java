package holdem;

import java.util.ArrayList;

public class Player extends Rule{
	public String name;
	public ArrayList<Tuple> card;

	public Player(String name) {
		this.name = name;
		card = new ArrayList<Tuple>(8);
	}
	
	public void get() {
		Tuple tmp;
		
		tmp = this.deal();
		card.add(tmp);
		tmp = this.deal();
		card.add(tmp);
	}
	
	public void clear() {
		card.clear();
	}
	
	public void determineHands() {
		card.addAll(board);
	}
}