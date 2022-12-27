package WW3.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable {


	private static final long serialVersionUID = -907001926677629143L;
	
	public static final int WIDTH = 630, HEIGHT = 380;

	private Thread thread;//how the entire game will run 
	private boolean running = false;
	
	public static boolean paused = false;
	public int diff = 0;
	//0 = normal
	//1 =  hard
	
	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawn;
	private Menu menu;
	private Game game;
	private Sound sound;
	
	public enum STATE {
		Menu,
		Help,
		Game_Normal,
		Game_Hard,
		End1,
		End2,
		Select
	};
	
	public STATE gameState = STATE.Menu;
	
	public Game() 
	{
		sound = new Sound();
		handler = new Handler();
		hud = new HUD();
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);
//		sound = new Sound();
//		playMusic(1);
		
		new window(WIDTH, HEIGHT, "World War 3 (Russia vs Ukraine version)", this);
		
		
		spawn = new Spawn(handler, hud, this);
		
		
		r = new Random();
		
//		if(gameState == STATE.Game_Normal) 
//		{
//	
//			handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
//			handler.addObject(new Player(WIDTH/2+64, HEIGHT/2+64, ID.Player2, handler));
//			handler.addObject(new NormalBullet(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.NormalBullet,handler));
//			/*
//			handler.addObject(new Boss((Game.WIDTH/2)-40,-80,ID.Boss,handler));
//			
//			handler.addObject(new Player(100,100,ID.Player));
//			handler.addObject(new Player(200,200,ID.Player));
//			*/
//		} else if (gameState == STATE.Game_Hard) 
//		{
//	
//			handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
//			handler.addObject(new Player(WIDTH/2+64, HEIGHT/2+64, ID.Player2, handler));
//			handler.addObject(new HardBullet(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HardBullet,handler));
//			/*
//			handler.addObject(new Boss((Game.WIDTH/2)-40,-80,ID.Boss,handler));
//			
//			handler.addObject(new Player(100,100,ID.Player));
//			handler.addObject(new Player(200,200,ID.Player));
//			*/
//		}
//		else if (gameState == STATE.Menu) {
//			for(int i =0; i<10; i++) {
//				handler.addObject(new MenuParticle(r.nextInt(WIDTH),r.nextInt(HEIGHT), ID.MenuParticle, handler));
//			}
//		}
	}	

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();// Don't need to click on window to control
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta>=1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis()- timer > 1000) {
				timer += 1000;
//				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
	
		if(gameState == STATE.Game_Normal || gameState == STATE.Game_Hard) {
			
			if(!paused) { 
				hud.tick();
				spawn.tick();
				handler.tick();
				
				if(HUD.HEALTH1 <= 0 && HUD.HEALTH2 > 0) {
					HUD.HEALTH1 = 100;
					HUD.HEALTH2 = 100;				
					handler.clearBullet();
					gameState = STATE.End1;
					
				} else if (HUD.HEALTH2 <= 0 && HUD.HEALTH1 > 0) {
					HUD.HEALTH1 = 100;
					HUD.HEALTH2 = 100;				
					handler.clearBullet();
					gameState = STATE.End2;
				}	
			}
		} else if(gameState == STATE.Menu || gameState == STATE.End1 || gameState == STATE.End2 || gameState == STATE.Select) {
			menu.tick();
			handler.tick();
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
//		g.setColor(Color.black);
//		g.fillRect(0,0, WIDTH, HEIGHT);
		Toolkit t=Toolkit.getDefaultToolkit();  
	    Image i=t.getImage("res/background.png");  
	    g.drawImage(i, 0,0,this);  
		
	    handler.render(g);
	    if(paused) {
			g.setColor(Color.black);
			g.fillRect(260, 140, 100, 50);
	    	g.setColor(Color.white);
			g.drawString("<<Pause>>",281, 170);
	    }
	    
	    if(gameState == STATE.Game_Normal || gameState == STATE.Game_Hard) {  
	    	hud.render(g);
	    } else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End1 || gameState == STATE.End2 || gameState == STATE.Select) {
//	    	g.setColor(Color.black);
//			g.fillRect(0,0, WIDTH, HEIGHT);
	    	Image i1=t.getImage("res/menu_background.jpg");
	    	g.drawImage(i1, 0,0,this);  
	    	menu.render(g);
		} 
		
		g.dispose();
		bs.show();
		
	}
	
	//keep player in the window, can't go out of the window  
	public static float clamp(float var, float min, float max) {
		if(var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else 
			return var;
	}
	
	public void playMusic(int i) {
		sound.setFile(i);
		sound.play();
		sound.loop();
	}
	
	public void stopMusic() {
		sound.stop();
		
	}
	
	public void playSE(int i) {
		sound.setFile(i);
		sound.play();
	}
	
	public static void main(String args[]) {
		new Game();
	}
	
}





















