package de.koka.tetris.gamestate.gamescreen;

public class Grid {
	int sizeX;
	int sizeY;
	int[][] grid;
	
	Grid(int width,int height){
		grid = new int[width][height];
	}
	void updateSize(int width,int height) {
		sizeX = width;
		sizeY = height;
	}
}