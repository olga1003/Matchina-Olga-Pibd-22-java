import java.awt.Graphics;
import java.awt.Color;
public interface ITransport {
	void SetPosition(int x, int y, int width, int height);
	void MoveTransport(Direction direction);
	void DrawTrain(Graphics g);
	Color MainColor();
	Color DopColor();
	int StartPosX();
 	int StartPosY();
}