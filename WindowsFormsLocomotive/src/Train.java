import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

 
public abstract  class Train implements ITransport{

	/// Левая координата отрисовки автомобиля
	static int _startPosX;

	/// Правая кооридната отрисовки автомобиля
	static int _startPosY;

	/// Ширина окна отрисовки
	protected static int _pictureWidth;

	/// Высота окна отрисовки
	protected static int _pictureHeight;

	/// Ширина отрисовки автомобиля
	private  static  int locoWidth = 100;

	/// Ширина отрисовки автомобиля
	private static int locoHeight = 60;

	/// Максимальная скорость
	public  int MaxSpeed; {  Set get;}

	/// Вес автомобиля
	public  float Weight; { Set get;}

	/// Основной цвет кузова
	public static Color MainColor; { Set get;}

	
	
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
