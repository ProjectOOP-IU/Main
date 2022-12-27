package WW3.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class HardBullet extends GameObject{

	private Handler handler;
	private Random r = new Random();
	
	public HardBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 7;
		velY = 7;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 16,16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		//Bouncy function
		if(y <= 0 || y >= Game.HEIGHT-50) {if(velY<0) velY = -(r.nextInt(7)+1)*-1; else velY = (r.nextInt(7)+1)*-1;}
		if(x <= 0 || x >= Game.WIDTH-20) {if(velX<0) velX = -(r.nextInt(7)+1)*-1; else velX = (r.nextInt(7)+1)*-1;}
		
//		handler.addObject(new Trail(x,y,ID.Trail,Color.black, 16, 16, 0.03f, handler));
	}


	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect((int)x,(int)y,16,16);

		
	}

}
