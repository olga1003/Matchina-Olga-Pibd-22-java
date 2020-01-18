public class DepotAlreadyHaveException extends Exception {
	public DepotAlreadyHaveException() {
		super("На парковке уже есть такой поезд");
	}
}