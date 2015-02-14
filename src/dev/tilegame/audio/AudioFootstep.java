package dev.tilegame.audio;

public class AudioFootstep
{
	public static String file;
	public static int variations;
	
	public AudioFootstep(String newFile, int newVariations)
	{
		file = newFile;
		variations = newVariations;
		for(int x=1;x<=newVariations;x+=1)
		{
			String path = "/sounds/footstep" + newFile + x + ".wav";
			String filename = "sfxFootstep" + newFile + x;
			AudioPlayer.load(path, filename);
		}
	}
}