import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {

	public double x, y;
	public int width, height;
	public double dx, dy;
	public double speed = 1.8;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 3;
		this.height = 3;
		
		int angle = new Random().nextInt(2)*180;
		this.dx = Math.cos(Math.toRadians(angle));
		this.dy = Math.sin(Math.toRadians(angle));
	}
	
	public void tick() {
		
		if(y+(dy*speed) + height >= Game.HEIGHT ) {
			dy*=-1;
		}else if(y+(dy*speed) < 0) {
			dy*=-1;
		}
		
		if(x >= Game.WIDTH) {
			System.out.println("Ponto do Jogador!");
			new Game();
			return;
		}else if(x <= 0) {
			System.out.println("Ponto do Inimigo!");
			new Game();
			return;
		}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)), (int)(y+(dy*speed)),width,height);
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);
		if(bounds.intersects(boundsPlayer)) {
			int angle = new Random().nextInt(120-75)+46;
			this.dx = Math.cos(Math.toRadians(angle));
			this.dy = Math.sin(Math.toRadians(angle));
			if(x<0)
				dx*=-1;
			speed+=0.5;
		}else if(bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt(120-75)+46;
			this.dx = Math.cos(Math.toRadians(angle));
			this.dy = Math.sin(Math.toRadians(angle));
			if(x>0)
				dx*=-1;
			speed+=0.5;
		}
		
		x += dx*speed;
		y += dy*speed;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, width, height);
	}
	
}
