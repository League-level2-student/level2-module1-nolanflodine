package intro_to_array_lists;

import java.awt.Rectangle;

public class GameObject {
	   int x;
	    int y;
	 int width;
	 int height;
	 int speed = 0;
	 Rectangle collisionBox;
	  boolean isActive = true;
	 public GameObject(int x, int y, int width, int height) {
		 this.x = x;
		 this.y = y;
		 this.width = width;
		 this.height = height;
		 //this.isActive = isActive;
		 collisionBox = new Rectangle(x,y,width,height);
	 }
	 void update() {
	      collisionBox.setBounds(x, y, width, height);
	 }
}
