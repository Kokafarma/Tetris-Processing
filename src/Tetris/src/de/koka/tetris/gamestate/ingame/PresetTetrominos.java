package de.koka.tetris.gamestate.ingame;

public enum PresetTetrominos {
	I(0,0,0,1,0,-1,0,-2),
	O(0,0,0,1,1,1,1,0),
	T(0,0,-1,0,0,1,1,0),
	J(0,0,0,-1,0,1,-1,1),
	REVERSE_J(0,0,0,-1,0,1,1,1),
	S(0,0,1,0,0,1,-1,1),
	REVERSE_S(0,0,-1,0,0,1,1,1);
	

	int[][] coords;

	private PresetTetrominos(int... coords) {
		this.coords = new int[coords.length/2][2];
		for(int i=0;i<coords.length/2;i++) {
			this.coords[i][0]=coords[i*2];
			this.coords[i][1]=coords[i*2+1];
		}
	}

	public int[][] getCoords() {
		return this.coords;
	}
}
