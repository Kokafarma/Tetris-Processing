package de.koka.tetris;

import java.util.Arrays;

import de.koka.tetris.gamestate.Gamestate;
import de.koka.tetris.gamestate.ingame.IngameState;
import de.koka.tetris.gamestate.ingame.PresetTetrominos;
import de.koka.tetris.gamestate.ingame.Tetromino;
import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		main(Main.class);
	}

	//TODO
	public static void printArr(int[][] arr) {
		System.out.println("\n");
		for(int i=0;i<arr.length;i++) {
			for(int x =0;x<arr[i].length;x++)
				System.out.print("\t"+arr[i][x]+"\t");
			System.out.println();
		}
	}
	
	// Reference to the main
	private static Main instance;

	// Game-state
	private Gamestate state;

	// Game-name
	private static final String GAME_NAME = "Tetris";

	//Resize-tester
	int preX,preY;
	
	public Main() {
		instance = this;
	}

	@Override
	public void settings() {
		size(500, 500);
	}

	@Override
	public void setup() {
		surface.setResizable(true);
		stroke(255);
		// Opens the default game-state
		this.openGamestate(new IngameState());
	}

	@Override
	public void mousePressed() {
		this.state.handleMousePressed();
	}

	@Override
	public void mouseReleased() {
		this.state.handleMouseReleased();
	}

	@Override
	public void keyPressed() {
		this.state.handleKeyPressed();
	}

	@Override
	public void keyReleased() {
		this.state.handleKeyReleased();
	}

	@Override
	public void draw() {
		//Resize check
		if(preX!=width || preY != height)
			this.state.handleResize(preX=width, preY=height);
		
		
		this.state.handleRender();
	}

	/**
	 * Opens the given game-state and closes the previous
	 * 
	 * @param state
	 */
	public void openGamestate(Gamestate state) {
		// Closes the previous state
		if (this.state != null)
			this.state.handleClose();

		// Opens the new state
		this.state = state;
		this.state.handleInit();

		//Sends the size event
		this.state.handleResize(width, height);
		
		// Updates the title
		this.surface.setTitle(GAME_NAME + " | " + this.state.getName());
	}

	public static Main getInstance() {
		return instance;
	}
}
