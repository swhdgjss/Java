package holdem;

import java.util.Scanner;

public class Holdem {

	public static void main(String[] args) {
		Player p1 = new Player("L");
		Rule rule = new Rule();
		Scanner s = new Scanner(System.in);
		String[] hand = new String[3];
		int replay = 0;
		
		do {
		p1.get();
		rule.flopOpen();
		rule.turnOpen();
		rule.riverOpen();
		p1.sum(p1.card, rule.board);
		hand = rule.hands(p1.card);
		p1.determineHands(hand);
		System.out.print("다시하고 싶으면 1을 입력해주세요");
		replay = s.nextInt();
		if(replay == 1) {
			p1.clear();
			rule.clear();
		}
		} while(replay == 1);
	}
}