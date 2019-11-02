import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	int speed = 1;

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	void update() {
		y+=speed;
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}

}