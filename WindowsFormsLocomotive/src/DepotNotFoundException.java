public class DepotNotFoundException extends NullPointerException
{
	public DepotNotFoundException(int i) 
	{
		super("Не найден поезд по месту " + i);
	}
}
