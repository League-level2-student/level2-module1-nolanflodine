package intro_to_array_lists;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
ArrayList<Projectile> projectiles;
ArrayList<Alien> aliens;
Random random;
Rocketship r;
	public ObjectManager(Rocketship r) {
		this.r =  r;
		projectiles = new ArrayList<Projectile>();
		aliens = new ArrayList<Alien>();
		random = new Random();
	}
	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	void addAlien() {
		aliens.add(new Alien(random.nextInt(SpaceInvadersRunner.WIDTH),0,50,50));
	}
	
	void update() {
		r.update();
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if (aliens.get(i).y>SpaceInvadersRunner.HEIGHT) {
				aliens.get(i).isActive=false;
				System.out.println("poof");
		}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
			if (projectiles.get(i).y>SpaceInvadersRunner.HEIGHT||projectiles.get(i).y<=0) {
				projectiles.get(i).isActive=false;
				System.out.println("poof");

			}	
			}
		checkCollision();
		purgeObjects();
			}
		
	void draw(Graphics g) {
		r.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		
	}
	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if(aliens.get(i).isActive==false) {
				aliens.remove(i);
 				
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i).isActive==false) {
				projectiles.remove(i);
			}
		}
	}
	
	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if(r.collisionBox.intersects(aliens.get(i).collisionBox)) {
				aliens.get(i).isActive = false;
				r.isActive = false;
			}
			for (int j = 0; j < projectiles.size(); j++) {
				if(projectiles.get(j).collisionBox.intersects(aliens.get(i).collisionBox)) {
					projectiles.get(j).isActive = false;
					aliens.get(i).isActive = false;
				}
			}
		
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
	}


