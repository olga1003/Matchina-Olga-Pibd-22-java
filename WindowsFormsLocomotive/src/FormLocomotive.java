import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class FormLocomotive {
	/*private JFrame frame;
	private ITransport locomotive;
	private JPanelLocomotive panel;
	private JButton start;
	private JButton buttonUp;
	private JButton buttonDown;
	private JButton buttonLeft;
	private JButton buttonRight;
	TrainLocomotive transport;

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
				locomotive =  new LocoTrain( 100, 1000 , Color.BLUE);
				locomotive.SetPosition(100, 100, 550, 400);
				panel = new JPanelLocomotive(locomotive);
				panel.setBorder(new BevelBorder(BevelBorder.LOWERED, 
						null, null, null, null));
				panel.setBounds(10, 11, 551, 414);
				frame.getContentPane().add(panel);
				panel.repaint();
			}
		});
		

		buttonUp = new JButton("^");
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locomotive.MoveTransport(Direction.Up);
				panel.repaint();
			}
		});
		buttonUp.setBounds(626, 360, 50, 20);
		frame.getContentPane().add(buttonUp);

		buttonDown = new JButton("v");
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locomotive.MoveTransport(Direction.Down);
				panel.repaint();
			}
		});
		buttonDown.setBounds(626, 405, 50, 20);
		frame.getContentPane().add(buttonDown);

		buttonLeft = new JButton("<");
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locomotive.MoveTransport(Direction.Left);
				panel.repaint();	
			}
		});
		buttonLeft.setBounds(598, 382, 50, 20);
		frame.getContentPane().add(buttonLeft);

		buttonRight = new JButton(">");
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locomotive.MoveTransport(Direction.Right);
				panel.repaint();
			}
		});
		buttonRight.setBounds(655, 382, 50, 20);
		frame.getContentPane().add(buttonRight);
		
		JButton ButtonCreateLocoTrain = new JButton("\u0441\u043E\u0437\u0434\u0430\u0442\u044C \u0442\u0435\u043F\u043B\u043E\u0432\u043E\u0437");
		ButtonCreateLocoTrain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				locomotive = new TrainLocomotive(100,1000, Color.BLUE,Color.BLACK,  true, true);
				locomotive.SetPosition(100, 100, 550, 400);
				panel = new JPanelLocomotive(locomotive);
				panel.setBorder(new BevelBorder(BevelBorder.LOWERED, 
						null, null, null, null));
				panel.setBounds(10, 11, 551, 414);
				frame.getContentPane().add(panel);
			 
				panel.repaint();
			}
		});
		ButtonCreateLocoTrain.setBounds(588, 284, 144, 25);
		frame.getContentPane().add(ButtonCreateLocoTrain);
	}*/
}
