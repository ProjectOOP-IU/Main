package WW3.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FollowBullet extends GameObject{

	private Handler handler;
	private GameObject player1;
	
	public FollowBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		for(int i=0; i<handler.object.size();i++) {
			if(handler.object.get(i).getID() == ID.Player) player1 = handler.object.get(i);
		}
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 16,16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		
		//follow command
		float diffX = x - player1.getX() - 35;
		float diffY = y - player1.getY() - 35;
		float distance = (float) Math.sqrt((x-player1.getX())*(x-player1.getX())+(y-player1.getY())*(y-player1.getY()));
		
		velX = ((-1/distance) * diffX);
		velY = ((-1/distance) * diffY);
		
//		if(y <= 0 || y >= Game.HEIGHT-50) velY *= -1;
//		if(x <= 0 || x >= Game.WIDTH-20) velX *= -1;
		
//		handler.addObject(new Trail(x,y,ID.Trail,Color.green, 16, 16, 0.03f, handler));
	}


	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int)x,(int)y,16,16);

		
	}

}
