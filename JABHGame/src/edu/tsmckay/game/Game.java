package edu.tsmckay.game;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 8219088514191419383L;	//serial versionUID
	
	public static final int WIDTH = 640, 
							HEIGHT = WIDTH/12*9;	//sets window width and height
	
	private Thread thread;					//declares thread, handler, and HUD
	private boolean running = false;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	public static boolean paused = false;
	
	public STATE gameState = STATE.Menu;
	
	public Game()
	{
		handler = new Handler();	//create new instance of Handler class
		
		//create new instance of HUD class
		hud = new HUD();
		
		menu = new Menu(this, handler, hud);
		
		this.addKeyListener(new KeyInput(handler, this));		//start listening for keyboard input
		this.addMouseListener(menu);
		
		AudioPlayer.init();
		
		AudioPlayer.getMusic("music").loop();
		
		new Window(WIDTH, HEIGHT, "Release 1.0", this);
		
		
		spawner = new Spawn(handler, hud);
		
		if (gameState == STATE.Game)
		{
			//spawn player at the bottom of the screen
			handler.addObject(new Player(WIDTH/2-32, HEIGHT/2+175, ID.Player, handler));
		}
	}
	
	public void spawnEnemies(int num)	//this method spawns a number of enemies designated by int num
	{
		for (int i = 0; i < num; i++)
		{
			handler.addObject(new BasicEnemy(20+80*i, 60, ID.Enemy, handler));
		}
	}
	
	public synchronized void start()	//starts thread
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop()		//stops thread
	{
		try		//try catch exception handler
		{
			thread.join();
			running = false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
//start of game loop, sets constant controlled speed
	
	public void run()
	{
			this.requestFocus(); //requests focus of windows
			
			//keeps track of time
	        long lastTime = System.nanoTime();												
	        double amountOfTicks = 60.0;
	        double ns = 1000000000 / amountOfTicks;
	        double delta = 0;
	        long timer = System.currentTimeMillis();
	        int frames = 0;
	        
	        //game logic
	        while(running)
	        {
	                    long now = System.nanoTime();	//current time
	                    delta += (now - lastTime) / ns;	//change in time
	                    lastTime = now;
	                    while(delta >=1)
	                            {
	                                tick();
	                                delta--;
	                            }
	                            if(running)
	                                render();
	                            frames++;
	                            
	                            if(System.currentTimeMillis() - timer > 1000)
	                            {
	                                timer += 1000;
	                                System.out.println("FPS: "+ frames);	//prints FPS to console
	                                frames = 0;
	                            }
	        }
	                stop();
	}

//end of game loop
	
	
	//tick method; ran each time the game updates
	private void tick()
	{
		if (gameState == STATE.Game)
		{
			if (!(paused)) 
			{
				handler.tick();	//updates game objects
				hud.tick();	//updates HUD
				spawner.tick();
				if (HUD.HEALTH <= 0)
				{
					HUD.HEALTH = 100;
					handler.object.clear();
					gameState = STATE.GameOver;
				}
			}
		}
		if (gameState == STATE.GameOver) handler.object.clear();
		else if (gameState == STATE.Menu || gameState == STATE.GameOver || gameState == STATE.Select)
		{
			handler.tick();
			menu.tick();
		}
	}
	
	//renders objects to screen
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		//sets background to black
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0, WIDTH, HEIGHT);
		
		//renders game objects
		handler.render(g);
		
		if(paused)
		{
			g.setColor(Color.WHITE);
			Font fntpause = new Font("arial", 1, 45);
			g.setFont(fntpause);
			g.drawString("Paused", 240, 200);
		}
		
		if (gameState == STATE.Game)
		{
			//renders HUD
			hud.render(g);
		}
		else if (gameState == STATE.Menu || gameState == STATE.GameOver || gameState == STATE.Select)
		{
			menu.render(g);
		}
		
		//flushes graphics
		g.dispose();
		bs.show();
	}
	
	//clamp method; clamps int var to a value between int min and int max
	//used later on for health and other values
	public static int clamp(int var, int min, int max)
	{
		if (var >= max) return max;
		else if (var <= min) return min;
		else return var;
	}
	
	//main method
	public static void main(String[] args)
	{
		new Game(); //creates new instance of game
	}

}
