package de.koka.tetris.util;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import de.koka.tetris.Main;

public class MusicPlayer {

	//Reference to the sound-lib
	private Minim minim;
	
	//Audio-file player
	private AudioPlayer player;
	
	//If the file could be loaded
	private boolean loaded;
	
	public MusicPlayer(String file) {
		//Gets the lib
		this.minim=new Minim(Main.getInstance());
		
		//Tries to load the file
		try {
			//Loads the music-file
			this.player=this.minim.loadFile(file);
			this.player.pause();
			
			//Loaded the file successfully
			this.loaded=true;
		}catch(Exception e) {
			this.loaded=false;
		}
	}
	
	/**
	 * Starts the track if it is loaded
	 */
	public void start() {
		//Checks if the track is loaded
		if(this.isLoaded())
			//Starts it
			this.player.loop();
	}
	
	/**
	 * Stops the track if it was loaded
	 */
	public void stop() {
		//Checks if the track is loaded
		if(this.isLoaded())
			//Stops it
			this.player.pause();
	}
	
	/**
	 * Sets the volume of the track
	 * @param volume the volume to set (Percentage value from 0.00 to 1.00)
	 */
	public void setVolume(float volume) {
		//Range to set the volume
		float min = -30;
		
		//Gets the actual value through the clamp function (Value between 0 to 1)
		volume=Math.min(1, Math.max(0, volume));
		
		//Checks if the track is loaded
		if(this.isLoaded())
			//Sets the volume
			this.player.setGain((1-volume)*min);
	}
	
	public boolean isLoaded() {
		return this.loaded;
	}
}
