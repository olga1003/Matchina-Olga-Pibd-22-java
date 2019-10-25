import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class JPanelLocomotive extends JPanel {

	private static LocomotiveWagon wagon;	
	public JPanelLocomotive(TrainLocomotive array) {		
	}
	public JPanelLocomotive(LocomotiveWagon array) {		
	}

	final static Random random = new Random();
	int number = random.nextInt(3)+1;

	public void paint(Graphics g)  {
		super.paint(g);		
		TrainLocomotive.DrawCar(g);
		switch (number)
		{
		case 1:
			LocomotiveWagon.NumberWagon(Number.One, g, TrainLocomotive._startPosX,TrainLocomotive._startPosY);
			break;
		case 2:
			LocomotiveWagon.NumberWagon(Number.Two, g, TrainLocomotive._startPosX,TrainLocomotive._startPosY);
			break;
		case 3:
			LocomotiveWagon.NumberWagon(Number.Three, g, TrainLocomotive._startPosX,TrainLocomotive._startPosY);
			break;          
		}
	}
}
