import java.awt.Color;
import java.util.*;
import java.awt.Graphics;
import java.lang.Enum;
enum Direction
{
    Up,
    Down,
    Left,
    Right
}
public class TrainLocomotive {
	/// ����� ���������� ��������� ����������
	static int _startPosX;

	/// ������ ���������� ��������� ����������
	static int _startPosY;

	/// ������ ���� ���������
	private static int _pictureWidth;

	/// ������ ���� ���������
	private  static int _pictureHeight;

	/// ������ ��������� ����������
	private  static  int locoWidth = 100;

	/// ������ ��������� ����������
	private static int locoHeight = 60;

	/// ������������ ��������
	public  int MaxSpeed; {  Set get;}

	/// ��� ����������
	public  float Weight; { Set get;}

	/// �������� ���� ������
	public  static Color MainColor; { Set get;}

	/// �������������� ����
	public static Color DopColor; { Set get;}

	/// ������� ������� �����
	public static boolean Steam; { Set get;}

	/// ������� ������� ����
	public static boolean Coal; { Set get;}

	public TrainLocomotive(int maxSpeed, float weight, Color mainColor, Color dopColor,
			boolean steam, boolean coal)
	{
		MaxSpeed = maxSpeed;
		Weight = weight;
		MainColor = mainColor;
		DopColor = dopColor;
		Steam = steam;
		Coal = coal;

	}
	public void SetPosition(int x, int y, int width, int height)
	{
		_startPosX = x;
		_startPosY = y;
		_pictureWidth = width;
		_pictureHeight = height;
	}
	public void MoveTransport(Direction direction)
    {
		
		float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            // ������
            case Right:
                if (_startPosX + step < _pictureWidth - locoWidth)
                {
                    _startPosX += step;
                }
                break;
            //�����
            case Left:
                if (_startPosX - step > 0)
                    
            {
                    _startPosX -= step;
                }
                break;
            //�����
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
            //����
            case Down:
                if (_startPosY + step < _pictureHeight - locoHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }
	
	public static void DrawCar(Graphics g)
	{		
		if (Coal)
		{
			g.setColor(DopColor);
			g.fillOval( _startPosX + 77, _startPosY + 35, 10, 7);
		}	
		g.setColor(DopColor);
		g.fillRect( _startPosX + 25, _startPosY + 25, 10, 15);
		g.fillRect( _startPosX + 43, _startPosY + 30, 7, 10);
		g.fillRect( _startPosX + 20, _startPosY + 55, 70, 7);
		g.setColor(MainColor);
		g.fillRect( _startPosX + 20, _startPosY + 40, 70, 15);
		g.fillRect( _startPosX + 55, _startPosY + 20, 20, 20);

		g.setColor(Color.WHITE);
		g.fillRect(  _startPosX + 56, _startPosY + 22, 18, 18);
		
		g.setColor(Color.RED);
		g.fillOval(   _startPosX + 16, _startPosY + 48, 7, 10);
		g.setColor(Color.YELLOW);
		g.fillOval(   _startPosX + 15, _startPosY + 49, 5, 8);

		g.setColor(Color.DARK_GRAY);
		g.fillOval(  _startPosX + 27, _startPosY + 50, 15, 15);
		g.fillOval(  _startPosX + 48, _startPosY + 50, 15, 15);
		g.fillOval(  _startPosX + 68, _startPosY + 50, 15, 15);
		if (Steam)
		{
			g.setColor(Color.GRAY);
			g.fillOval(_startPosX + 25, _startPosY + 13, 15, 10);
			g.fillOval(_startPosX + 36, _startPosY + 5, 9, 7);

		}
	}

}
