import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
enum Number
{
	One,
	Two,
	Three
}
public class LocomotiveWagon {

	public static void NumberWagon(Number number, Graphics g,  int x ,int y)
	{
		DrawWagon(g,x,y); 
		
		if(number == Number.Two || number == Number.Three) {
	
			DrawWagon(g,x+80,y);           
		}
		if(number == Number.Three) {		  
  	
			DrawWagon(g,x+160,y);
		}
	}
	public static void DrawWagon(Graphics g, int x,int y) {
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
