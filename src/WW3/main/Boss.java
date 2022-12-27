package WW3.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss extends GameObject{

	private Handler handler;
	Random r = new Random();
	
	private int timer = 70;
	private int timer2 = 50;
	
	public Boss(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 0;
		velY = 2;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 64,64);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		//boss dropdown timer
		if(timer <= 0) velY = 0;
		else timer--;
		
		//boss go horizontal timer
		if(timer <= 0) timer2--;
		if(timer2 <= 0) {
			if(velX == 0) velX = 2;
			if(velX > 0) 
			velX += 0.005f;
			else if (velX < 0) 
			velX -= 0.005f;
			int spawn = r.nextInt(10);
			if(spawn == 0) handler.addObject(new BossBullet((int)x+48, (int)y+48, ID.NormalBullet, handler));
		}
			
//		if(y <= 0 || y >= Game.HEIGHT-50) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH-70) velX *= -1;
		
//		handler.addObject(new Trail(x,y,ID.Trail,Color.red, 64, 64, 0.03f, handler));
	}


	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y,64,64);

		
	}

}
