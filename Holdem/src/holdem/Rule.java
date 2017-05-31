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
	
	public void sort(ArrayList<Tuple> card) {
		card.sort(null);
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
		int[][] c = new int[4][14];
		int x, y;
		
		for(Tuple tmp : card) {
			x = tmp.getX();
			y = tmp.getY();
			c[x][y]++;
		}
		
		for(int j = 1; j <= 14; j++) {
			for(int i = 0; i < 4; i++) {
				if(c[i][j] == 1 && c[i + 1][j] == 1 && c[i + 2][j] == 1 && c[i + 3][j] == 1)
					return true;
			}
		}
		return false;
	}
	
	public boolean fullHouse(ArrayList<Tuple> card) {
		int[][] c = new int[4][14];
		int x, y;
		
		for(Tuple tmp : card) {
			x = tmp.getX();
			y = tmp.getY();
			c[x][y]++;
		}
		
		for(int j = 1; j <= 14; j++) {
			for(int k = 1; k <= 14; k++) {
				for(int i = 0; i < 4; i++) {
					if(c[i][j] == 1 && c[i + 1][j] == 1 && c[i + 2][j] == 1 &&
							c[i][k] == 1 && c[i + 1][k] ==1) return true;
				}
			}
		}
		return false;
	}
	
	public boolean flush(ArrayList<Tuple> card) {
		int[][] c = new int[4][14];
		int x, y;
		
		for(Tuple tmp : card) {
			x = tmp.getX();
			y = tmp.getY();
			c[x][y]++;
		}
		
		for(int i = 0; i < 4; i++) {
			int tmp = 0;
			
			for(int j = 1; j <= 14; j++) {
				if(c[i][j] == 1) tmp++;
			}
			if(tmp >= 5) return true;
		}
		return false;
	}
	
	public boolean straigh(ArrayList<Tuple> card) {
		
		return false;
	}
	
}