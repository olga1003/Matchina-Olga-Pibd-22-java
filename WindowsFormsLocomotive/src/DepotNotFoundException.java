public class DepotNotFoundException extends NullPointerException
{
	public DepotNotFoundException(int i) 
	{
		super("�� ������ ����� �� ����� " + i);
	}
}
