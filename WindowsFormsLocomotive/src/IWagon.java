import java.awt.Graphics;
import java.awt.Color;
public interface IWagon {
	void draw(Graphics g,  int x ,int y,Color maiColor);
	void SetPosition(int x, int y);
	public int PositionX();
	public int PositionY();
}
