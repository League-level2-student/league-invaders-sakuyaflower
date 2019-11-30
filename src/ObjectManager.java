import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocket;
	static ArrayList<Projectile> projectiles = new ArrayList();
	Random random = new Random();

	ArrayList<Alien> aliens = new ArrayList();

	ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}

	static void addProjectile(Projectile projectile) {
		projectiles.add(projectile);

	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
System.out.println("add");
	}

	void update() {
		rocket.update();
		
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if (aliens.get(i).y <= LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
			if (projectiles.get(i).y <= LeagueInvaders.HEIGHT) {
				projectiles.get(i).isActive = false;
			}
	}
	}

	void draw(Graphics g) {
	
		rocket.draw(g);
System.out.println("num aliens" + aliens.size());	
		for(int i = 0; i< aliens.size(); i++) {
		aliens.get(i).draw(g);
	}
		System.out.println("num pro" + projectiles.size());	
		for(int i = 0; i< projectiles.size(); i++) {
		projectiles.get(i).draw(g);
	}
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.remove(aliens);
			projectiles.remove(projectiles);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
