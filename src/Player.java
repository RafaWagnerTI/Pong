import java.awt.Color;
import java.awt.Graphics;

public class Player {

	public boolean right, left;
	public int x, y, width, height;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 5;
		this.height = 40;
	}
	
	public void tick() {
		if(right) {
			y++;
		}
		else if(left) {
			y--;
		}
		
		if(y+height > Game.HEIGHT) {
			y = Game.HEIGHT-height;
		}
		else if(y < 0) {
			y = 0;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	}
	
}
