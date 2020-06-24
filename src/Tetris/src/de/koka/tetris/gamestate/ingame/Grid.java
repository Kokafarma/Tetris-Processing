package de.koka.tetris.gamestate.ingame;

import java.awt.Color;

import de.koka.tetris.Main;

public class Grid {
	// holds size of 1 block of the grid
	int sizeX;
	int sizeY;
	int[][] grid;
	
	Main app = Main.getInstance();
	
	// Constructor
	Grid(int width, int height) {
		grid = new int[width][height];
		
		//TODO
		grid[2][4] = Color.cyan.getRGB();
	}

	void updateSize(int width, int height) {
		sizeX = width;
		sizeY = height;
	}

	// Method
	void renderGrid(int x,int y){
		// Gesamtweite grid
		int fW = sizeX * grid.length;
		int fH = sizeY * grid[0].length;
		
		// Startposition grid
		int sX = x-fW/2;
		int sY = y-fH/2;
		
		app.rect(sX,sY,fW,fH);
		
		for(int i = 0; i<grid.length ; i++) {
			for(int j = 0; j<grid[0].length; j++) {
				app.fill(grid[i][j]);
				app.rect(sX+i*sizeX,sY+j*sizeY,sizeX,sizeY);
			}
		}
		
		
		
	}
	int getWidth() {
		return grid.length;
	}
	int getHeigth() {
		return grid[0].length;
	}

}