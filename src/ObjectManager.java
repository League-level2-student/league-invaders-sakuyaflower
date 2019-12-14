import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList();
	Random random = new Random();
	int score = 0;
	ArrayList<Alien> aliens = new ArrayList();

	void getScore(){
		if(checkCollison) {
			
		}
	}
	
	ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);

	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

	}

	void update() {
		rocket.update();

		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if (aliens.get(i).y >= LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
			if (projectiles.get(i).y <= 0) {
				projectiles.get(i).isActive = false;
			}
		}
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {

		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}

	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if (rocket.collisionBox.intersects(aliens.get(i).collisionBox)) {
				aliens.get(i).isActive = false;
				System.out.println("Alien is killed by rocket");
			}
			for (int j = 0; j < projectiles.size(); j++) {
				if (aliens.get(i).collisionBox.intersects(projectiles.get(j).collisionBox)) {
					aliens.get(i).isActive = false;
					projectiles.get(j).isActive = false;
					System.out.println("Alien is killed by projectiles");
				}
			}
		}
		
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		
		for (int t = 0; t < projectiles.size(); t++) {
			if (projectiles.get(t).isActive == false) {
				projectiles.remove(t);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
