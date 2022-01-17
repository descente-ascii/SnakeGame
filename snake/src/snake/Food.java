package snake;

import java.util.Random;

public class Food {
	Position pos;
	int scale;
	boolean eaten;

	public Food() {
		scale = 10;
		pos = new Position();
		pos.x= (int) (Math.round((Math.random()*(600-0))/10)*10)-scale;
		pos.y= (int) (Math.round((Math.random()*(600-0))/10)*10)-scale;
		System.out.println("afficher food x" + pos.x + "foody " +pos.y);
		eaten=false;
	}

	public void update(){
		if(eaten) {
			pos.x= (int) (Math.round((Math.random()*(600-0))/10)*10)-scale;
			pos.y= (int) (Math.round((Math.random()*(600-0))/10)*10)-scale;
			eaten=false;
		}
	}
}
