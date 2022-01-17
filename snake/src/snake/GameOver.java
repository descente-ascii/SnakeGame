package snake;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameOver extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		try {
			g.drawImage(ImageIO.read(new File("src\\gameOver.png")), 0, 0,600,550,null, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
