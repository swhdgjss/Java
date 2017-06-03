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
		String[] hand = new String[3];
		
		card.addAll(board);
		hand = hands(card);
		
		switch(hand[0]) {
		case "Royal Straigh Flush":
			break;
		case "Straight Flush":
			break;
		case "Four Card":
			break;
		case "Full House":
			break;
		case "Flush":
			break;
		case "Straight":
			break;
		case "Triple":
			break;
		case "Two Pair":
			break;
		case "One Pair":
			break;
		default:
			
		}
	}
}