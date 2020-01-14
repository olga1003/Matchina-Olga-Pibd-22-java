import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class LocoTrain extends Train {
	private   int locoWidth = 100;
	private  int locoHeight = 60;
	IWagon wagon;
	public LocoTrain(int maxSpeed, int weight, IWagon wagon, Color mainColor, Color dopColor) {
		this.MaxSpeed = maxSpeed;
		this.Weight = weight;
		this.MainColor = mainColor;
		this.DopColor = dopColor;
		this.wagon = wagon;
	}
	public LocoTrain(String save)
	{
		String[] mas = save.split(";");
		if (mas.length == 3)
		{
			MaxSpeed = Integer.parseInt(mas[0]);
			MainColor = new Color(Integer.parseInt(mas[1]));
			wagon = toWagonForm(mas[2]);
		}
	}
	public IWagon toWagonForm(String info) {

		if (info.contains("LocomotiveWagonFormNormal")) return new LocomotiveWagonFormNormal();
		if (info.contains("LocoWagonFormOval")) return new LocoWagonFormOval();
		if (info.contains("LocoWagonFormDoubleOval")) return new LocoWagonFormDoubleOval();
		return new LocomotiveWagonFormNormal();
	}
	public void setWagonForm(IWagon wagon) {
		this.wagon = wagon;
	}
	public  void MoveTransport(Direction direction)
	{
		float step = MaxSpeed * 100 / Weight;
		switch (direction)
		{
		// âïðàâî
		case Right:
			if (_startPosX + step < _pictureWidth - locoWidth)
			{
				_startPosX += step;
			}
			break;
			//âëåâî
		case Left:
			if (_startPosX - step > 0)
			{
				_startPosX -= step;
			}
			break;
			//ââåðõ
		case Up:
			if (_startPosY - step > 0)
			{
				_startPosY -= step;
			}
			break;
			//âíèç
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
		wagon.draw(g, _startPosX, _startPosY, MainColor);

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
	@Override
	public String toString() {
		 return MaxSpeed + ";" + MainColor.getRGB() + ";" + wagon.toString();
	}
}
