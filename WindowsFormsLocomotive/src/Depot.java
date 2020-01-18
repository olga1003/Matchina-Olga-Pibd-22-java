import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class Depot<T extends ITransport, W extends IWagon> implements
Comparable<Depot<T, W>>, Iterable<T>, Iterator<T> {
	private HashMap<Integer, T> places;
	private HashMap<Integer, W> placesWagon;
	private int pictureWidth;{Set get;}
	private int pictureHeight; {Set get;}
	private final int placeSizeWidth = 400;
	private final int placeSizeHeight = 80;
	int maxCount;
	private int curIndex;
	public Depot(int sizes, int pictureWidth, int pictureHeight)
	{
		this.places =  new HashMap<>(sizes);
		this.placesWagon =  new HashMap<>(sizes);
		this.pictureWidth = pictureWidth;
		this.pictureHeight = pictureHeight;
		this.maxCount = sizes;
	}
	public T getPlace(int i) throws DepotNotFoundException {
		if (places.containsKey(i)) {
			return places.get(i);
		}
		return null;
	}
	public int addTrain(T train, W wagon) throws DepotOverflowException, DepotAlreadyHaveException {
    	if((places.containsValue(train)) && (placesWagon.containsValue(wagon)))
			throw new DepotAlreadyHaveException();
		if (places.size() == maxCount)
		{
			throw new	DepotOverflowException();
		}
		for (int i = 0; i < maxCount; i++)
		{
			if (checkFreePlace(i))
			{
				places.put(i, train);
				places.get(i).SetPosition(5 + i / 5 * placeSizeWidth + 50, 
						i % 5 * placeSizeHeight + 45, this.pictureWidth, this.pictureHeight);
				placesWagon.put(i, wagon);				 
				return i;
			}       	
		}
		throw new	DepotOverflowException();
	}
	public T deleteTrain(int index)  throws DepotNotFoundException{
		if (index < 0 || index > maxCount)
			throw new DepotNotFoundException(index);
		if (!checkFreePlace(index))
		{
			T train = places.get(index);
			places.remove(index);
			return train;
		}
		throw new DepotNotFoundException(index);
	}
	public boolean moreEquals(int countplace) {	
		int FreePlace = 0;	
		for (int i = 0; i < maxCount; i++) {	
			if (checkFreePlace(i)) {	
				FreePlace++;	
			}	
		}	
		if(FreePlace <= countplace) {	
			return true; 	
		}else      	
			return false;	
	}	
	public boolean lessEquals(int countplace) {	
		int FreePlace = 0;	
		for (int i = 0; i < maxCount; i++) {	
			if (checkFreePlace(i)) {	
				FreePlace++;	
			}	
		}	
		if(FreePlace >= countplace) {	
			return true; 	
		}else      	
			return false;	
	}
	public void setPlace(int i, T value) throws DepotOccupiedPlaceException{
		if (checkFreePlace(i))
		{
			places.put(i, value);
			places.get(i).SetPosition(5 + i / 5 * placeSizeWidth + 50, 
					i % 5 * placeSizeHeight + 45, this.pictureWidth, this.pictureHeight);
		}
		else throw new DepotOccupiedPlaceException(i);
	}
	private boolean checkFreePlace(int index)
	{
		return !(places.containsKey(index));
	}
	public void draw(Graphics g)
	{
		DrawMarking(g);
		for (int i = 0; i < maxCount; i++)
		{
			if (!checkFreePlace(i))
			{
				places.get(i).DrawTrain(g);			  	
			}
		}        
	}

	private void DrawMarking(Graphics g)
	{
		g.setColor(Color.BLACK); 
		//границы праковки
		for (int i = 0; i < maxCount / 5; i++)             
		{//отрисовываем, по 5 мест на линии
			for (int j = 0; j < 5; ++j)
			{//линия рамзетки места
				g.drawLine(i * placeSizeWidth, j * placeSizeHeight+100,
						i * placeSizeWidth + 1000, j * placeSizeHeight+100);
				g.drawLine(i * placeSizeWidth, j * placeSizeHeight+110,
						i * placeSizeWidth + 1000, j * placeSizeHeight+110);
				g.drawLine(i * placeSizeWidth+60, j* placeSizeHeight+100, i * placeSizeWidth + 70,j* placeSizeHeight + 110);
				g.drawLine(i * placeSizeWidth+110, j* placeSizeHeight+100, i * placeSizeWidth + 120,j* placeSizeHeight + 110);
				g.drawLine(i * placeSizeWidth+10, j* placeSizeHeight+100, i * placeSizeWidth + 20,j* placeSizeHeight + 110);

			}
		}
	}
	 public int getKey() {
	    	return (int)places.keySet().toArray()[curIndex];
	    }
	    public int compareTo(Depot<T, W> other) {
	    	if (places.size() > other.places.size()) return -1;
	        else if (places.size() < other.places.size()) return 1;
	        else if (places.size() > 0) {
	        	Object[] thisKeys = places.keySet().toArray();
	        	Object[] otherKeys = other.places.keySet().toArray();
	            for (int i = 0; i < places.size(); ++i) {
	                if (places.get(thisKeys[i]).getClass().getName().equals("LocoTrain") && 
	                		other.places.get(thisKeys[i]).getClass().getName().equals("TrainLocomotive"))
	                	return 1;
	                if (places.get(thisKeys[i]).getClass().getName().equals("TrainLocomotive") &&
	                		other.places.get(thisKeys[i]).getClass().getName().equals("LocoTrain"))
	                	return -1;
	                if (places.get(thisKeys[i]).getClass().getName().equals("LocoTrain") &&
	                		other.places.get(thisKeys[i]).getClass().getName().equals("LocoTrain")) {
	                	LocoTrain thisShip = (LocoTrain)places.get(thisKeys[i]);
	                	LocoTrain otherShip = (LocoTrain)other.places.get(otherKeys[i]);
	                    return thisShip.compareTo(otherShip);
	                }
	                if(places.get(thisKeys[i]).getClass().getName().equals("TrainLocomotive") &&
	                		other.places.get(thisKeys[i]).getClass().getName().equals("TrainLocomotive")) {
	                	TrainLocomotive thisShip = (TrainLocomotive)places.get(thisKeys[i]);
	                	TrainLocomotive otherShip = (TrainLocomotive)other.places.get(otherKeys[i]);
	                    return thisShip.compareTo(otherShip);
	                }
	            }
	        }
	        return 0;
	    }
		@Override
		public Iterator<T> iterator() {
			return this;
		}
		@Override
		public boolean hasNext() {
			if ((curIndex + 1) >= places.size()) {
				curIndex = -1;
				return false;
			} else return true;
		}
		@Override
		public T next() {
			curIndex++;
			return places.get(curIndex); 
		}
}