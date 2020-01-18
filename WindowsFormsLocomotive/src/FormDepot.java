import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
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
	int index = 0;
	int selectLevel = 0;
	private  PanelDepot panelDepot;
	private Logger loggerInfo;
	private Logger loggerError;
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
		frame.setBounds(100, 100, 1331, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		loggerInfo = Logger.getLogger("Info");
		loggerError = Logger.getLogger("Errors");
		try {
			FileHandler fhInfo = new FileHandler("infoLogs.txt");
			FileHandler fhError = new FileHandler("errorLogs.txt");
			loggerInfo.addHandler(fhInfo);
			loggerError.addHandler(fhError);
			loggerInfo.setUseParentHandlers(false);
			loggerError.setUseParentHandlers(false);
			SimpleFormatter simpleFormatter = new SimpleFormatter();
			fhInfo.setFormatter(simpleFormatter); 
			fhError.setFormatter(simpleFormatter); 
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

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

		JButton buttonCreate = new JButton("Заказать");
		buttonCreate = new JButton("\u0417\u0430\u043A\u0430\u0437\u0430\u0442\u044C");
		buttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormTrainConfig config = new FormTrainConfig(new TrainDelegate() {
					@Override
					public void Invoke(ITransport transport) {
						if (transport != null && list.getSelectedIndex() > -1) {

							try {
								int place = depot.getDepot(list.getSelectedIndex()).addTrain(transport, wagon);
								loggerInfo.info("Добавлен поезд " + transport.toString() + " на место " + place);
								panelDepot.repaint();
							}
							catch (DepotOverflowException ex)
							{
								loggerError.warning(ex.getMessage());
								JOptionPane.showMessageDialog(null,"Мест нет");
							}
							catch (DepotAlreadyHaveException ex)
							{
								loggerError.warning(ex.getMessage());
								JOptionPane.showMessageDialog(null,"Дублирование");
							}
							catch (Exception ex)
							{
								loggerError.warning(ex.getMessage());
								JOptionPane.showMessageDialog(null,"Неизвестная ошибка");
							}
						}
					}
				});
				config.getFrame().setVisible(true);
			}
		});
		buttonCreate.setBounds(1137, 19, 148, 99);
		frame.getContentPane().add(buttonCreate);
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
				if (list.getSelectedIndex() > -1) {
					if (textFieldIndex.getText() != "") {
						try {
							ITransport train = depot.getDepot(list.getSelectedIndex()).deleteTrain(Integer.parseInt(textFieldIndex.getText()));
							train.SetPosition(panelTake.getWidth() / 2 - 200, panelTake.getHeight() / 2, panelTake.getWidth(),
									panelTake.getHeight());
							panelTake.Set(train);
							hashSetTrain.add(train);
							panelTake.repaint();
							panelDepot.repaint();
							loggerInfo.info("Взяли поезд с места " + textFieldIndex.getText());
						}
						catch (DepotNotFoundException ex)
						{
							JOptionPane.showMessageDialog(null,"Не найдено");
							loggerError.warning(ex.getMessage().toString());
						}
						catch (Exception ex)
						{
							JOptionPane.showMessageDialog(null,"Неизвестная ошибка");
							loggerError.warning(ex.getMessage().toString());
						}
						panelDepot.repaint();
						panelTake.repaint();
					}
				}
			}
		});
		btnTake.setBounds(1045, 219, 97, 25);
		frame.getContentPane().add(btnTake);	

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu mnAll = new JMenu("Файл");
		menuBar.add(mnAll);
		JMenuItem mntmSaveAll = new JMenuItem("Сохранить");
		mntmSaveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser filechooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
					filechooser.setFileFilter(filter);
					int ret = filechooser.showDialog(null, "Сохранить");                
					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = filechooser.getSelectedFile();
						depot.Save(file.getAbsolutePath());
						loggerInfo.info("Сохранено");
						JOptionPane.showMessageDialog(null,"Сохранение прошло успешно");
					}
				}catch (Exception ex) {
					loggerError.warning(ex.getMessage());
					JOptionPane.showMessageDialog(null,"Не сохранилось");
				}
			}
		});
		mnAll.add(mntmSaveAll);

		JMenuItem mntmLoadAll = new JMenuItem("Загрузить");
		mntmLoadAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser filechooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
					filechooser.setFileFilter(filter);
					int ret = filechooser.showDialog(null, "Загрузить");                
					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = filechooser.getSelectedFile();
						depot.Load(file.getAbsolutePath());
						JOptionPane.showMessageDialog(null,"Загрузили");
						loggerInfo.info("Загружено");
						panelDepot.repaint();
					} 
				} catch (DepotOccupiedPlaceException ex) {
					loggerError.warning(ex.getMessage().toString());
					JOptionPane.showMessageDialog(null,"Занятое место");
				} catch (Exception ex) {
					loggerError.warning(ex.getMessage());
					JOptionPane.showMessageDialog(null,"Неизвестная ошибка при загрузке");
				}
			}
		});
		mnAll.add(mntmLoadAll);

		JMenu mnLevel = new JMenu("Уровень");
		menuBar.add(mnLevel);
		JMenuItem mntmSaveLevel = new JMenuItem("Сохранить");
		mntmSaveLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser filechooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("lvl", "lvl");
					filechooser.setFileFilter(filter);
					int ret = filechooser.showDialog(null, "Сохранить");                
					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = filechooser.getSelectedFile();
						depot.SaveLevel(file.getAbsolutePath(), selectLevel);
						loggerInfo.info("Сохранено");
						JOptionPane.showMessageDialog(null,"Сохранение прошло успешно");
						panelDepot.repaint();
					}
				} catch (Exception ex) {
					loggerError.warning(ex.getMessage());
					JOptionPane.showMessageDialog(null,"Не сохранилось");
				}
			}
		});
		mnLevel.add(mntmSaveLevel);

		JMenuItem mntmLoadLevel = new JMenuItem("Загрузить");
		mntmLoadLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser filechooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("lvl", "lvl");
					filechooser.setFileFilter(filter);
					int ret = filechooser.showDialog(null, "Загрузить");                
					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = filechooser.getSelectedFile();
						depot.LoadLevel(file.getAbsolutePath());
						panelDepot.repaint();
						JOptionPane.showMessageDialog(null,"Загрузили");
						loggerInfo.info("Загружено");
					}		
				}catch (DepotOccupiedPlaceException ex) {
					loggerError.warning(ex.getMessage().toString());
					JOptionPane.showMessageDialog(null,"Занятое место");
				}catch (Exception ex) {
					loggerError.warning(ex.getMessage());
					JOptionPane.showMessageDialog(null,"Неизвестная ошибка при сохранении");
				}
			}
		});
		mnLevel.add(mntmLoadLevel);
		panelTake = new TakePanel();
		panelTake.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTake.setBounds(891, 286, 410, 186);
		frame.getContentPane().add(panelTake);
		JButton btnSort = new JButton("\u0421\u043E\u0440\u0442\u0438\u0440\u043E\u0432\u0430\u0442\u044C");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				depot.Sort();
				panelDepot.repaint();
				loggerInfo.info("Сортировка");
				JOptionPane.showMessageDialog(null,"Сортировка произошла успешно");
			}
		});
		btnSort.setBounds(1137, 131, 148, 22);
		frame.getContentPane().add(btnSort);

		JButton buttonGetConfigs = new JButton("\u0412\u044B\u0432\u043E\u0434 \u0441\u0432\u043E\u0439\u0441\u0442\u0432");
		buttonGetConfigs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				depot.printShipsConfig();
			}
		});
		buttonGetConfigs.setBounds(1137, 164, 144, 22);
		frame.getContentPane().add(buttonGetConfigs);
	}
}