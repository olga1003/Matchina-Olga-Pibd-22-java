import java.awt.Color;
import java.util.*;
import java.awt.Graphics;
import java.lang.Enum;


public class TrainLocomotive extends LocoTrain {
	public  Color DopColor; { Set get;}
	public  boolean Steam; { Set get;}
	public  boolean Coal;{ Set get;}

	public TrainLocomotive(int maxSpeed, float weight, Color mainColor, Color dopColor,
			boolean steam, boolean coal) {
		super(maxSpeed, weight, mainColor);
		this.DopColor = dopColor;
		this.Steam = steam;
		this.Coal = coal;
	}
	@Override
	public  void  DrawTrain(Graphics g)
	{	
		if (Coal)
		{
			g.setColor(DopColor);
			g.fillOval( _startPosX + 77, _startPosY + 35, 10, 7);		
		}
		if (Steam)
		{
			g.setColor(Color.GRAY);
			g.fillRect( _startPosX + 25, _startPosY + 25, 10, 15);
			g.fillOval(_startPosX + 25, _startPosY + 13, 15, 10);
			g.fillOval(_startPosX + 36, _startPosY + 5, 9, 7);
			g.setColor(DopColor);
			g.fillRect( _startPosX + 25, _startPosY + 25, 10, 15);
		}
		super.DrawTrain(g);   
	}
}

