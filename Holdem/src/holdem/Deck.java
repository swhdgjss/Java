package holdem;

public class Deck {
	public int[][] deck = new int[4][14];
	
	public boolean determine(int x, int y) {
		if(deck[x][y] == 1) {
			return false;
		} else {
			return true;
		}
	}
	
	public void use(int x, int y) {
		deck[x][y]++;
	}
	
	public void clear() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 14; j++) {
				deck[i][j] = 0;
			}
		}
	}
}