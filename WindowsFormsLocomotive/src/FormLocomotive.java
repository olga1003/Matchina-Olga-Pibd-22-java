import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class FormLocomotive {
	private JFrame frame;
	private JPanelLocomotive panel;
	private JButton start;
	private JButton buttonUp;
	private JButton buttonDown;
	private JButton buttonLeft;
	private JButton buttonRight;
	TrainLocomotive transpotr;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLocomotive window = new FormLocomotive();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public FormLocomotive() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 762, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 
		start = new JButton("C\u043E\u0437\u0434\u0430\u0442\u044C");
		start.setBounds(598, 322, 106, 25);
		frame.getContentPane().add(start);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transpotr = new TrainLocomotive( 100, 1000 , Color.BLUE, Color.BLACK, true, true);
				transpotr.SetPosition(100, 100, 550, 400);
				panel = new JPanelLocomotive();
				panel.setBorder(new BevelBorder(BevelBorder.LOWERED, 
						null, null, null, null));
				panel.setBounds(10, 11, 551, 414);
				frame.getContentPane().add(panel);
				
				panel.drawLocomotive(transpotr);
				panel.repaint();
			}
		});

		buttonUp = new JButton("^");
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transpotr.MoveTransport(Direction.Up);
				panel.drawLocomotive(transpotr);
				panel.repaint();
			}
		});
		buttonUp.setBounds(626, 360, 50, 20);
		frame.getContentPane().add(buttonUp);

		buttonDown = new JButton("v");
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transpotr.MoveTransport(Direction.Down);
				panel.drawLocomotive(transpotr);
				panel.repaint();
			}
		});
		buttonDown.setBounds(626, 405, 50, 20);
		frame.getContentPane().add(buttonDown);

		buttonLeft = new JButton("<");
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transpotr.MoveTransport(Direction.Left);
				panel.drawLocomotive(transpotr);
				panel.repaint();	
			}
		});
		buttonLeft.setBounds(598, 382, 50, 20);
		frame.getContentPane().add(buttonLeft);

		buttonRight = new JButton(">");
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transpotr.MoveTransport(Direction.Right);
				panel.drawLocomotive(transpotr);
				panel.repaint();				
			}
		});
		buttonRight.setBounds(655, 382, 50, 20);
		frame.getContentPane().add(buttonRight);
	}
}
