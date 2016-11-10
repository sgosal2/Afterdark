package menus;

// Settings class

/*
 * Settings will hold our settings for if the game sound is on or off as well as the music. 
 * Volume will be up to the hardware of the device the user is playing on.
 */
public class Settings {

	private boolean isMusicOn = true;
	private boolean isSoundOn = true;
	
	Settings(){
	}

	public boolean getIsMusicOn(){
		return isMusicOn;
	}
	
	public boolean getIsSoundOn(){
		return isSoundOn;
	}
	
	public void setIsSoundOn(boolean s){
		isSoundOn = s;
	}
	
	public void setIsMusicOn(boolean m){
		isMusicOn = m;
	}
	
	public void getDifficultLevel(){
		
	}
	
	public void setDifficultyLevel(String s){
		
	}
	
	public void settingsMenu(){
		
	}
	
	public void settingsPause(){
		
	}
}
