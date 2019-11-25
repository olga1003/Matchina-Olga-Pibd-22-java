import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class JPanelLocomotive extends JPanel {
	ITransport transport;

	public JPanelLocomotive(ITransport transpotr) {	
		this.transport = transpotr;
	}
	public void paint(Graphics g)  {
		super.paint(g);		
		transport.DrawTrain(g);
	}
}
