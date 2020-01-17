import java.awt.Graphics;

 import javax.swing.JPanel;

 public class TakePanel  extends JPanel {
	public ITransport transport;
	public IWagon wagon;

 	public void drawTrain(ITransport transport, IWagon wagon ) {
		this.transport = transport;
		this.wagon = wagon;
	}
	public void clear() {
		transport = null;
		wagon = null;
	}
	public void Set(ITransport transport) {
		this.transport = transport;
	}
	public void paint(Graphics g) {
		super.paint(g);
		if (transport != null) {
			transport.DrawTrain(g);
			if (wagon != null) {
				wagon.SetPosition(transport.getStartPosX(), transport.getStartPosY());
				wagon.draw(g, wagon.getPositionX(), wagon.getPositionY(),
						transport.getMainColor());
			}
		}
	}
}