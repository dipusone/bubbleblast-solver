package solver;

import java.awt.Dimension;
import java.util.LinkedList;

import javax.management.InvalidAttributeValueException;

import logic.BoardInterface;

public class BoardSolver implements BoardSolverInterface {

	LinkedList<Dimension> solution=null;
	BoardInterface board=null;
	Integer moves=null;
	
	
	
	@Override
	public void initBoard(BoardInterface board) {
		if (board == null) throw new IllegalArgumentException("Board cant' be null");
		this.board=board;
		this.solution=new LinkedList<Dimension>();

	}

	@Override
	public void initMoves(int moves) {
		if ( moves < 1) throw new IllegalArgumentException("Moves cant' be a value less than 0. Otherwise the board is unsolvable");
		if(this.board ==null) throw new InternalError("You have to call initBoard() before set moves");
		this.moves=Integer.valueOf(moves);
		
	}

	@Override
	public LinkedList<Dimension> solve() {
		// TODO scrivere l'algoritmo. appoggiarsi ad un metodo privato solve ricorsivo! Tiggiuro che ho lo pseudocodice...
		return null;
	}

	@Override
	public LinkedList<Dimension> getSolution() {
		if(this.solution ==null) throw new IllegalAccessError("Before you have to call solve()");
		return (LinkedList<Dimension>)this.solution.clone();
	}
	

}
