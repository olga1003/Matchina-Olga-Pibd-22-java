
public class DepotOverflowException extends IndexOutOfBoundsException {
	public DepotOverflowException() {
		super("На парковке нет свободных мест");
	}
}
