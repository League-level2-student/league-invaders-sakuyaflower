import javax.swing.JFrame;

public class LeagueInvaders {
public static final int WIDTH = 0;
public static final int HEIGHT = 0;
GamePanel game = new GamePanel();
	public static void main(String[] args) {
	LeagueInvaders invaders = new LeagueInvaders();
	invaders.setup();
	
}
void setup() {	
	
	JFrame JF = new JFrame();
	JF.add(game);
	JF.setSize(500, 800);
	JF.setVisible(true);
}
}
