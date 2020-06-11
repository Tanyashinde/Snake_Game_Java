package snake_game;

import java.awt.Color;
import java.awt.Graphics;

public class BodyPart {

	private int xcor,ycor,width,height;
	
	public BodyPart(int xcor,int ycor,int tileSize) {
		this.xcor= xcor;
		this.ycor=ycor;
		width=tileSize;
		height= tileSize;
	}
	
	public void tick() {
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(xcor*width,ycor*height,width,height);
	}

	public int getXcor() {
		return xcor;
	}

	public void setXcor(int xcor) {
		this.xcor = xcor;
	}

	public int getYcor() {
		return ycor;
	}

	public void setYcor(int ycor) {
		this.ycor = ycor;
	}
}
