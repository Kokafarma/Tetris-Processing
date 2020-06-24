package de.koka.tetris.gamestate;

import de.koka.tetris.Main;
import de.whiletrue.processingguiengine.GuiEngine;
import processing.core.PApplet;

public abstract class Gamestate {
	
	//Reference to the main app
	protected PApplet app = Main.getInstance();
	
	//GUI-engine instance
	protected GuiEngine engine = new GuiEngine(this.app);
	
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
	public void handleInit() {}
	public void handleClose() {}
	
	public void handleResize(int width,int height) {}
	
	public String getName() {
		return this.name;
	}
	
}
