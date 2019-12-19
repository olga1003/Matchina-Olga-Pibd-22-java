import java.util.ArrayList;

public class MultiLevelDepot {
	ArrayList<Depot<ITransport, IWagon>> depotStages;
	private final int countPlaces = 20;
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
}
