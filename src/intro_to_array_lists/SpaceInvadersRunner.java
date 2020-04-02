package intro_to_array_lists;

import javax.swing.JFrame;

public class SpaceInvadersRunner {
	static JFrame frame = new JFrame();
	static GamePanel panel = new GamePanel();
	public static final int WIDTH = 500;
	public static final int HEIGHT= 800;
public static void main(String[] args) {
	SpaceInvadersRunner s = new SpaceInvadersRunner();

	s.setup();
	frame.addKeyListener(panel);

}
void setup() {
	frame.setSize(WIDTH, HEIGHT);
	frame.add(panel);
	frame.setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
private void setDefaultCloseOperation(int exitOnClose) {
	// TODO Auto-generated method stub
	
}
}
