package WW3.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import WW3.main.Game.STATE;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private boolean[] keyDown = new boolean[8];
	
	Game game;
	
	public KeyInput(Handler handler, Game game) {
		this.handler = handler;
		
		this.game = game;
		
		keyDown[0]=false;
		keyDown[1]=false;
		keyDown[2]=false;
		keyDown[3]=false;
		keyDown[4]=false;
		keyDown[5]=false;
		keyDown[6]=false;
		keyDown[7]=false;
		
	}
	
	public void keyPressed(KeyEvent e) {
		 int key = e.getKeyCode();
		 
		 for(int i=0;i<handler.object.size();i++) {
			 GameObject tempObject = handler.object.get(i);
			//Pressed key Listener for Player 1
			 if(tempObject.getID() == ID.Player) {
				 
				 if(key==KeyEvent.VK_W) {tempObject.setVelY(-5); keyDown[0]=true;}
				 if(key==KeyEvent.VK_S) {tempObject.setVelY(5); keyDown[1]=true;}
				 if(key==KeyEvent.VK_A) {tempObject.setVelX(-5); keyDown[2]=true;}
				 if(key==KeyEvent.VK_D) {tempObject.setVelX(5); keyDown[3]=true;}
			 }
			//Pressed key Listener for Player 2 
			 if(tempObject.getID() == ID.Player2) {
				 
				 if(key==KeyEvent.VK_UP) {tempObject.setVelY(-5); keyDown[4]=true;}
				 if(key==KeyEvent.VK_DOWN) {tempObject.setVelY(5); keyDown[5]=true;}
				 if(key==KeyEvent.VK_LEFT) {tempObject.setVelX(-5); keyDown[6]=true;}
				 if(key==KeyEvent.VK_RIGHT) {tempObject.setVelX(5); keyDown[7]=true;}
			 }
		 }
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i=0;i<handler.object.size();i++) {
			 GameObject tempObject = handler.object.get(i);
			//Stop key Listener for Player 1
			 if(tempObject.getID() == ID.Player) {
				 
				 if(key==KeyEvent.VK_W) keyDown[0]=false;//tempObject.setVelY(0);
				 if(key==KeyEvent.VK_S) keyDown[1]=false;//tempObject.setVelY(0);
				 if(key==KeyEvent.VK_A) keyDown[2]=false;//tempObject.setVelX(0);
				 if(key==KeyEvent.VK_D) keyDown[3]=false;//tempObject.setVelX(0);
				 
				 //vertical movement
				 if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				//horizontal movement
				 if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			 }
			 //Stop key Listener for Player 2 
			 if(tempObject.getID() == ID.Player2) {
				 
				 if(key==KeyEvent.VK_UP) keyDown[4]=false;//tempObject.setVelY(0);
				 if(key==KeyEvent.VK_DOWN) keyDown[5]=false;//tempObject.setVelY(0);
				 if(key==KeyEvent.VK_LEFT) keyDown[6]=false;//tempObject.setVelX(0);
				 if(key==KeyEvent.VK_RIGHT) keyDown[7]=false;//tempObject.setVelX(0); 
				 
				 //vertical movement
				 if(!keyDown[4] && !keyDown[5]) tempObject.setVelY(0);
				//horizontal movement
				 if(!keyDown[6] && !keyDown[7]) tempObject.setVelX(0);
			 }
		 }
		// press ESC to escape
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
		// press P to pause
		if(key == KeyEvent.VK_P) {
			
			if(game.gameState == STATE.Game_Normal || game.gameState == STATE.Game_Hard) {
				if(Game.paused) Game.paused = false;
				else Game.paused = true;
				
			}
		}
	}
}
