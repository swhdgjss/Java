package holdem;

import java.util.ArrayList;
import java.util.Random;

public class Rule{
	public ArrayList<Tuple> board = new ArrayList<Tuple>(6);
	public Random random = new Random();
	public Deck deck = new Deck();
	
	public Tuple deal() {
		boolean check = true;
		int x, y;

		do {
			x = random.nextInt(4);
			y = random.nextInt(13) + 1;
			check = deck.determine(x, y);
		} while(check == false);
		deck.use(x, y);
		Tuple t = new Tuple(x, y);
		
		return t;
	}
	
	public void flop() {
		Tuple tmp;
		
		for(int i = 0; i < 3; i++) {
			tmp = this.deal();
			board.add(tmp);
		}
	}
	
	public void turn() {
		Tuple tmp;
		
		tmp = this.deal();
		board.add(tmp);
	}
	
	public void river() {
		Tuple tmp;
		
		tmp = this.deal();
		board.add(tmp);
	}
	
	public boolean royalStraightFlush(ArrayList<Tuple> card) {
		int[][] c = new int[4][14];
		int x, y;
		
		for(Tuple tmp : card) {
			x = tmp.getX();
			y = tmp.getY();
			c[x][y]++;
		}
		
		for(int i = 0; i < 4; i++) {
			if(c[i][10] == 1 && c[i][11] == 1 && c[i][12] == 1 && c[i][13] == 1 && c[i][14] == 1) return true;
			else if(c[i][2] == 1 && c[i][3] == 1 && c[i][4] == 1 && c[i][5] == 1 && c[i][14] == 1) return true;	
		}
		return false;
	}
	
	public boolean straighFlush(ArrayList<Tuple> card) {
		int[][] c = new int[4][14];
		int x, y;
		
		for(Tuple tmp : card) {
			x = tmp.getX();
			y = tmp.getY();
			c[x][y]++;
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 10; i++) {
				if(c[i][j] == 1 && c[i][j + 1] == 1 && c[i][j + 2] == 1 && c[i][j + 3] == 1 && c[i][j + 4] == 1) 
					return true;
				else if(c[i][2] == 1 && c[i][3] == 1 && c[i][4] == 1 && c[i][5] == 1 && c[i][14] == 1) return true;
			}
		}
		return false;
	}
	
	public boolean fourCard(ArrayList<Tuple> card) {
		int[] c = new int[14];
		int y;
		
		for(Tuple tmp : card) {
			y = tmp.getY();
			c[y]++;
		}
		
		for(int i = 1; i <= 14; i++) {
			if(c[i] == 4)
			return true;
		}
		return false;
	}
	
	public boolean fullHouse(ArrayList<Tuple> card) {
		int[] c = new int[14];
		int y;
		
		for(Tuple tmp : card) {
			y = tmp.getY();
			c[y]++;
		}
		
		for(int i = 1; i <= 14; i++) {
			for(int j = 1; j <= 14; j++) {
				if(c[i] == 3 && c[j] == 2) return true;
			}
		}
		return false;
	}
	
	public boolean flush(ArrayList<Tuple> card) {
		int[] c = new int[4];
		int x;
		
		for(Tuple tmp : card) {
			x = tmp.getX();
			c[x]++;
		}
		
		for(int i = 0; i < 4; i++) {
			if(c[i] >= 5) return true;
		}
		return false;
	}
	
	public boolean straight(ArrayList<Tuple> card) {
		int[] c = new int[14];
		int y;
		
		for(Tuple tmp : card) {
			y = tmp.getY();
			c[y]++;
		}
		
		for(int i = 1; i <= 11; i++) {
			if(c[i] == 1 && c[i + 1] == 1 && c[i + 2] == 1 && c[i + 3] == 1 && c[i + 4] == 1)
				return true;
			else if(c[2] == 1 && c[3] == 1 && c[4] == 1 && c[5] == 1 && c[14] == 1)
				return true;
		}
		return false;
	}
	
	public boolean triple(ArrayList<Tuple> card) {
		int[] c = new int[14];
		int y;
		
		for(Tuple tmp : card) {
			y = tmp.getY();
			c[y]++;
		}
		
		for(int i = 1; i <= 14; i++) {
				if(c[i] == 3) return true;
		}
		return false;
	}
	
	public boolean twoPair(ArrayList<Tuple> card) {
		int[][] c = new int[4][14];
		int x, y;
		
		for(Tuple tmp : card) {
			x = tmp.getX();
			y = tmp.getY();
			c[x][y]++;
		}
		
		for(int j = 1; j <= 14; j++) {
			int tmp = 0;
			int tmp2 = 0;
			
			for(int i = 0; i < 4; i++) {
				if(c[i][j] == 1) tmp++;
			}
			
			for(int i = 0; i < 4; i++) {
				if(c[i][14 - j] == 1) tmp2++;
			}
			
			if(tmp == 2 && tmp2 == 2) return true;
		}
		return false;
	}
	
	public boolean onePair(ArrayList<Tuple> card) {
		int[][] c = new int[4][14];
		int x, y;
		
		for(Tuple tmp : card) {
			x = tmp.getX();
			y = tmp.getY();
			c[x][y]++;
		}
		
		for(int j = 1; j <= 14; j++) {
			int tmp = 0;
			
			for(int i = 0; i < 4; i++) {
				if(c[i][j] == 1) tmp++;
			}
			if(tmp == 2) return true;
		}
		return false;
	}
}