import java.awt.Graphics;
import javax.swing.JPanel;

public class JPanelLocomotive extends JPanel {
	TrainLocomotive transpotr;
	public void  drawLocomotive(TrainLocomotive transpotr) {		
		this.transpotr = transpotr;
	}

	public void paint(Graphics g)  {		
		super.paint(g);		
		transpotr.DrawCar(g);
	}
}
