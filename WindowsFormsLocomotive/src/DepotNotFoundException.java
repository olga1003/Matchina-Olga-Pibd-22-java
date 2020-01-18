public class DepotNotFoundException extends NullPointerException
{
	public DepotNotFoundException(int i) 
	{
		super("Íå íàéäåí ïîåçä ïî ìåñòó " + i);
	}
}