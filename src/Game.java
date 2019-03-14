import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
@SuppressWarnings("serial")
public class Game extends JPanel{
	
	
	
	
	JTextArea time = new JTextArea();
	Prey p = new Prey();
	Hunter h1 = new Hunter();
	Hunter h2 = new Hunter();
	Hunter h3 = new Hunter();
	Hunter h4 = new Hunter();
	Hunter h5 = new Hunter();
	boolean b = false;
	boolean control = true;
	/*
	public void paint(Graphics g){
		super.paint(g);
		if(p.check())
			repaint();
		g.setColor(Color.BLACK);
		g.fillRect(p.X_POSITION-5,p.Y_POSITION-5,5,5);
		
		g.fillOval(h1.X_POSITION, h1.Y_POSITION,10,10);
		g.setColor(Color.PINK);
	}
	
*/
	public void properPlaces(){
		h1.X_POSITION = 25;
		h1.Y_POSITION = 25;
		
		h2.X_POSITION = 200;
		h2.Y_POSITION = 25;
		
		h3.X_POSITION = 350;
		h3.Y_POSITION = 150;
		
		h4.X_POSITION = 25;
		h4.Y_POSITION = 350;
		
		h5.X_POSITION = 350;
		h5.Y_POSITION = 350;
		
	}
	
	public void getPlacesForHunters(){
		Hunter[] hunters = new Hunter[5];
		hunters[0] = h1;
		hunters[1] = h2;
		hunters[2] = h3;
		hunters[3] = h4;
		hunters[4] = h5;
		for(int i = 0 ; i < 5 ; i++){
			
			
			boolean xControl = true;
			boolean yControl = true;
			int x = 0 ; 
			int y = 0;
			while(xControl || yControl){
				if(xControl){
					int i2 = 0;
					x = getRandomCoord();
					for(int i3 = 0 ; i < 5 ; i++){
						int far = hunters[i3].X_POSITION - x;
						if(far < 0)
							far = -1 * far;
						if(far > 13)
							i2++;
					}
					
					int far = p.X_POSITION - x;
					if(far < 0)
						far = -1 * far;
					if(far > 13)
						i2++;
					
					if(i2 == 6)
						xControl = false;
				}
				
				if(yControl){
					
					int i2 = 0;
					y = getRandomCoord();
					for(int i3 = 0 ; i < 5 ; i++){
						int far = hunters[i3].Y_POSITION - y;
						if(far < 0)
							far = -1 * far;
						if(far > 13)
							i2++;
					}
					
					int far = p.Y_POSITION - y;
					if(far < 0)
						far = -1 * far;
					if(far > 13)
						i2++;
					
					if(i2 == 6)
						yControl = false;
					
					
				}
			}
			hunters[i].X_POSITION = x;
			hunters[i].Y_POSITION = y;
			
			
			
			
		}
	}
	
	public void getPlacesForPrey(){
		Hunter[] hunters = new Hunter[5];
		hunters[0] = h1;
		hunters[1] = h2;
		hunters[2] = h3;
		hunters[3] = h4;
		hunters[4] = h5;
			
			
			boolean xControl = true;
			boolean yControl = true;
			int x = 0 ; 
			int y = 0;
			while(xControl || yControl){
				if(xControl){
					int i2 = 0;
					x = getRandomCoord();
					for(int i3 = 0 ; i3 < 5 ; i3++){
						int far = hunters[i3].X_POSITION - x;
						if(far < 0)
							far = -1 * far;
						if(far > 13)
							i2++;
					}
					
					if(i2 == 5)
						xControl = false;
				}
				
				if(yControl){
					
					int i2 = 0;
					y = getRandomCoord();
					for(int i3 = 0 ; i3 < 5 ; i3++){
						int far = hunters[i3].Y_POSITION - y;
						if(far < 0)
							far = -1 * far;
						if(far > 13)
							i2++;
					}
					
					int far = p.Y_POSITION - y;
					if(far < 0)
						far = -1 * far;
					if(far > 13)
						i2++;
					
					if(i2 == 6)
						yControl = false;
					
					
				}
		}
			
		p.X_POSITION = x;
		p.Y_POSITION = y;
			
	}
	
	
	public void killHunter(){
		
		
		
		if(isHunterDead()){
			Hunter[] hunters = new Hunter[5];
			hunters[0] = h1;
			hunters[1] = h2;
			hunters[2] = h3;
			hunters[3] = h4;
			hunters[4] = h5;
			
			int num = whichHunterIsDead();
			boolean xControl = true;
			boolean yControl = true;
			int x = 0 ; 
			int y = 0;
			while(xControl || yControl){
				if(xControl){
					int i2 = 0;
					x = getRandomCoord();
					for(int i = 0 ; i < 5 ; i++){
						int far = hunters[i].X_POSITION - x;
						if(far < 0)
							far = -1 * far;
						if(far > 13)
							i2++;
					}
					
					int far = p.X_POSITION - x;
					if(far < 0)
						far = -1 * far;
					if(far > 13)
						i2++;
					
					if(i2 == 6)
						xControl = false;
				}
				
				if(yControl){
					
					int i2 = 0;
					y = getRandomCoord();
					for(int i = 0 ; i < 5 ; i++){
						int far = hunters[i].Y_POSITION - y;
						if(far < 0)
							far = -1 * far;
						if(far > 13)
							i2++;
					}
					
					int far = p.Y_POSITION - y;
					if(far < 0)
						far = -1 * far;
					if(far > 13)
						i2++;
					
					if(i2 == 6)
						yControl = false;
					
					
				}
			}
			hunters[num].X_POSITION = x;
			hunters[num].Y_POSITION = y;
			
		}
			
	}
	
