import java.awt.Graphics;

 import javax.swing.JPanel;

 public class PanelDepot extends JPanel {
	private Depot<ITransport, IWagon> depot;
	public PanelDepot(Depot<ITransport, IWagon> depot) {
		this.depot = depot;
	}

 	public void paint(Graphics g) {
		super.paint(g);
		depot.draw(g);
	}
} 