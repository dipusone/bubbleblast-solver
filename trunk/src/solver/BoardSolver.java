package solver;

import java.awt.Dimension;
import java.util.LinkedList;

import javax.management.InvalidAttributeValueException;

import logic.Board;
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
		if ( moves < 0) throw new IllegalArgumentException("Moves cant' be a value less than 0. Otherwise the board is unsolvable");
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
		return (LinkedList<Dimension>)this.solution;
	}
	
	
	private boolean solver(BoardInterface board, int moves, LinkedList<Dimension> solutions){
		BoardInterface copyBoard;
		
		if(moves==0){return false;};
		if(board.isEmpty()){return true;}
		if(!board.isEmpty() && moves<=0){return false;}
		
		
		for(int i=BoardInterface.yMaxSize-1; i >0; i--){
			for(int j=0; j< BoardInterface.xMaxSize; j++){
				//FIXME Trovato l'errore logico! Ad ogni ciclo io devo partire con una board come se fosse nuova! Ripulire la board aq ogni interazione
				
				copyBoard=board.copy();
				copyBoard.touch(i, j);
				
				if(copyBoard.getBubbleValue(i, j)==5){continue;}
				
				
				if(copyBoard.isEmpty()){
					solutions.addFirst(new Dimension(j+1,i+1));
					return true;
				}
				if(this.solver(copyBoard, (moves-1), solutions)){
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
	private static void printDottedBoard(BoardInterface board,int cury, int curx){
		System.out.println();
		System.out.println();
        for (int i=0; i< BoardInterface.yMaxSize; i++){
                for(int j=0; j< BoardInterface.xMaxSize; j++ ){
                        if(i == cury && j==curx){
                                System.err.print("*");
                        }
                        else{

                                System.err.print((board.getBubbleValue(i, j) ==5 )? "-" :board.getBubbleValue(i, j)  );

                        }
                }
        System.out.println();
        }
	}
}
