package intro_to_array_lists;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Box.Filler;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel  implements ActionListener, KeyListener {
	 final int MENU = 0;
	 final int GAME = 1;
	 final int END = 2;
	 public static BufferedImage image;
	 public static boolean needImage = true;
	 public static boolean gotImage = false;
	 Rocketship r = new Rocketship(250, 500, 50, 50);
	 int currentState = MENU;
	 Timer frameDraw;
	 ObjectManager o = new ObjectManager(r);
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	GamePanel(){
		frameDraw=new Timer(1000/60,this);
		frameDraw.start();
		if (needImage) {
		    loadImage ("space.png");
		}
	}
@Override
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
		o.update();
	 }
	 void updateEndState() {
		 
	 }
	 void drawMenuState(Graphics g) { 
		 Font newFont = new Font("Arial", Font.PLAIN, 20);
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, SpaceInvadersRunner.WIDTH, SpaceInvadersRunner.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("LEAGUE INVADERS", 20, 150);
		 g.setFont(newFont);
		 g.drawString("Press ENTER to start", 140, 400);
		 g.drawString("Press SPACE for instructions", 110, 600);


	 }
	 void drawGameState(Graphics g) { 
		 //g.setColor(Color.BLACK);
		 //g.fillRect(0, 0, SpaceInvadersRunner.WIDTH, SpaceInvadersRunner.HEIGHT);
		 g.drawImage(image, 0, 0, SpaceInvadersRunner.WIDTH, SpaceInvadersRunner.HEIGHT, null);
		 o.draw(g);

	 }
	 void drawEndState(Graphics g)  { 
		 Font newFont = new Font("Arial", Font.PLAIN, 20);
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, SpaceInvadersRunner.WIDTH, SpaceInvadersRunner.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("Game Over", 120, 150);
		 g.setFont(newFont);
		 g.drawString("Press ENTER to restart", 140, 400);
		 g.drawString("You killed enemies", 150, 600);


	 }
	 void loadImage(String imageFile) {
		    if (needImage) {
		        try {
		            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
			    gotImage = true;
		        } catch (Exception e) {
		            
		        }
		        needImage = false;
		    }
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		    repaint();
		}else if(currentState == GAME){
		    updateGameState();
		    repaint();
		}else if(currentState == END){
		    updateEndState();
		    repaint();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		        System.out.println("menu");
		    }
		    else if(currentState == MENU){
		    	currentState = GAME; 
		    	System.out.println("game");
		    }
		    else if(currentState == GAME){
		    	currentState = END;	    
		    	System.out.println("end");
		    }
		} 
		if (currentState==GAME) {
			if (e.getKeyCode()==KeyEvent.VK_UP) {
			    System.out.println("UP");
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			    System.out.println("Down");
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			    System.out.println("Left");
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			    System.out.println("Right");
			}
		}
		
		if(r.y>10&&e.getKeyCode()==KeyEvent.VK_UP) {
			r.up();
		}
		if(r.y<700&&e.getKeyCode()==KeyEvent.VK_DOWN) {
			r.down();
		}
		if(r.x>10&&e.getKeyCode()==KeyEvent.VK_LEFT) {
			r.left();
		}
		if(r.x<430&&e.getKeyCode()==KeyEvent.VK_RIGHT) {
			r.right();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
