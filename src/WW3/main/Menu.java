package WW3.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import WW3.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		//coordinate of the Play box
		
		if(game.gameState == STATE.Menu) {
			
			//Play button
			if(mouseOver(mx,my,200, 100, 200, 60)) {
//				game.gameState = STATE.Game;
//				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
//				handler.addObject(new Player(Game.WIDTH/2+64, Game.HEIGHT/2+64, ID.Player2, handler));
//				handler.clearBullet();
//				handler.addObject(new NormalBullet(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.NormalBullet,handler));
				
				game.gameState = STATE.Select;
				return;
			}
			
			//Help button
			if(mouseOver(mx,my,200, 180, 200, 60)) {
				game.gameState = STATE.Help;
			}
			
			//Quit button
			if(mouseOver(mx,my,200, 260, 200, 60)) {
				System.exit(1);
			}
		}
		
		//Back button
		if(game.gameState == STATE.Help) {
			if(mouseOver(mx,my,260, 277, 100, 30)) {
				game.gameState = STATE.Menu;
				return;
			}
		}
		
		if(game.gameState == STATE.Select) {
			
			//Normal button
			if(mouseOver(mx,my,200, 100, 200, 60)) {
				game.gameState = STATE.Game_Normal;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.addObject(new Player(Game.WIDTH/2+64, Game.HEIGHT/2+64, ID.Player2, handler));
				handler.clearBullet();
				handler.addObject(new NormalBullet(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.NormalBullet,handler));
				
				game.diff = 0;
				
			}
			
			//Hard button
			if(mouseOver(mx,my,200, 180, 200, 60)) {
				game.gameState = STATE.Game_Hard;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.addObject(new Player(Game.WIDTH/2+64, Game.HEIGHT/2+64, ID.Player2, handler));
				handler.clearBullet();
				handler.addObject(new HardBullet(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HardBullet,handler));
				
				game.diff = 1;
			}
			
			//Back button for select
			if(mouseOver(mx,my,200, 260, 200, 60)) {
				game.gameState = STATE.Menu;
				return;
			}
		}
		
		//Back button for help
		if(game.gameState == STATE.Help) {
			if(mouseOver(mx,my,250, 280, 100, 40)) {
				game.gameState = STATE.Menu;
				return;
			}
		}
		
		//Try again button
		if(game.gameState == STATE.End1 || game.gameState == STATE.End2) {
			if(mouseOver(mx,my,260, 277, 100, 30)) {
				game.gameState = STATE.Select;
				hud.setLevel(1);
				hud.setscore(0);
//				
//				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
//				handler.addObject(new Player(Game.WIDTH/2+64, Game.HEIGHT/2+64, ID.Player2, handler));
//				handler.clearBullet();
//				handler.addObject(new NormalBullet(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.NormalBullet,handler));
			}
		}
	}
	
