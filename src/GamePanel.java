import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage imageBackground;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font smallerFont = new Font("Arial", Font.PLAIN, 28);
	Timer alienSpawn;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	ObjectManager manager = new ObjectManager(rocket);

	@Override
	public void paintComponent(Graphics g) {
		
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void startGame() {
		alienSpawn = new Timer(1000, manager);
		alienSpawn.start();
		Timer frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	void endGame() {
		alienSpawn.stop();
		currentState = END;
		
	}

	GamePanel() {
		if (needImage) {
			loadImage("rocket.png");
		}
	}

	JPanel JP = new JPanel();

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		if(rocket.isActive == false) {
			endGame();
		}
		
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 15, 200);
		g.setFont(smallerFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start", 110, 400);
		g.setFont(smallerFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE for instructions", 70, 600);
	}

	void drawGameState(Graphics g) {

		if (gotImage) {
			g.drawImage(imageBackground, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		
		//manager.addProjectile(rocket.getProjectile());
		manager.draw(g); 
g.setColor(Color.WHITE);
	g.drawString("score:" + manager.getScore(), 50, 50);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("GAME OVER", 100, 400);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();

		} else if (currentState == END) {
			updateEndState();

		}
		// System.out.println("Action");
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				endGame();
				currentState = MENU;
				rocket = new Rocketship(250, 700, 50, 50);
				manager = new ObjectManager(rocket);

			} else {
				currentState++;
			}
			if (currentState == GAME) {
				startGame();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP && rocket.y >= 0) {
			rocket.down();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && rocket.y <= 700) {
			rocket.up();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT && rocket.x >= 0) {
			rocket.left();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && rocket.x <= 450) {
			rocket.right();
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE ) {
			manager.addProjectile(rocket.getProjectile());
		}
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				imageBackground = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
