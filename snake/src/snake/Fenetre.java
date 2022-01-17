package snake;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fenetre extends JFrame{

	private Snake snake = new Snake();
	private GameOver overWindow = new GameOver();
	private final int width = 700;
	private final int height = 637;
	boolean gameOver = false;
	
	public Fenetre() {
		this.setSize(width,height);
		this.setTitle("Snake Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(snake);
		this.setVisible(true);
	}
	
	public void run() {
		while(!gameOver) {
			this.addKeyListener(new TAdapter());
			if(snake.head.equals(snake.food.pos)) {
				snake.food.eaten=true;
				snake.grow();
				snake.food.update();
			}
			else {
				snake.update();
			}
			gameOver=snake.endGame();
			if(gameOver) {
				this.setContentPane(overWindow);
				this.setVisible(true);
				break;
			}
			snake.repaint();
			try {
				Thread.sleep(100);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private class TAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			snake.direction(e);
		}
	}
}
