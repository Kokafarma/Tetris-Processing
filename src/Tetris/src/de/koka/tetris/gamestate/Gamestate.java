package de.koka.tetris.gamestate;

import de.koka.tetris.Main;
import de.whiletrue.processingguiengine.GuiEngine;

public abstract class Gamestate {
	
	//GUI-engine instance
	private GuiEngine engine = new GuiEngine(Main.getInstance());
	
	//Game-state name
	private String name;
	
	public Gamestate(String name) {
		this.name=name;
	}
	
	public void handleMousePressed() {
		this.engine.mousePressed();
	}
	public void handleMouseReleased() {
		this.engine.mouseReleased();
	}
	public void handleKeyPressed() {
		this.engine.keyPressed();
	}
	public void handleKeyReleased() {
		this.engine.keyReleased();
	}
	public void handleRender() {
		this.engine.draw();
	}
	public void handleInit() {
		//Sets the name
		Main.getInstance().getSurface().setTitle("");
	}
	public void handleClose() {}
	
	public String getName() {
		return this.name;
	}
	
}
