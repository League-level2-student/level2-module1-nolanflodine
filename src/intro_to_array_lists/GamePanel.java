package intro_to_array_lists;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	 final int MENU = 0;
	 final int GAME = 1;
	 final int END = 2;
	 int currentState = MENU;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);

	 public void paintComponent(Graphics g){
		 if(currentState == MENU){
			    drawMenuState(g);
			}else if(currentState == GAME){
			    drawGameState(g);
			}else if(currentState == END){
			    drawEndState(g);
			}
	}
	 void updateMenuState(){
		 
	 }
	 void updateGameState() {
		 
	 }
	 void updateEndState() {
		 
	 }
	 void drawMenuState(Graphics g) { 
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, SpaceInvadersRunner.WIDTH, SpaceInvadersRunner.HEIGHT);
	 }
	 void drawGameState(Graphics g) { 
		 
	 }
	 void drawEndState(Graphics g)  { 
		 
	 }
}