	public int whichHunterIsDead(){
		int num = (int)(Math.random() * 4) + 0;
		return num;
	}
	
	public boolean isHunterDead(){
		int num = (int)(Math.random() * 4) + 0;
		if(num == 0)
			return true;
		else 
			return false;
	}
	
	public int getRandomNum(){
   		   return (int)(Math.random() * 8) + 0;
	}
	
	public int getRandomCoord(){
		   return (int)(Math.random() * 351) + 25;
	}
	
	
	public double howFar(int x1,int y1,int x2 , int y2){
		
		int num1 = x1 - x2;
		if (num1 < 0 )
			num1 = num1 * -1;
		
		int num3 = y1 - y2;
		if (num3 < 0 )
			num3 = num3 * -1;
		
		double sum = num1 + num3;
		double result = Math.sqrt(sum);
		
		return sum;
		
	}
	
	public boolean isEaten(){
		Hunter[] hunters = new Hunter[5];
		hunters[0] = h1;
		hunters[1] = h2;
		hunters[2] = h3;
		hunters[3] = h4;
		hunters[4] = h5;

		int Px = p.X_POSITION + 5;
		int Py = p.Y_POSITION + 5;
		
		for(int i = 0 ; i < 5 ; i++){
			int Hx = 0;
			int Hy = 0;
			Hx = hunters[i].X_POSITION + 12;
			Hy = hunters[i].Y_POSITION + 12;
			
			if(howFar(Px, Py, Hx, Hy) < 10)
				return true;
			
			
		}
		return false;
	}
	public void checkHunters(){

		Hunter[] hunters = new Hunter[5];
		hunters[0] = h1;
		hunters[1] = h2;
		hunters[2] = h3;
		hunters[3] = h4;
		hunters[4] = h5;

		for(int i = 0 ; i < 5 ; i++){
			hunters[i].check();
		}
		repaint();
		
	}
	public void changeHunterDirection(){
		if(isEaten()){
			return;
		}
		Hunter[] hunters = new Hunter[5];
		hunters[0] = h1;
		hunters[1] = h2;
		hunters[2] = h3;
		hunters[3] = h4;
		hunters[4] = h5;
		
		for(int i = 0 ; i < 5 ; i++){
			int num = getRandomNum();
			hunters[i].movingPosition = num;
		}
	}
	
	public void moveHunters(){
		
		if(isEaten()){
			return;
		}
		checkHunters();
		Hunter[] hunters = new Hunter[5];
		hunters[0] = h1;
		hunters[1] = h2;
		hunters[2] = h3;
		hunters[3] = h4;
		hunters[4] = h5;

		for(int i = 0 ; i < 5 ; i++){
			int num = hunters[i].movingPosition;
//0 = up ; 1 is down ; 2 is left ; 3 is right 4,5,6,7 is diagonal 4left up ; 5 right up...
			hunters[i].move(num);
		}
		repaint();
	}
	@Override
	protected void paintComponent(Graphics g){
		if(isEaten()){
			return;
		}
		Hunter[] hunters = new Hunter[5];
		hunters[0] = h1;
		hunters[1] = h2;
		hunters[2] = h3;
		hunters[3] = h4;
		hunters[4] = h5;
		super.paintComponent( g );
//		if(p.check())
//			repaint();
		for(int i = 0 ; i < 5 ; i++){
			hunters[i].check();
			repaint();
		}
		Graphics2D g2d = (Graphics2D)g.create();
		if(control){
			Shape rectangle = new Rectangle(p.X_POSITION-5,p.Y_POSITION-5,10,10);
			g2d.setColor( Color.red );
			g2d.fill( rectangle );
		}
		if(p.check()){
//			g2d.clearRect(p.X_POSITION-5, p.Y_POSITION-5,10,10);
			repaint();
		}
		
		
		Shape oval = new Ellipse2D.Double(h1.X_POSITION,h1.Y_POSITION, 25, 25);
		g2d.setColor( Color.GREEN );
		g2d.fill( oval );
		
		Shape oval2 = new Ellipse2D.Double(h2.X_POSITION,h2.Y_POSITION, 25, 25);
		g2d.setColor( Color.GREEN );
		g2d.fill( oval2 );
		
		Shape oval3 = new Ellipse2D.Double(h3.X_POSITION,h3.Y_POSITION, 25, 25);
		g2d.setColor( Color.GREEN );
		g2d.fill( oval3 );
	
		Shape oval4 = new Ellipse2D.Double(h4.X_POSITION,h4.Y_POSITION, 25, 25);
		g2d.setColor( Color.GREEN );
		g2d.fill( oval4 );
			
		Shape oval5 = new Ellipse2D.Double(h5.X_POSITION,h5.Y_POSITION, 25, 25);
		g2d.setColor( Color.GREEN );
		g2d.fill( oval5 );
	/*	if(p.X_POSITION - h1.X_POSITION <= 10){
			g2d.dispose();
			g.drawString("DIED",100, 100);
			g.setColor(Color.WHITE);
			
		
		}
	*/
	}

}
