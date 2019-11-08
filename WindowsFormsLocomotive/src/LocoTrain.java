import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class LocoTrain extends Train {
	/// Ўирина отрисовки автомобил€
	private   int locoWidth = 100;

	/// Ўирина отрисовки автомобил€
	private  int locoHeight = 60;
	int design;
    public LocoTrain(int maxSpeed, float weight, Color mainColor) {
        this.MaxSpeed = maxSpeed;
        this.Weight = weight;
        this.MainColor = mainColor;
        Random rnd =new Random();
        design=rnd.nextInt(3)+1;
	}

	public  void MoveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            // вправо
            case Right:
                if (_startPosX + step < _pictureWidth - locoWidth)
                {
                    _startPosX += step;
                }
                break;
            //влево
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            //вверх
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
            //вниз
            case Down:
                if (_startPosY + step < _pictureHeight - locoHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }
	@Override
    public void DrawTrain(Graphics g)
	{
    	switch (design) {
		case 1:
			new LocomotiveWagon().draw(Number.One,g, _startPosX, _startPosY);
			break;
		case 2:
			new LocoWagonForm2().draw(Number.Two,g, _startPosX, _startPosY);
			break;
		case 3:
			new LocoWagonForm3().draw(Number.Three,g, _startPosX, _startPosY);
			break;
		}	
    	g.setColor(Color.BLACK);
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
    }
}
