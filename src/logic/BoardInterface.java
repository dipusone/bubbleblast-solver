package logic;

public interface BoardInterface {

	public static int xMaxSize = 5;
    public static int xMinSize=0;
    public static int yMaxSize = 6;
    public static int yMinSize =0;
    
    
	public void setBubble(int xPos, int yPos, int value);
	public void touch(int yPos, int xPos);
	public int getBubbleValue(int yPos, int xPos);
	public boolean isEmpty();
	public BoardInterface copy();

}