//	public void mouseHover(MouseEvent e, Graphics g) {
//		int mx = e.getX();
//		int my = e.getY();
//		
//		if(mouseOver(mx,my,200, 100, 200, 60)) {
//			g.setColor(Color.black);
//			g.drawRect(200, 100, 200, 60);
//		} else if (mouseOver(mx,my,200, 180, 200, 60)) {
//			g.setColor(Color.black);
//			g.drawRect(200, 180, 200, 60);
//		} else if (mouseOver(mx,my,200, 260, 200, 60)) {
//			g.setColor(Color.black);
//			g.drawRect(200, 260, 200, 60);
//		}
//	}
	public void mouseRealeased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				
				return true;
			} else return false;
		} else return false;
	}
	
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if(game.gameState == STATE.Menu) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("World War 3",150, 65);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Play",267, 139);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Help",267, 220);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Quit",267, 300);
			
			
			g.setColor(Color.white);
			g.drawRect(200, 100, 200, 60);
			
			g.setColor(Color.white);
			g.drawRect(200, 180, 200, 60);

			g.setColor(Color.white);
			g.drawRect(200, 260, 200, 60);
		} else if (game.gameState == STATE.Help) {
			Font fnt = new Font("arial", 1, 70);
			Font fnt2 = new Font("arial", 1, 20);
			Font fnt3 = new Font("arial", 1, 7);
			
			//Help button
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help",230, 80);
			
			//Back button
			g.setFont(fnt2);
			g.drawRect(260, 277, 100, 30);
			g.drawString("Back",285, 300);
			
		///////Content for Help
			g.setFont(fnt2);
			g.drawString("Use these keys",240, 160);
			g.drawString("to dodge bullets",238, 190);
			//Ukraine instructions
			g.setFont(fnt2);
			g.drawString("Ukraine",100, 120);
			g.setColor(Color.white);
			g.drawRect(120, 150, 30, 30);
			g.setColor(Color.white);
			g.drawRect(120, 190, 30, 30);
			g.setColor(Color.white);
			g.drawRect(80, 190, 30, 30);
			g.setColor(Color.white);
			g.drawRect(160, 190, 30, 30);
			g.setFont(fnt2);
			g.drawString("W",126,173);
			g.drawString("S",128,213);
			g.drawString("A",88,213);
			g.drawString("D",168,213);
			
			//Russia instructions
			g.setFont(fnt2);
			g.drawString("Russia",450, 120);
			g.setColor(Color.white);
			g.drawRect(470, 150, 30, 30);
			g.setColor(Color.white);
			g.drawRect(470, 190, 30, 30);
			g.setColor(Color.white);
			g.drawRect(430, 190, 30, 30);
			g.setColor(Color.white);
			g.drawRect(510, 190, 30, 30);
			g.setFont(fnt3);
			g.drawString("UP",480,168);
			g.drawString("DOWN",473,208);
			g.drawString("LEFT",436,208);
			g.drawString("RIGHT",514,208);
			
			
		} else if (game.gameState == STATE.End1) {
			Font fnt = new Font("arial", 1, 70);
			Font fnt2 = new Font("arial", 1, 15);
			Font fnt3 = new Font("arial", 1, 30);
			
			g.setColor(Color.red);
			g.fillRect(293,120,35,35);
			g.setColor(Color.blue);
			g.fillRect(293,120,35,24);
			g.setColor(Color.white);
			g.fillRect(293,120,35,12);
			g.setColor(java.awt.Color.black);
			g.drawRect(293,120, 35,35);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over",115, 80);
			
			
			g.setFont(fnt3);
			g.drawString("Russia Win! ",225, 200);
			
			g.setFont(fnt2);
			g.drawString("with score:  " + hud.getscore(),250, 230);
			g.drawRect(260, 280, 100, 30);
			g.drawString("Try again",277, 300);
		} else if (game.gameState == STATE.End2) {
			Font fnt = new Font("arial", 1, 70);
			Font fnt2 = new Font("arial", 1, 15);
			Font fnt3 = new Font("arial", 1, 30);
			
			g.setColor(Color.yellow);
			g.fillRect(293,120,35,35);
			g.setColor(Color.blue);
			g.fillRect(293,120,35,17);
		
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over",115, 80);
			
			
			g.setFont(fnt3);
			g.drawString("Ukraine Win! ",220, 200);
			
			g.setFont(fnt2);
			g.drawString("with score:  " + hud.getscore(),250, 230);
			g.drawRect(260, 280, 100, 30);
			g.drawString("Try again",277, 300);
		} else if (game.gameState == STATE.Select) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("DIFFICULTY",150, 65);
			
			g.setFont(fnt2);
			g.setColor(Color.green);
			g.drawString("NORMAL",238, 141);
			
			g.setFont(fnt2);
			g.setColor(Color.red);
			g.drawString("HARD",260, 232);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("Back",277, 307);
			
			
			g.setColor(Color.green);
			g.drawRect(200, 100, 200, 60);
			
			g.setColor(Color.red);
			g.drawRect(200, 190, 200, 60);

			g.setColor(Color.white);
			g.drawRect(250, 280, 100, 40);
		}
		
		
	}
}
