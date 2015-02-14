package dev.tilegame.audio;

public class AudioManager
{
	private static boolean active = true;
	private static AudioFootstep[] footsteps = new AudioFootstep[20]; 
	private static int footstepsCount = 0;
	private static boolean musicActive = false;
	private static String musicFile;
	private static boolean soundActive = false;
	private static String soundFile;
	private static int soundTick;
	private static int volume = 100;

	public AudioManager()
	{
		AudioPlayer.init();
		initFootsteps();
		initMusic();
		initSounds();
	}
	
	public void addFootstep(String file, int variations)
	{
		footsteps[footstepsCount] = new AudioFootstep(file, variations);		
		footstepsCount += 1;
	}
	
	public AudioFootstep getFootstep(int id)
	{
		return footsteps[id];
	}
	
	public int getFootstepID(String file)
	{
		for(int n = 1;n<=footstepsCount;n+=1)
		{
			if(footsteps[n].file==file){return n;}
		}
		return 0;
	}
	
	public int getFootstepCount()
	{
		return footstepsCount;
	}
	
	public boolean getMusicActive()
	{
		return musicActive;
	}
	
	public boolean getSoundActive()
	{
		return soundActive;
	}
	
	public void initFootsteps()
	{
		addFootstep("Grass",2);
		addFootstep("Wood",2);
		
		// Debug
		for(int n = 1;n<=footstepsCount;n+=1)
		{
			String debug = "Footstep #" + n + " = " + footsteps[n].file;
			System.out.println(debug);
		}
	}
	
	public void initMusic()
	{
		AudioPlayer.load("/music/bgm1.wav", "music1");
		AudioPlayer.load("/music/bgm2.wav", "music2");
	}
	
	public void initSounds()
	{
		// Note: Do we need these?
		AudioPlayer.load("/sounds/collectGarnet.wav", "Garnet");
		AudioPlayer.load("/sounds/collectMushroom.wav", "Mushroom");
		AudioPlayer.load("/sounds/collectTreasure.wav", "Treasure");
	}
	
	public void playMusic(String music)
	{
		AudioPlayer.play(music);
		musicActive = true;
		musicFile = music;
	}
	
	public void playSound(String sound)
	{
		AudioPlayer.play(sound);
		soundActive = true;
		soundFile = sound;
		soundTick = 0;
	}
	
	public void setVolume(int newVolume)
	{
		volume = newVolume;
		if(newVolume<1){active = false;}
		else{active = true;}
	}
	
	public void stopMusic()
	{
		AudioPlayer.stop(musicFile);
		musicActive = false;
		musicFile = "";
	}
	
	public void stopSound()
	{
		//AudioPlayer.stop(soundFile);
		soundActive = false;
		soundFile = "";
	}
	
	public void tick()
	{
		if(getSoundActive())
		{
			soundTick += 1;
			//if(soundTick>1){stopSound();}
		}
	}
}