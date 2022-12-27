package WW3.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class NormalBullet extends GameObject{

	private Handler handler;
	
	public NormalBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 5;
		velY = 5;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 16,16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		//Bouncy function
		if(y <= 0 || y >= Game.HEIGHT-50) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH-20) velX *= -1;
		
//		handler.addObject(new Trail(x,y,ID.Trail,Color.gray, 16, 16, 0.03f, handler));
	}


	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect((int)x,(int)y,16,16);
		
//		g.setColor(Color.yellow);
//		g.fillRect((int)x,(int)y,35,35);
//		g.setColor(Color.blue);
//		g.fillRect((int)x,(int)y,35,17);
//		g.setColor(java.awt.Color.black);
//		g.drawRect((int)x,(int)y, 35,35);
		
	}

}
