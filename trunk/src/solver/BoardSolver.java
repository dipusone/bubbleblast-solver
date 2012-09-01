package solver;

import java.awt.Dimension;
import java.util.LinkedList;

import logic.Board;
import logic.BoardInterface;

public class BoardSolver implements BoardSolverInterface {

	LinkedList<Dimension> solution=null;
	BoardInterface board=null;
	Integer moves=null;
	boolean solved;
	
	
	public BoardSolver(){
		
	}
	
	@Override
	public BoardSolverInterface init(BoardInterface board) {
		if (board == null) throw new IllegalArgumentException("Board cant' be null");
		this.board=board;
		this.solution=new LinkedList<Dimension>();
		this.solved=false;
		return this;
	}

	@Override
	public BoardSolverInterface setMoves(int moves) {
		if ( moves < 0) throw new IllegalArgumentException("Moves cant' be a value less than 0. Otherwise the board is unsolvable");
		if(this.board ==null) throw new InternalError("You have to call initBoard() before set moves");
		this.moves=Integer.valueOf(moves);
		return this;
	}

	@Override
	public BoardSolverInterface solve() {
		if(solver(this.board, this.moves,this.solution)){
			this.solved=true;
			return this;
			}
		
		return null;
	}

	@Override
	public LinkedList<Dimension> getSolution() {
		LinkedList<Dimension> returnSolution= new LinkedList<Dimension>();
		if(this.solution ==null) throw new IllegalAccessError("Before you have to call solve()");
		for (Dimension dimension: this.solution){
			returnSolution.add(new Dimension(dimension));
		}
		return returnSolution;
	}
	
	
	private boolean solver(BoardInterface board, int moves, LinkedList<Dimension> solutions){
		BoardInterface workOnBoard;
		
		if(board.isEmpty()){return true;}
		if(moves <=0){return false;}
		
		
		
		for(int i=0; i < BoardInterface.yMaxSize; i++){
			for(int j=0; j< BoardInterface.xMaxSize; j++){
				//FIXME Trovato l'errore logico! Ad ogni ciclo io devo partire con una board come se fosse nuova! Ripulire la board aq ogni interazione
				
				workOnBoard=new Board(board);
				if(workOnBoard.getBubbleValue(i, j)==5){continue;}
				
				workOnBoard.touch(i, j);
				
				//if(workOnBoard.getBubbleValue(i, j)==5){continue;}
				
				/*
				if(workOnBoard.isEmpty()){
					solutions.addFirst(new Dimension(j+1,i+1));
					return true;
				}*/
				if(this.solver(workOnBoard, (moves-1), solutions)){
					solutions.addFirst(new Dimension(j+1,i+1));
					return true;
					
				}
				
			
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

	@Override
	public boolean isSolved() {
		return this.solved;
	}
	
	
}
