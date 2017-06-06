package holdem;

public class Holdem {

	public static void main(String[] args) {
		Player p1 = new Player("L");
		Rule rule = new Rule();
		String[] hand = new String[3];
		
		p1.get();
		rule.flopOpen();
		rule.turnOpen();
		rule.riverOpen();
		p1.sum(p1.card, rule.board);
		hand = rule.hands(p1.card);
		p1.determineHands(hand);
	}
}