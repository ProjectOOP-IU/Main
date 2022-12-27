package WW3.main;

import java.util.Random;

public class Spawn {
	private Handler handler;
	private HUD hud;
	private Game game;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	
	
	public Spawn(Handler handler, HUD hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 200) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
//			if(hud.getLevel() == 2) {
//				handler.addObject(new Boss(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.Boss,handler));
//			}
			if(game.diff == 0 ) {
				if(hud.getLevel() == 2) {
					handler.addObject(new NormalBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.NormalBullet,handler));
				} else if(hud.getLevel() == 3) {
					handler.addObject(new NormalBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.NormalBullet,handler));
				} else if (hud.getLevel() == 5) {
					handler.addObject(new LaserBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.LaserBullet,handler));
				} else if (hud.getLevel() == 7) {
					handler.addObject(new FollowBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.FollowBullet,handler));
				} else if (hud.getLevel() == 9) {
					handler.addObject(new LaserBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.LaserBullet,handler));
				} else if(hud.getLevel() == 12) {
					handler.addObject(new NormalBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.NormalBullet,handler));
				} else if(hud.getLevel() == 15) {
					handler.addObject(new NormalBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.NormalBullet,handler));
				}
//				else if (hud.getLevel() == 10) {
//					handler.clearBullet();
//					handler.addObject(new Boss(r.nextInt(Game.WIDTH/2 - 40), -80,ID.NormalBullet,handler));
//				}
			} else if (game.diff == 1) {
				if(hud.getLevel() == 2) {
					handler.addObject(new HardBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.HardBullet,handler));
				} else if(hud.getLevel() == 3) {
					handler.addObject(new HardBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.HardBullet,handler));
				} else if (hud.getLevel() == 5) {
					handler.addObject(new LaserBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.LaserBullet,handler));
				} else if (hud.getLevel() == 6) {
					handler.addObject(new HardBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.HardBullet,handler));
					handler.addObject(new HardBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.HardBullet,handler));
				} else if (hud.getLevel() == 7) {
					handler.addObject(new FollowBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.FollowBullet,handler));
				} else if (hud.getLevel() == 9) {
					handler.addObject(new LaserBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.LaserBullet,handler));
				} else if (hud.getLevel() == 12) {
					handler.addObject(new FollowBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.FollowBullet,handler));
				} else if (hud.getLevel() == 15) {
					handler.addObject(new HardBullet(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.HardBullet,handler));
				}
//				else if (hud.getLevel() == 10) {
//					handler.clearBullet();
//					handler.addObject(new Boss(r.nextInt(Game.WIDTH/2 - 40), -80,ID.NormalBullet,handler));
//				}
			}
			
			
			
			
		}
	}
}
