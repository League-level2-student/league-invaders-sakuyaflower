import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Alien extends GameObject {
	int speed = 1;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		if (needImage) {
			loadImage("alien.png");
		}
	}

	void update() {
		y+=speed;
		System.out.println(y);
		super.update();
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	System.out.println("x =" + x + "y=" + y + "speed =" + speed);
	}
	
	}
