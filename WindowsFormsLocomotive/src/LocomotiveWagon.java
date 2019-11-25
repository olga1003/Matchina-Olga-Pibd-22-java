import java.awt.Color;
import java.awt.Graphics;

public   class LocomotiveWagon   implements IWagon{
	public void draw(Number number, Graphics g,  int x ,int y)
	{
		drawWagon(g,x,y); 
		if(number == Number.Two || number == Number.Three) {
			drawWagon(g,x+80,y);           
		}
		if(number == Number.Three) {		  
			drawWagon(g,x+160,y);
		}	
	}		
		
	public void drawWagon(Graphics g, int x,int y) {
		g.setColor(Color.BLUE);
		g.fillRect( x + 100, y + 20, 70, 35);
		g.setColor(Color.WHITE);
		g.fillRect( x + 110, y + 30, 20, 10);
		g.fillRect( x + 140, y + 30, 20, 10);

		g.setColor(Color.BLACK);
		g.fillRect( x + 100, y + 55, 70, 7);
		g.fillRect( x + 90, y + 53, 10, 4);

		g.setColor(Color.DARK_GRAY);
		g.fillOval(  x + 107, y + 50, 15, 15);
		g.fillOval(  x + 127, y + 50, 15, 15);
		g.fillOval(  x + 147, y + 50, 15, 15);	
	}
}

