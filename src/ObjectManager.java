import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager extends GameObject {
	Rocketship ship;
	ArrayList<Projectile> projectiles = new ArrayList();
	Random random = new Random();

	ArrayList<Alien> aliens = new ArrayList();

	ObjectManager(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);

	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
		
	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if(aliens.get(i).y<=LeagueInvaders.HEIGHT) {
				isActive = false;
			}
		}
	}

	void draw(Graphics g) {
		for(int i = 0; i<projectiles.size(); i++) {
		 projectiles.get(i).draw(g);
		}
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.remove(aliens);
			projectiles.remove(projectiles);
	}
}
}
