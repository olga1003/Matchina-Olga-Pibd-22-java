import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MultiLevelDepot {
	ArrayList<Depot<ITransport, IWagon>> depotStages;
	private final int countPlaces = 20;
	private int pictureWidth;
	private int pictureHeight;
	public MultiLevelDepot(int countStages, int pictureWidth, int pictureHeight) {
		depotStages = new ArrayList<>();
		for (int i = 0; i < countStages; i++) {
			depotStages.add(new Depot<ITransport, IWagon>(countPlaces, pictureWidth, pictureHeight));
		}
	}

	public Depot<ITransport, IWagon> getDepot(int index){

		if ((index > -1) && (index < depotStages.size()))
		{
			return depotStages.get(index);
		}
		return null;
	}

	public ITransport  getTrain(int ind, int level) {
		if (level > -1 &&  level < depotStages.size()) {
			ITransport transport = depotStages.get(level).deleteTrain(ind);
			return transport;
		}
		return null;
	}	
	private void WriteToFile(String text, FileWriter fw) {
		try {
			fw.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean Save(String filename) throws IOException {
		FileWriter fw = new FileWriter(filename);
		WriteToFile("CountLeveles:" + depotStages.size() + "\n", fw);
		for (Depot<ITransport, IWagon> level : depotStages) {
			WriteToFile("Level" + "\n", fw);
			for (int i = 0; i < countPlaces; i++) {
				ITransport train = level.getPlace(i);
				if (train != null) {
					if (train.getClass().getName() == "LocoTrain") {
						WriteToFile(i + ":LocoTrain:", fw);
					}
					if (train.getClass().getName() == "TrainLocomotive") {
						WriteToFile(i + ":TrainLocomotive:", fw);
					}
					WriteToFile(train.toString() + "\n", fw);
				}
			}
		}
		fw.flush();
		return true;
	}

	public boolean Load(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		String bufferTextFromFile = "";
		int counter = -1;
		int c;
		while ((char) (c = fr.read()) != '\n') {
			bufferTextFromFile += (char) c;
		}
		if (bufferTextFromFile.contains("CountLeveles")) {
			int count = Integer.parseInt(bufferTextFromFile.split(":")[1]);
			if (depotStages != null) {
				depotStages.clear();
			}
			depotStages = new ArrayList<Depot<ITransport, IWagon>>(count);
			bufferTextFromFile = "";
		} else {
			return false;
		}
		while ((c = fr.read()) != -1) {
			if ((char) c == '\n') {
				ITransport train = null;
				if (bufferTextFromFile.equals("Level")) {
					counter++;
					depotStages.add(new Depot<ITransport, IWagon>(countPlaces, pictureWidth, pictureHeight));
					bufferTextFromFile = "";
					continue;
				}
				if (bufferTextFromFile.split(":").length > 1) {
					if (bufferTextFromFile.split(":")[1].equals("LocoTrain")) {
						train = new LocoTrain(bufferTextFromFile.split(":")[2]);
					} else if (bufferTextFromFile.split(":")[1].equals("TrainLocomotive")) {
						train = new TrainLocomotive(bufferTextFromFile.split(":")[2]);
					}
					depotStages.get(counter).setPlace(Integer.parseInt(bufferTextFromFile.split(":")[0]), train);
				}
				bufferTextFromFile = "";
			} else {
				bufferTextFromFile += (char) c;
			}
		}
		return true;
	}
	public boolean SaveLevel(String filename, int lvl) throws IOException{
		try {
			if ((lvl > depotStages.size()) || (lvl < 0)) {
				return false;
			}
			FileWriter fw = new FileWriter(filename);
			WriteToFile("Level:" + lvl + "\n", fw);
			Depot<ITransport, IWagon> level = depotStages.get(lvl);
			for (int i = 0; i < countPlaces; i++) {
				ITransport train = level.getPlace(i);
				if (train != null) {
					if (train.getClass().getName() == "LocoTrain") {
						WriteToFile(i + ":LocoTrain:", fw);
					}
					if (train.getClass().getName() == "TrainLocomotive") {
						WriteToFile(i + ":TrainLocomotive:", fw);
					}
					WriteToFile(train.toString() + "\n", fw);
				}
			}
			fw.flush();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean LoadLevel(String filename) throws IOException {
		try {
			FileReader fr = new FileReader(filename);
			String bufferTextFromFile = "";
			int lvl = 0;
			int c;
			while ((char) (c = fr.read()) != '\n') {
				bufferTextFromFile += (char) c;
			}
			if (bufferTextFromFile.contains("Level")) {
				lvl = Integer.parseInt(bufferTextFromFile.split(":")[1]);
				bufferTextFromFile = "";
			} else {
				return false;
			}
			if (depotStages.size() < lvl) {
				return false;
			}
			depotStages.set(lvl, new Depot<ITransport, IWagon>(countPlaces, pictureWidth, pictureHeight));
			while ((c = fr.read()) != -1) {
				if ((char) c == '\n') {
					ITransport train = null;
					if (bufferTextFromFile == null) {
						continue;
					}
					if (bufferTextFromFile.split(":").length > 2) {
						if (bufferTextFromFile.split(":")[1].equals("LocoTrain")) {
							train = new LocoTrain(bufferTextFromFile.split(":")[2]);
						} else if (bufferTextFromFile.split(":")[1].equals("TrainLocomotive")) {
							train = new TrainLocomotive(bufferTextFromFile.split(":")[2]);
						}
						depotStages.get(lvl).setPlace(Integer.parseInt(bufferTextFromFile.split(":")[0]), train);
					}
					bufferTextFromFile = "";
				} else {
					bufferTextFromFile += (char) c;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true; 
	}
}