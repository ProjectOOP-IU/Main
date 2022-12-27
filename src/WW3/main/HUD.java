package WW3.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

//HEAD UPS DISPLAY CLASS
public class HUD {
	
	public static float HEALTH1 = 100;
	public static float HEALTH2 = 100;
	
	private float greenValue1 = 255;
	private float greenValue2 = 255;
	
	private int score = 0;
	private int level = 1;
	
	public void tick() {
		HEALTH1 = Game.clamp(HEALTH1, 0, 100);
		HEALTH2 = Game.clamp(HEALTH2, 0, 100);
		
		greenValue1 = Game.clamp(greenValue1, 0, 225);
		greenValue2 = Game.clamp(greenValue2, 0, 225);
		
		greenValue1 = HEALTH1*2;
		greenValue2 = HEALTH2*2;
		
		score++;
	}
	
	public void render(Graphics g) {
		//Player 1 health bar 
		g.setColor(Color.gray);//Health bar
		g.fillRect(15,30,200,16);
		g.setColor(new Color(75, (int)greenValue1, 0));//Health
		g.fillRect(15,30,(int)HEALTH1*2,16);
		g.setColor(Color.black);//Health bar border
		g.drawRect(15,30,200,16);
		g.drawString("Ukraine", 15,20);
		
		
		//Player 2 health bar
		g.setColor(Color.gray);//Health bar
		g.fillRect(400,30,200,16);
		g.setColor(new Color(75, (int)greenValue2, 0));//Health
		g.fillRect(400,30,(int)HEALTH2*2,16);
		g.setColor(Color.black);//Health bar border
		g.drawRect(400,30,200,16);
		g.drawString("Russia", 565,20);
		
		
		//Status area
		g.setColor(Color.white);
		g.fillRect(255,15,100,35);
		g.setColor(Color.black);
		g.drawRect(255,15,100,35);
		g.setColor(Color.black);
		g.drawString("Score: " + score, 280, 30);
		g.drawString("Level: " + level, 287, 45);
		
	}	
		
	public void setscore(int score) {
		this.score = score;
	}
	
	public int getscore(){
		return score;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
}
