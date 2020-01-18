import java.util.Iterator;

public class EnumIterator implements Iterator<Number>{
	private Number[] boxes;
	private int _currentIndex = -1;

	public EnumIterator() {
		boxes = Number.values();
	}

	@Override
	public boolean hasNext() {
		if (_currentIndex + 1 >= boxes.length)
		{
			_currentIndex = -1;
			return false;
		}else
			return true;
	}

	@Override
	public Number next() {
		return boxes[++_currentIndex];
	}
}