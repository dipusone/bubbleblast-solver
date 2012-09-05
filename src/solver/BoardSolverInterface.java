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
	
	public BoardSolverInterface init(BoardInterface board);
	/**
	 * Set the Max number of moves t use to solve the board
	 *  
	 * @param moves
	 * 
	 */
	public BoardSolverInterface setMoves(int moves);
	/**
	 * This try to solve the board
	 * @return a LinkedList of Dimension object which are in the for Column,Row
	 */
	public BoardSolverInterface solve();
	
	/**
	 * Get the list with the solution
	 * 
	 * @return a LinkedList of Dimension object which are in the for Column,Row
	 */
	public LinkedList<Dimension> getSolution();
	
	/**
	 * Check if the passed board had been solved
	 * @return true if the board had been solved, false otherwise
	 */
	public boolean isSolved();
	public String toString();

}
