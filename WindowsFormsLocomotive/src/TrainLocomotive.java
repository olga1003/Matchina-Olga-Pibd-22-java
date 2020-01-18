import java.awt.Color;
import java.util.*;
import java.awt.Graphics;
import java.lang.Enum;
public class TrainLocomotive extends LocoTrain {
	public  Color DopColor; { Set get;}
	public  boolean Steam; { Set get;}
	public  boolean Coal; { Set get;}
	private Number number;
	public TrainLocomotive(int maxSpeed, int weight,Number number, Color mainColor, Color dopColor, IWagon wagon,
			boolean steam, boolean coal) {
		super(maxSpeed, weight,wagon, mainColor, dopColor);
		this.DopColor = dopColor;
		this.Steam = steam;
		this.Coal = coal;
		this.number = number;
	}
	public TrainLocomotive(String save)
	{
		super(save);
		String[] mas = save.split(";");
		if (mas.length == 6)
		{
			MaxSpeed = Integer.parseInt(mas[0]);
			MainColor = new Color(Integer.parseInt(mas[1]));
			wagon = toWagonForm(mas[2]);
			DopColor = new Color(Integer.parseInt(mas[3]));
			Coal = Boolean.parseBoolean(mas[4]);
			Steam = Boolean.parseBoolean(mas[5]);
		}
	}
	@Override
	public String toString()
	{
		return super.toString() + ";" + DopColor.getRGB()+ ";" + Coal + ";" + Steam;
	}
	public void setWagon(IWagon wagon) {
		wagon = wagon;
	}
	public void setDopColor(Color DopColor) {
		this.DopColor = DopColor;
	}
	@Override	
	public  void DrawTrain(Graphics g)
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
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public boolean equals(TrainLocomotive other) {
		if (Steam != other.Steam)
			return false;
		if (Coal != other.Coal)
			return false;
		if (!MainColor.equals(other.MainColor))
			return false;
		if (!DopColor.equals(other.DopColor))
			return false;
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return equals((TrainLocomotive)obj);
	}

	public int compareTo(TrainLocomotive other) {
		if (other == null)
			return 1;
        if (!DopColor.equals(other.DopColor))
        	return Integer.compare(DopColor.getRGB(), other.DopColor.getRGB());
        if (Coal != other.Coal)
        	return Boolean.compare(Coal, other.Coal);
        if (Steam != other.Steam)
        	return Boolean.compare(Steam, other.Steam);
        return 0;
	}
}