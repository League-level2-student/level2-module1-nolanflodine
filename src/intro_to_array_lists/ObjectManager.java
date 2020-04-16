package intro_to_array_lists;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ObjectManager {
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
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		if (Alien.y>SpaceInvadersRunner.HEIGHT||Alien.y<0) {
			Alien.isActive=false;
			System.out.println("poof");
		}
		if (Projectile.y>SpaceInvadersRunner.HEIGHT||Alien.y<0) {
			Projectile.isActive=false;
			System.out.println("poof");
		}
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
			if(Alien.isActive==false) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if(Projectile.isActive==false) {
				projectiles.remove(i);
			}
		}
	}
	}


