package WW3.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		for(int i=0; i<object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i=0; i<object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeOject(GameObject object) {
		this.object.remove();
	}
	
	public void clearBullet() {
		for(int i=0; i<object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			if(tempObject.getID() != ID.Player) {
				object.clear();
				addObject(new Player((int)tempObject.getX()+32, (int)tempObject.getY()+32, ID.Player, this));
				addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player2, this));
			}
		}
	}
}	

