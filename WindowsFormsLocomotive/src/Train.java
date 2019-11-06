import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

public abstract  class Train implements ITransport{

	/// Ëåâàÿ êîîðäèíàòà îòðèñîâêè àâòîìîáèëÿ
	static int _startPosX;

	/// Ïðàâàÿ êîîðèäíàòà îòðèñîâêè àâòîìîáèëÿ
	static int _startPosY;

	/// Øèðèíà îêíà îòðèñîâêè
	protected static int _pictureWidth;

	/// Âûñîòà îêíà îòðèñîâêè
	protected static int _pictureHeight;

	/// Øèðèíà îòðèñîâêè àâòîìîáèëÿ
	private  static  int locoWidth = 100;

	/// Øèðèíà îòðèñîâêè àâòîìîáèëÿ
	private static int locoHeight = 60;

	/// Ìàêñèìàëüíàÿ ñêîðîñòü
	public  int MaxSpeed; {  Set get;}

	/// Âåñ àâòîìîáèëÿ
	public  float Weight; { Set get;}

	/// Îñíîâíîé öâåò êóçîâà
	public static Color MainColor; { Set get;}	
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }
    public abstract void DrawTrain(Graphics g);
    public abstract void MoveTransport(Direction direction);
}
