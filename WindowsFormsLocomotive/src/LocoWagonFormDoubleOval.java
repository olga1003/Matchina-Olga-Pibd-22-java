import java.awt.Color;
import java.awt.Graphics;
public  class LocoWagonFormDoubleOval implements IWagon{ 
	private int positionX;
	private int positionY;
	public int PositionX() {
		return positionX;
	}
	public int PositionY() {
		return positionY;
	}

	public void SetPosition(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	@Override
	public void draw(Graphics g,  int x ,int y,Color mainColor)
	{
		drawWagon(g,x,y,mainColor); 	
		drawWagon(g,x+80,y,mainColor);           
		drawWagon(g,x+160,y,mainColor);
	}		
	public  void drawWagon(Graphics g, int x,int y,Color mainColor) {
		g.setColor(mainColor);
		g.fillRect( x + 100, y + 40, 70, 15);
		g.fillOval( x + 105, y + 20, 30, 30);
		g.fillOval( x + 135, y + 20, 30, 30);
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