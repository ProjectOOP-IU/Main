package WW3.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossBullet extends GameObject{

	private Handler handler;
	Random r = new Random();
	
	public BossBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(5- -5) + -5);
		velY = 5;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 16,16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		//Bouncy function
//		if(y <= 0 || y >= Game.HEIGHT-50) velY *= -1;
//		if(x <= 0 || x >= Game.WIDTH-20) velX *= -1;
		
		//remove when touch the outline of the window
		if(y >= Game.HEIGHT) handler.removeOject(this);		
//		handler.addObject(new Trail(x,y,ID.Trail,Color.gray, 16, 16, 0.03f, handler));
	}


	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect((int)x,(int)y,16,16);

		
	}

}
