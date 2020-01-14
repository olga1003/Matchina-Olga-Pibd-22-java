import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class FormTrainConfig {

	private JFrame frame;
	TrainDelegate eventAddTrain;
	private ITransport transport;
	private ITransport train;
	private Color Color;
	private IWagon wagon;
	private JPanelLocomotive panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormTrainConfig window = new FormTrainConfig(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JFrame getFrame() {
		return frame;
	}

	public FormTrainConfig(TrainDelegate eventAddTrain) {
		this.eventAddTrain = eventAddTrain;
		initialize();
	
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel labelTrain = new JLabel("\u041F\u043E\u0435\u0437\u0434");
		labelTrain.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				transport = new LocoTrain(100, 1000, new LocomotiveWagonFormNormal(), Color.white, Color.white);
				transport.SetPosition(10 , panel.getHeight() / 3, panel.getWidth(), panel.getHeight());
			} 
			@Override
			public void mouseReleased(MouseEvent e) {
				transport = null;
			}
		});
		labelTrain.setHorizontalAlignment(SwingConstants.CENTER);
		labelTrain.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelTrain.setBounds(18, 13, 260, 117);
		labelTrain.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(labelTrain);

		JLabel labelLocoTrain = new JLabel("\u0422\u0435\u043F\u043B\u043E\u0432\u043E\u0437");
		labelLocoTrain.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				transport =  new TrainLocomotive(100, 1000, Number.One, Color.white, Color.white, new LocomotiveWagonFormNormal(), true, true);
				transport.SetPosition(10 , panel.getHeight() / 3, panel.getWidth(), panel.getHeight());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				transport = null;
			}
		});
		labelLocoTrain.setHorizontalAlignment(SwingConstants.CENTER);
		labelLocoTrain.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelLocoTrain.setBounds(18, 143, 260, 133);
		labelLocoTrain.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(labelLocoTrain);
		
		JLabel labelWagonFormNormal = new JLabel("\u041E\u0432\u0430\u043B\u044C\u043D\u044B\u0435 \u0432\u0430\u0433\u043E\u043D\u044B ");
		labelWagonFormNormal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				wagon = new LocoWagonFormOval();		 
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				wagon = null;
			}
		});
		labelWagonFormNormal.setHorizontalAlignment(SwingConstants.CENTER);
		labelWagonFormNormal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelWagonFormNormal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		labelWagonFormNormal.setBounds(682, 389, 188, 38);
		frame.getContentPane().add(labelWagonFormNormal);
		
		JLabel labelWagonFormOval = new JLabel("\u041F\u0443\u0437\u044B\u0440\u0447\u0430\u0442\u044B\u0435 \u0432\u0430\u0433\u043E\u043D\u044B");
		labelWagonFormOval.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				wagon = new LocoWagonFormDoubleOval();		 
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				wagon = null;
			}
		});
		labelWagonFormOval.setHorizontalAlignment(SwingConstants.CENTER);
		labelWagonFormOval.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelWagonFormOval.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		labelWagonFormOval.setBounds(682, 338, 188, 38);
		frame.getContentPane().add(labelWagonFormOval);
		
		JLabel labelWagonFormDoubleOval = new JLabel("\u0421\u0442\u0430\u043D\u0434\u0430\u0440\u0442\u043D\u044B\u0435 \u0432\u0430\u0433\u043E\u043D\u044B ");
		labelWagonFormDoubleOval.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				wagon = new LocomotiveWagonFormNormal();		 
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				wagon = null;
			}
		});
		labelWagonFormDoubleOval.setHorizontalAlignment(SwingConstants.CENTER);
		labelWagonFormDoubleOval.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelWagonFormDoubleOval.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		labelWagonFormDoubleOval.setBounds(682, 287, 188, 38);
		frame.getContentPane().add(labelWagonFormDoubleOval);

		JButton buttonAdd = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		buttonAdd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventAddTrain.Invoke(train);
				frame.dispose();
			}
		});
		buttonAdd.setBounds(12, 323, 164, 30);
		frame.getContentPane().add(buttonAdd);

		JButton buttonCancel = new JButton("\u041E\u0442\u043C\u0435\u043D\u0430");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonCancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		buttonCancel.setBounds(114, 382, 164, 30);
		frame.getContentPane().add(buttonCancel);

		panel = new JPanelLocomotive(transport);  
		panel.setBounds(304, 11, 356, 160);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (transport != null) {
					train = transport;
					panel.PanelTrainSet(train);
					panel.repaint();
				}
			}
		});
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel);

		JPanel panelBlack = new JPanel();
		panelBlack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.BLACK;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelBlack.setBackground(Color.BLACK);
		panelBlack.setBounds(672, 11, 90, 50);
		frame.getContentPane().add(panelBlack);

		JPanel panelWhite = new JPanel();
		panelWhite.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.WHITE;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelWhite.setBackground(Color.WHITE);
		panelWhite.setBounds(780, 11, 90, 50);
		frame.getContentPane().add(panelWhite);

		JPanel panelBlue = new JPanel();
		panelBlue.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.BLUE;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelBlue.setBackground(Color.BLUE);
		panelBlue.setBounds(672, 200, 90, 50);
		frame.getContentPane().add(panelBlue);

		JPanel panelGreen = new JPanel();
		panelGreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.GREEN;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelGreen.setBackground(Color.GREEN);
		panelGreen.setBounds(780, 137, 90, 50);
		frame.getContentPane().add(panelGreen);

		JPanel panelYellow = new JPanel();
		panelYellow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.YELLOW;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelYellow.setBackground(Color.YELLOW);
		panelYellow.setBounds(672, 137, 90, 50);
		frame.getContentPane().add(panelYellow);

		JPanel panelRed = new JPanel();
		panelRed.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.RED;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelRed.setBackground(Color.RED);
		panelRed.setBounds(672, 74, 90, 50);
		frame.getContentPane().add(panelRed);

		JPanel panelOrange = new JPanel();
		panelOrange.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.ORANGE;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelOrange.setBackground(Color.ORANGE);
		panelOrange.setBounds(780, 70, 90, 54);
		frame.getContentPane().add(panelOrange);

		JPanel panelMagenta = new JPanel();
		panelMagenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.MAGENTA;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelMagenta.setBackground(Color.MAGENTA);
		panelMagenta.setBounds(780, 200, 90, 50);
		frame.getContentPane().add(panelMagenta);

		JLabel labelMainColor = new JLabel("\u041E\u0441\u043D\u043E\u0432\u043D\u043E\u0439 \u0446\u0432\u0435\u0442");
		labelMainColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (Color != null && train != null) {
					train.SetColor(Color);
					panel.repaint();
				}
			}
		});
		labelMainColor.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainColor.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelMainColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelMainColor.setBounds(304, 182, 356, 54);
		frame.getContentPane().add(labelMainColor);

		JLabel labelDopColor = new JLabel("\u0414\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u044B\u0439 \u0446\u0432\u0435\u0442");
		labelDopColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (Color != null && train != null) {
					((TrainLocomotive)train).setDopColor(Color);
					panel.repaint();
				}
			}
		});
		labelDopColor.setHorizontalAlignment(SwingConstants.CENTER);
		labelDopColor.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelDopColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelDopColor.setBounds(304, 273, 356, 54);
		frame.getContentPane().add(labelDopColor);

		JLabel labelAddWagon = new JLabel("\u0414\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u044B\u0439 \u0444\u0443\u043D\u043A\u0446\u0438\u043E\u043D\u0430\u043B");
		labelAddWagon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelAddWagon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (train != null  ) {
					((LocoTrain)train).setWagonForm(wagon);
					panel.repaint();
				}
			}
		});
		labelAddWagon.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddWagon.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelAddWagon.setBounds(304, 367, 356, 60);
		frame.getContentPane().add(labelAddWagon);
	}
}