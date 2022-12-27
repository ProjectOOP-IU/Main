package WW3.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Player extends GameObject {

	Random r = new Random();
	Handler handler;
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
	}
	// Bound for intersection
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 35,35);
	}

	
	public void tick() {	
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH -50);
		y = Game.clamp(y, 0, Game.HEIGHT -70);
		
		collision();
		
//		handler.addObject(new Trail(x,y,ID.Trail,Color.blue, 32, 32, 0.01f, handler));
	}
	// check if Enemy touch Player it will decrease Health
	private void collision() {
		if(id == ID.Player) {
			for(int i=0; i<handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getID() == ID.NormalBullet || tempObject.getID() == ID.LaserBullet || tempObject.getID() == ID.FollowBullet || tempObject.getID() == ID.HardBullet) {
					if(getBounds().intersects(tempObject.getBounds())) {
						//collision code
						HUD.HEALTH1 -= 1;
					}
				}
			}	
		} else if (id == ID.Player2) {
			for(int i=0; i<handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getID() == ID.NormalBullet || tempObject.getID() == ID.LaserBullet || tempObject.getID() == ID.FollowBullet || tempObject.getID() == ID.HardBullet) {
					if(getBounds().intersects(tempObject.getBounds())) {
						//collision code
						HUD.HEALTH2 -= 1;
					}
				}
			}	
		}
	}
	
	public void render(Graphics g) {
		if(id == ID.Player) {
			g.setColor(Color.yellow);
			g.fillRect((int)x,(int)y,35,35);
			g.setColor(Color.blue);
			g.fillRect((int)x,(int)y,35,17);
			g.setColor(java.awt.Color.black);
			g.drawRect((int)x,(int)y, 35,35);
		} 
		else if (id == ID.Player2) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y,35,35);
		g.setColor(Color.blue);
		g.fillRect((int)x,(int)y,35,24);
		g.setColor(Color.white);
		g.fillRect((int)x,(int)y,35,12);
		g.setColor(java.awt.Color.black);
		g.drawRect((int)x,(int)y, 35,35);
		}
		
		//for testing object bounded
//		Graphics2D g2d = (Graphics2D) g;
//		
//		g.setColor(Color.green);
//		g2d.draw(getBounds());
		
	}
	
	
	
	

}
