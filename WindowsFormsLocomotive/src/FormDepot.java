import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class FormDepot {

	private JFrame frame;
	private final int panelPierWidth = 870;
	private final int panelPierHeight = 460;
	private ITransport locomotive;
	private final int countLevels = 5;
	private MultiLevelDepot depot;
	private HashSet<ITransport> hashSetTrain = new HashSet<ITransport>();
	private HashSet<IWagon> hashSetWagon = new HashSet<IWagon>();
	private ITransport transport;
	private IWagon wagon;
	private int storageIndex = 0;
	private TakePanel panelTake;
	private JTextField textFieldIndex;
	static int choiceOperator = 0;
	private JList<String> list;
	private  PanelDepot panelDepot;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDepot window = new FormDepot();
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
	public FormDepot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1331, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		depot = new MultiLevelDepot(countLevels, panelPierWidth, panelPierHeight);

		panelDepot = new PanelDepot(depot.getDepot(0));
		panelDepot.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDepot.setBounds(10, 11, panelPierWidth, panelPierHeight);
		frame.getContentPane().add(panelDepot);

		String[] levels = new String[countLevels];
		for(int i = 0; i < countLevels; i++) {
			levels[i] = "Уровень " + (i + 1);
		}
		list = new JList(levels);
		list.setSelectedIndex(0);
		list.setBounds(890, 11, 214, 186);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				int index = list.getSelectedIndex();
				panelDepot.setDepot(depot.getDepot(index));
				panelDepot.repaint();
			}
		});
		frame.getContentPane().add(list);

		JButton btnTrain = new JButton("Train");
		btnTrain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color newColor = JColorChooser.showDialog(frame, "", Color.blue);
				if (newColor != null) {
					transport = new LocoTrain(100, 1000, newColor, Color.blue);
					Random rnd = new Random();
					switch (rnd.nextInt(3)) {
					case 0:
						wagon = new LocomotiveWagonFormNormal();
						break;
					case 1:
						wagon = new LocoWagonFormOval();
						break;
					case 2:
						wagon = new LocoWagonFormDoubleOval();
						break;
					}
					int place = depot.getDepot(list.getSelectedIndex()).addTrain(transport, wagon);
					panelDepot.repaint();
				}
			}
		});
		btnTrain.setBounds(1153, 130, 97, 25);
		frame.getContentPane().add(btnTrain);

		JButton btnLocoTrain = new JButton("LocoTrain");
		btnLocoTrain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color mainColor = JColorChooser.showDialog(frame, "Выберите основной цвет", Color.blue);
				if (mainColor != null) {
					Color dopColor = JColorChooser.showDialog(frame, "Выберите дополнительный цвет", Color.blue);
					if (dopColor != null) {
						transport = new TrainLocomotive(100, 1000, Number.One, mainColor, dopColor, true, true);
						Random rnd = new Random();
						switch (rnd.nextInt(3)) {
						case 0:
							wagon = new LocomotiveWagonFormNormal();
							break;
						case 1:
							wagon = new LocoWagonFormOval();
							break;
						case 2:
							wagon = new LocoWagonFormDoubleOval();
							break;
						}
						int place = depot.getDepot(list.getSelectedIndex()).addTrain(transport, wagon);
						panelDepot.repaint();
					}
				}
			}
		});
		btnLocoTrain.setBounds(1153, 157, 97, 25);
		frame.getContentPane().add(btnLocoTrain);
		JLabel label = new JLabel("\u0417\u0430\u0431\u0440\u0430\u0442\u044C \u043F\u043E\u0435\u0437\u0434:");
		label.setBounds(915, 199, 122, 14);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		label_1.setBounds(912, 224, 48, 14);
		frame.getContentPane().add(label_1);

		textFieldIndex = new JTextField();
		textFieldIndex.setBounds(972, 226, 51, 22);
		frame.getContentPane().add(textFieldIndex);
		textFieldIndex.setColumns(10);

		JButton btnTake = new JButton("Take");
		btnTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldIndex.getText() != "") {
					transport = depot.getTrain(list.getSelectedIndex(),Integer.parseInt(textFieldIndex.getText()));
					if (transport != null) {
						panelTake.clear();
						hashSetTrain.add(transport); 
						if (wagon != null) {
							panelTake.drawTrain(transport, wagon);
							hashSetWagon.add(wagon); 
						} else {
							panelTake.drawTrain(transport, wagon);
						}
						storageIndex++;
						panelTake.transport.SetPosition(30, 50, panelPierWidth, panelPierHeight);
						panelDepot.repaint();
						panelTake.repaint();
					}
				}
			}
		});
		btnTake.setBounds(1045, 219, 97, 25);
		frame.getContentPane().add(btnTake);

		panelTake = new TakePanel();
		panelTake.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTake.setBounds(891, 286, 410, 186);
		frame.getContentPane().add(panelTake);
	}
}
