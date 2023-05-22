package src.com.bj;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

public class SE {
	
	Clip clip;
	
	public void setFile(String soundFileName){
		
		try{
			File file = new File(soundFileName);
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);	
			clip = AudioSystem.getClip();
			clip.open(sound);
		}
		catch(Exception e){
			
		}
	}
	
	public void play(){
		
		clip.setFramePosition(0);
		clip.start();
	}
	public void stop() {
		
		clip.stop();
	}
	public void loop() {
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	
}}


