import javax.swing.JFrame;

public class LeagueInvaders {
public static final int WIDTH = 500;
public static final int HEIGHT = 800;
GamePanel game = new GamePanel();
	public static void main(String[] args) {
	LeagueInvaders invaders = new LeagueInvaders();
	invaders.setup();
	
}
void setup() {	
	
	JFrame JF = new JFrame();
	JF.add(game);
	JF.setSize(WIDTH, HEIGHT);
	JF.setVisible(true);
	JF.addKeyListener(game);
}
}
