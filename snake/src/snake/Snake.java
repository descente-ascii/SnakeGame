package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Snake extends JPanel{

	int lenght;
	int scale;
	Position head;
	int xdir;
	int ydir;
	List<Position> snakeBody;
	
	public Snake() {
		lenght=1;
		scale=10;
		head = new Position(0,0);
		snakeBody = new ArrayList<Position>();
		snakeBody.add(head);
		xdir=1;
		ydir=0;
	}
	
	public void direction(KeyEvent evt) {
		if(evt.getKeyCode() == KeyEvent.VK_LEFT) {
			if(xdir==1 && ydir==0) return;
			xdir=-1;
			ydir=0;
		}
		else if(evt.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(xdir==-1 && ydir==0) return;
			xdir=1;
			ydir=0;
		}
		else if(evt.getKeyCode() == KeyEvent.VK_UP) {
			if(xdir==0 && ydir==1) return;
			xdir=0;
			ydir=-1;
		}
		else if(evt.getKeyCode() == KeyEvent.VK_DOWN) {
			if(xdir==0 && ydir==-1) return;
			xdir=0;
			ydir=1;
		}
	}
	
	public void grow() {
		Position lastElem = snakeBody.get(snakeBody.size()-1).clone();
		update();
		snakeBody.add(new Position(lastElem.x,lastElem.y));
		System.out.println("tete de liste position =" + snakeBody.get(0).x +","+snakeBody.get(0).y);
		System.out.println("2eme elem position = " + snakeBody.get(1).x +","+snakeBody.get(1).y);
	}
	
	public void update() {
		Position previous = head.clone();
		int previousx = previous.x;
		int previousy = previous.y;
		head.x = head.x + xdir*scale;
		head.y = head.y + ydir*scale;
		int nextx = 0;
		int nexty =0;
		for (Position pos : snakeBody) {
			if(pos==head) continue;
			nextx = pos.x;
			nexty = pos.y;
			pos.x= previousx;
			pos.y= previousy;
			previousx=nextx;
			previousy=nexty;
		}
	}
	
	public Food food = new Food();
	
	@Override
	public void paintComponent(Graphics g) {	
		//Background
		g.setColor(Color.decode("#363636"));
		g.fillRect(0, 0, 600, 600);
		//Food
		g.setColor(Color.red);
		g.fillRect(food.pos.x, food.pos.y, food.scale, food.scale);
		//Snake
		g.setColor(Color.WHITE);
		for (Position pos : snakeBody) {
			g.fillRect(pos.x, pos.y, scale, scale);
		}
		//Right pan
		g.setColor(Color.decode("#202020"));
		g.fillRect(600, 0, 100, 600);
		//Text
		g.setColor(Color.white);
		g.drawString("SCORE", 620, 15);
		g.drawString(String.valueOf(snakeBody.size()), 639, 30);
	}
	
	public boolean endGame() {
		for (int i=1; i<snakeBody.size() ; i++) {
			if(head.equals(snakeBody.get(i)))
				return true;
		}
		if(head.x>600-scale || head.x<0
				|| head.y>600-scale || head.y<0)
			return true;
		else
			return false;
	}
}
