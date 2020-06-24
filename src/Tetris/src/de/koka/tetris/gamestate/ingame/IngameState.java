package de.koka.tetris.gamestate.ingame;

import de.koka.tetris.gamestate.Gamestate;

public class IngameState extends Gamestate {
	
	Grid grid = new Grid(10, 16);
	
	//current tetromino that the player controls
	Tetromino curr;
	
	public IngameState() {
		super("Ingame");
	}

	@Override
	public void handleInit() {
		super.handleInit();
	}

	@Override
	public void handleResize(int width, int height) {
		int size = Math.min((width - 20) / grid.getWidth(), height / grid.getHeigth());

		grid.updateSize(size, size);

	}


	@Override
	public void handleRender() {
		grid.renderGrid(app.width / 2, app.height / 2);
		super.handleRender();
	}

}
