package de.koka.tetris.gamestate.ingame;

import java.util.concurrent.ThreadLocalRandom;

public class Tetromino {
	int[][] coords;
	int x, y;
	int rgb;

	public Tetromino(PresetTetrominos preset) {

		coords = preset.getCoords();

	}

	public void rotate() {
		double rot = Math.toRadians(90);
		double sin = Math.sin(rot);
		double cos = Math.cos(rot);
		for (int i = 0; i < coords.length; i++) {
			int tX = coords[i][0];
			int tY = coords[i][1];
			coords[i][0] = (int) Math.round(tX * cos - tY * sin);
			coords[i][1] = (int) Math.round(tX * sin - tY * cos);
		}

	}

	public int[][] getCoords() {
		return coords;
	}

	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	static Tetromino genRdmTetro() {
		ThreadLocalRandom.current().nextInt(0,8);
		PresetTetrominos.values();
		
	}

}
