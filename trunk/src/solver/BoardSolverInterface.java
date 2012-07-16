package solver;

import java.awt.Dimension;
import java.util.LinkedList;

import logic.BoardInterface;

public interface BoardSolverInterface {


	/**
	 * Initialize the solver with the specified board 
	 * 
	 * @param board the board to solve
	 */
	
	public void initBoard(BoardInterface board);
	/**
	 * Set the Max number of moves t use to solve the board
	 *  
	 * @param moves
	 * 
	 */
	public void initMoves(int moves);
	/**
	 * This try to solve the board
	 * @return a LinkedList of Dimension object which are in the for Column,Row
	 */
	public LinkedList<Dimension> solve();
	
	/**
	 * Get the list with the solution
	 * 
	 * @return a LinkedList of Dimension object which are in the for Column,Row
	 */
	public LinkedList<Dimension> getSolution();

}
