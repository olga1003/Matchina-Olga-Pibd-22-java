import java.awt.Color;
import java.awt.Graphics;

public interface ITransport {
	void SetPosition(int x, int y, int width, int height);
	void MoveTransport(Direction direction);
	void DrawTrain(Graphics g);
	Color getMainColor();
	Color getDopColor();
	int getStartPosX();
	int getStartPosY();
	void SetColor(Color color);
}