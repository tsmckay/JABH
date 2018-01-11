package edu.tsmckay.game;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/*
 * This class provides the ability to play music and sounds.
 * Sound is stored as hashmaps
 * The audioplayer is initialized using the AudioPlayer.init(); method
 */


public class AudioPlayer
{
	//sound and music maps
	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();
	
	//method for initializing and loading sounds
	public static void init()
	{
		try {
			soundMap.put("select", new Sound("res/select.ogg"));
			soundMap.put("hurt", new Sound("res/hurt.wav"));
			soundMap.put("destroy", new Sound("res/destroy.wav"));
			musicMap.put("music", new Music("res/music.ogg"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//play music
	public static Music getMusic(String key)
	{
		return musicMap.get(key);
	}
	
	//play sound
	public static Sound getSound(String key)
	{
		return soundMap.get(key);
	}
}
