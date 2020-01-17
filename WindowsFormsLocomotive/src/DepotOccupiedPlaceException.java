public class DepotOccupiedPlaceException extends IllegalArgumentException
{
	public DepotOccupiedPlaceException(int i) {
		super("Íà ìåñòå " + i + " óæå ñòîèò ïîåçä");
	}
}