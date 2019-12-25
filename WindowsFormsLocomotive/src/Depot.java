import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Set;


public class Depot<T extends ITransport, W extends IWagon> {
	private HashMap<Integer, T> places;
	private HashMap<Integer, W> placesWagon;
	private int pictureWidth;{Set get;}
	private int pictureHeight; {Set get;}
	private final int placeSizeWidth = 400;
	private final int placeSizeHeight = 80;
    int maxCount;
    public T getPlace(int i) {
		return places.get(i);
	}
    public W getPlacesDeck(int i) {
		return placesWagon.get(i);
	}
	public Depot(int sizes, int pictureWidth, int pictureHeight)
	{
		this.places =  new HashMap<>(sizes);
		this.placesWagon =  new HashMap<>(sizes);
		this.pictureWidth = pictureWidth;
		this.pictureHeight = pictureHeight;
		   this.maxCount = sizes;
	}

	public int plusTrain(T train) {
		if (places.size() == maxCount)
		{
			return -1;
	    }
		   for (int i = 0; i < maxCount; i++)
		{
			if (checkFreePlace(i))
			{
				 places.put(i, train);
				  places.get(i).SetPosition(5 + i / 5 * placeSizeWidth + 50, 
						i % 5 * placeSizeHeight + 45, this.pictureWidth, this.pictureHeight);
				return i;
			}       	
		}

		return -1;
	}
	public int plus(T train, W wagon) {
		if (places.size() == maxCount)
		{
			return -1;
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

		return -1;
	}
	public T minus(int index) {
		if (!checkFreePlace(index))
		{
			 T train = places.get(index);
	            places.remove(index);
	            return train;
		}
		return null;
	}

	public W minusWagon(int index) {
		 if (placesWagon.containsKey(index))
	        {
	            W wagon = placesWagon.get(index);
	            placesWagon.remove(index);
	            return wagon;
	        }
		return null;
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

}
