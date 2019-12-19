import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;
 
public abstract  class Train implements ITransport{
	int _startPosX;
	int _startPosY;
	protected  int _pictureWidth;
	protected int _pictureHeight;
	private int locoWidth = 100;
	private int locoHeight = 60;
	public int MaxSpeed; {  Set get;}
	public float Weight; { Set get;}
	public Color MainColor;  
	public Color DopColor; 
	public int StartPosX() {
		return _startPosX;
	}
	public int StartPosY() {
		return _startPosY;
	}
	public Color MainColor() {
		return MainColor;
	}
	public Color DopColor() {
		return DopColor;
	}
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }
    public abstract void DrawTrain(Graphics g);
    public abstract void MoveTransport(Direction direction);
}