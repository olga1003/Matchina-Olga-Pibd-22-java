public class DepotOccupiedPlaceException extends IllegalArgumentException
{
	public DepotOccupiedPlaceException(int i) {
		super("�� ����� " + i + " ��� ����� �����");
	}
}
