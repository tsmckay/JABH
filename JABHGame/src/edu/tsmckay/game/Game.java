package edu.tsmckay.game;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 8219088514191419383L;
	public static final int WIDTH = 640, 
							HEIGHT = WIDTH/12*9;
	
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private HUD hud;
	
	public Game()
	{
		handler = new Handler();
		
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "Jack Attack 0.1A", this);
		
		hud = new HUD();
		
		handler.addObject(new Player(WIDTH/2-32, HEIGHT/2+175, ID.Player));
		for (int i = 0; i < 5; i++)
		{
			handler.addObject(new BasicEnemy(20+80*i, 60, ID.Enemy));
		}
		
		for (int i = 0; i < handler.object.size(); i++)
		{
			if (handler.object.get(i).getId() == ID.Enemy)
			{
				handler.addObject(
						new Projectile( (handler.object.get(i)).getX(),
									  	(handler.object.get(i)).getY(),
									  	ID.Projectile));
			}
		}
		
	}
	
	
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop()
	{
		try
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
			this.requestFocus();
	        long lastTime = System.nanoTime();												
	        double amountOfTicks = 60.0;
	        double ns = 1000000000 / amountOfTicks;
	        double delta = 0;
	        long timer = System.currentTimeMillis();
	        int frames = 0;
	        while(running)
	        {
	                    long now = System.nanoTime();
	                    delta += (now - lastTime) / ns;
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
	                                System.out.println("FPS: "+ frames);
	                                frames = 0;
	                            }
	        }
	                stop();
	}

//end of game loop
	
	private void tick()
	{
		handler.tick();
		hud.tick();
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		hud.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max)
	{
		if (var >= max) return max;
		else if (var <= min) return min;
		else return var;
	}
	
	public static void main(String[] args)
	{
		new Game();
	}

}
