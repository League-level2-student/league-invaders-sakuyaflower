import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font smallerFont = new Font("Arial", Font.PLAIN, 28);
	Rocketship rocket = new Rocketship(250, 700, 50, 50);


	@Override
	public void paintComponent(Graphics g) {
		Timer frameDraw = new Timer(1000 / 100, this);
		frameDraw.start();
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	JPanel JP = new JPanel();

	void updateMenuState() {

	}

	void updateGameState() {

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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		rocket.draw(g);
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
				currentState = MENU;
			}

			else {
				currentState++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP && rocket.y >= 0) {
			System.out.println("up");
			rocket.down();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && rocket.y <= 700) {
			System.out.println("down");
			rocket.up();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT && rocket.x >= 0) {
			System.out.println("left");
			rocket.left();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && rocket.x <= 450) {
			System.out.println("right");
			rocket.right();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
