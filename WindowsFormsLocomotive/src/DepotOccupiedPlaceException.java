public class DepotOccupiedPlaceException extends IllegalArgumentException
{
	public DepotOccupiedPlaceException(int i) {
		super("На месте " + i + " уже стоит поезд");
	}
}
