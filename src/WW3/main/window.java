package WW3.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class window extends Canvas{

	
	private static final long serialVersionUID = -1673387279594740207L;
	
	public window(int width, int height, String title, Game game) {
		//frame of our window
		JFrame frame = new JFrame(title);
		ImageIcon img = new ImageIcon("res/Icon.jpg");
		
		frame.setIconImage(img.getImage());
		frame.setSize(50, 300);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close button (X)
		frame.setResizable(false);//resize of window
		frame.setLocationRelativeTo(null);//null=start the window at the middle
		frame.add(game);
		frame.setVisible(true);//set to see it 
		game.start();
		
		
	}
	
//	public window(int width, int height, String title, Game game, Sound sound) {
//		//frame of our window
//		JFrame frame = new JFrame(title);
//		ImageIcon img = new ImageIcon("res/Icon.jpg");
//		
//		frame.setIconImage(img.getImage());
//		frame.setSize(50, 300);
//		frame.setPreferredSize(new Dimension(width, height));
//		frame.setMaximumSize(new Dimension(width, height));
//		frame.setMinimumSize(new Dimension(width, height));
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close button (X)
//		frame.setResizable(false);//resize of window
//		frame.setLocationRelativeTo(null);//null=start the window at the middle
//		frame.add(game);
//		frame.setVisible(true);//set to see it 
//		game.start();
//		
//		
//	}

}
