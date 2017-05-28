package holdem;

import java.util.ArrayList;
import java.util.Random;

public class Rule extends Card{
	public ArrayList<Tuple> Community = new ArrayList<Tuple>(6);
	public Random random = new Random();
	public Card card = new Card();
	
	public Tuple deal() {
		boolean check = true;
		int x, y;

		do {
			x = random.nextInt(4);
			y = random.nextInt(13) + 1;
			check = card.determine(x, y);
		} while(check == false);
		card.use(x, y);
		Tuple t = new Tuple(x, y);
		
		return t;
	}


}
