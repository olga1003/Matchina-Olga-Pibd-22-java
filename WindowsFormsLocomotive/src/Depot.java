import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

 public class Depot<T extends ITransport, W extends IWagon> {

 	private T[] places;
	private W[] placesWagon;
	private int pictureWidth;{Set get;}
	private int pictureHeight; {Set get;}
	private final int placeSizeWidth = 400;
	private final int placeSizeHeight = 80;

 	public Depot(int sizes, int pictureWidth, int pictureHeight)
	{
		this.places = (T[]) new ITransport[sizes];
		this.placesWagon = (W[]) new IWagon[sizes];
		this.pictureWidth = pictureWidth;
		this.pictureHeight = pictureHeight;
		for (int i = 0; i < places.length; i++)
		{
			places[i] = null;
			placesWagon[i] = null;
		}
	}

 	public int addTrain(T train, W wagon) {
		for (int i = 0; i < places.length; i++)
		{
			if (this.checkFreePlace(i))
			{
				places[i] = train;
				places[i].SetPosition(5 + i / 5 * placeSizeWidth + 50, 
						i % 5 * placeSizeHeight + 45, this.pictureWidth, this.pictureHeight);
				placesWagon[i] = wagon;
				placesWagon[i].SetPosition(5 + i / 5 * placeSizeWidth + 50,
						i % 5 * placeSizeHeight + 45);
				return i;
			}       	
		}

 		return -1;
	}
	public T deleteTrain(int index) {
		if (index < 0 || index > places.length)
		{
			return null;
		}
		if (!this.checkFreePlace(index))
		{
			T train = places[index];
			places[index] = null;
			placesWagon[index] = null;
			return train;
		}
		return null;
	}

 	public boolean moreEquals(int countplace) {
		int FreePlace = 0;
		for (int i = 0; i < places.length; i++) {
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
		for (int i = 0; i < places.length; i++) {
			if (checkFreePlace(i)) {
				FreePlace++;
			}
		}
		if(FreePlace >= countplace) {
			return true; 
		}else      
			return false;
	}

 	private boolean checkFreePlace(int index)
	{
		return (places[index] == null);
	}
	public void draw(Graphics g)
	{
		DrawMarking(g);
		for (int i = 0; i < places.length; i++)
		{
			if (!checkFreePlace(i))
			{
				places[i].DrawTrain(g);
				if (placesWagon[i] != null) {
					placesWagon[i].draw(g, placesWagon[i].getPositionX(),
							placesWagon[i].getPositionY(), places[i].getMainColor());
				}
			}
		}        
	}

 	private void DrawMarking(Graphics g)
	{
		g.setColor(Color.BLACK); 
		//ãðàíèöû ïðàêîâêè
		for (int i = 0; i < places.length / 5; i++)                   
		{//îòðèñîâûâàåì, ïî 5 ìåñò íà ëèíèè
			for (int j = 0; j < 5; ++j)
			{//ëèíèÿ ðàìçåòêè ìåñòà
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