import java.awt.Color;
import java.awt.Graphics;

public class LocomotiveWagonFormNormal  implements IWagon{
	private int positionX;
	private int positionY;
	public int getPositionX() {
		return positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void SetPosition(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	public void draw(Graphics g,  int x ,int y,Color mainColor)
	{
		drawWagon(g,x,y,mainColor); 	
		drawWagon(g,x+80,y,mainColor);           
		drawWagon(g,x+160,y,mainColor);
	}		
	public void drawWagon(Graphics g, int x,int y,Color mainColor) {
		g.setColor(mainColor);

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
	public String toString() {
		return "LocomotiveWagonFormNormal";
	}
}
