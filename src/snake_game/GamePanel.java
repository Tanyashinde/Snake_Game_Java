package snake_game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable,KeyListener{
	
	public static final int width=500, height=500;
	
	private Thread thread;
	
	private BodyPart b;
	private ArrayList<BodyPart> snake;
	
	private int xcor=10,ycor=10,size=5;
	
	private int ticks=0;
	
	private boolean running;
	private boolean right= true,left=false,up=false,down=false;

	public GamePanel() {
		setPreferredSize(new Dimension(width,height));
		snake= new ArrayList<BodyPart>();
		start();
	}
	
	public void start() {
		running= true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop() {
		running= false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void tick() {
		if(snake.size()==0) {
			b= new BodyPart(xcor, ycor, size);
			snake.add(b);
		}
		ticks++;
		if(ticks>250000) {
			if(right) xcor++;
			if(left) xcor--;
			if(up) ycor--;
			if(down) ycor++;
			
			ticks=0;
			b= new BodyPart(xcor, ycor, size);
			snake.add(b);
			
			if(snake.size()>size) {
				snake.remove(0);
			}
		}
	}
	public void paint(Graphics g) {
		g.clearRect(0,0, width,height);
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0,width,height);
		
		for(int i=0;i<width/10;i++) {
			g.drawLine(i*10,0,i*10,height);
		}
		for(int i=0;i<height/10;i++) {
			g.drawLine(0,i*10,height,i*10);
		}
		for(int i=0;i<snake.size();i++) {
			snake.get(i).draw(g);
		}
	}

	@Override
	public void run() {
		while(running) {
			tick();
			repaint();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
