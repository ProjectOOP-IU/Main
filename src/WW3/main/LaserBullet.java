package WW3.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class LaserBullet extends GameObject{

	private Handler handler;
	
	public LaserBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 2;
		velY = 9;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 16,16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT-50) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH-20) velX *= -1;
		
//		handler.addObject(new Trail(x,y,ID.Trail,Color.red, 16, 16, 0.03f, handler));
	}


	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)x,(int)y,16,16);

		
	}

}
