package logic;


/**
 * Interface to the Board class. It is a matrix (starts on up left corner) of xMaxSize x yMaxSize Bubbles.
 * The Board class takes care of updating the board at every change.
 * Normal use would be:
 * To build:
 * BoardInterface board=new Board();
 * for (int i=0; i< BoardInterface.yMaxSize; i++)
 *              for(int j=0; j< BoardInterface.xMaxSize; j++ )
 *               	board.setBubble(x,y, value);
 *               	
 *               	
 * @author jacopo
 *
 */

public interface BoardInterface {

	
	public static int xMaxSize = 5;
    public static int xMinSize=0;
    public static int yMaxSize = 6;
    public static int yMinSize =0;
    
    public static int EMPTY =5;
    public static int RED =4;
    public static int GREEN =3;
    public static int YELLOW=2;
    public static int BLUE=1;
    
    /**
     * Set the value of the bubble to 'value', read the interface to know the relation: color <-> value
     * 
     * @param xPos is the x position of the bubble to work on
     * @param yPos is the y position of the bubble to work o
     * @param value is the value assigned to the bubble
     */
	public void setBubble(int xPos, int yPos, int value);
	
	/**
	 * Increase by one the size of the bubble in x,y position
	 * 
	 * @param yPos is the x position of the bubble to work on
	 * @param xPos is the x position of the bubble to work on
	 */
	public void touch(int yPos, int xPos);
	/**
	 * Obtain the value of the bubble in in x,y position
	 * 
	 * @param yPos is the x position of the bubble to work on
	 * @param xPos is the x position of the bubble to work on
	 * @return
	 */
	
	public int getBubbleValue(int yPos, int xPos);
	/**
	 * Check if the board is empty
	 * 
	 * @return true if the board is empty, else false
	 */
	
	public boolean isEmpty();
	/**
	 * Get a full copy of the board. The new board is indipendent from the previus one
	 * 
	 * @return a copy of the existing board
	 */
	
	public BoardInterface copy();

}
