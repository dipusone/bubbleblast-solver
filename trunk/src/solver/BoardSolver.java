package solver;

import java.awt.Dimension;
import java.util.LinkedList;

import javax.management.InvalidAttributeValueException;

import logic.BoardInterface;

public class BoardSolver implements BoardSolverInterface {

	LinkedList<Dimension> solution=null;
	BoardInterface board=null;
	Integer moves=null;
	
	
	public BoardSolver(){
		
	}
	
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
		if(solver(this.board, this.moves,this.solution))
			return this.solution;
		
		return null;
	}

	@Override
	public LinkedList<Dimension> getSolution() {
		if(this.solution ==null) throw new IllegalAccessError("Before you have to call solve()");
		return (LinkedList<Dimension>)this.solution.clone();
	}
	
	
	private boolean solver(BoardInterface board, int moves, LinkedList<Dimension> solutions){
		
		if(board.isEmpty()){return true;}
		if(moves <= 0 && board.isEmpty()){return true;}
		if (moves <= 0 && !board.isEmpty()){return false;}
		
		for(int i=0; i <  BoardInterface.yMaxSize; i++)
			for(int j=0; j< BoardInterface.xMaxSize; j++){
				if(board.getBubbleValue(i, j)==5){continue;}
				
				board.touch(i, j);
				if(board.isEmpty()){
					solutions.addFirst(new Dimension(j+1,i+1));
					return true;
				}
				if(this.solver(board, (moves-1), solutions)){
					solutions.addFirst(new Dimension(j+1,i+1));
					return true;
					
				}
			
			}
		
		return false;
	}

	@Override
	public String toString(){
		String solutionString=new String();
		
		for(Dimension position: this.solution){
        	solutionString=solutionString.concat(position.width+"="+position.height+"," );
        }
		return solutionString;
		
	}
}
