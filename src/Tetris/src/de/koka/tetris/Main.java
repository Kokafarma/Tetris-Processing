package de.koka.tetris;

import de.koka.tetris.gamestate.Gamestate;
import de.koka.tetris.gamestate.gamescreen.IngameState;
import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		main(Main.class);
	}

	// Reference to the main
	private static Main instance;

	// Game-state
	private Gamestate state;

	// Game-name
	private static final String GAME_NAME = "Tetris";

	public Main() {
		instance = this;
	}

	@Override
	public void settings() {
		size(500, 500);
	}

	@Override
	public void setup() {
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
