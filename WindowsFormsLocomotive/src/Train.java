import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;
 
public abstract  class Train implements ITransport{

	/// Левая координата отрисовки автомобиля
	int _startPosX;

	/// Правая кооридната отрисовки автомобиля
	int _startPosY;

	/// Ширина окна отрисовки
	protected  int _pictureWidth;

	/// Высота окна отрисовки
	protected int _pictureHeight;

	/// Ширина отрисовки автомобиля
	private int locoWidth = 100;

	/// Ширина отрисовки автомобиля
	private int locoHeight = 60;

	/// Максимальная скорость
	public int MaxSpeed; {  Set get;}

	/// Вес автомобиля
	public float Weight; { Set get;}

	/// Основной цвет кузова
	public Color MainColor; { Set get;}	
	
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
