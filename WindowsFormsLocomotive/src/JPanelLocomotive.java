import java.awt.Graphics;
import javax.swing.JPanel;

public class JPanelLocomotive extends JPanel {
	ITransport transport;

	public JPanelLocomotive(ITransport transpotr) {			
		this.transport = transpotr;
	}
	public void PanelTrainSet(ITransport transport) {
		this.transport = transport;
	}
	public void paint(Graphics g)  {		
		super.paint(g);		
		if (transport != null)
		transport.DrawTrain(g);
	}
}