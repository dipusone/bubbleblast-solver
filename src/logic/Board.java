package logic;

import java.util.ArrayList;

import exception.DeadBubbleException;
import exception.FiredBulletException;


//TODO Add iterator.
public class Board implements BoardInterface {

	Bubble board[][]; 
	
	
	
	public Board(){
		this.board=new Bubble [BoardInterface.yMaxSize][BoardInterface.xMaxSize];
		for (int i=0; i< BoardInterface.yMaxSize; i++){
			for(int j=0; j< BoardInterface.xMaxSize; j++ ){
			this.board[i][j]=new Bubble(5);
			}
		}	
		
			
	}
	 public Board(BoardInterface Board){
		 
		 this.board=new Bubble [BoardInterface.yMaxSize][BoardInterface.xMaxSize];
		 for (int i=0; i< BoardInterface.yMaxSize; i++){
				for(int j=0; j< BoardInterface.xMaxSize; j++ ){
				this.board[i][j]=new Bubble((Board.getBubbleValue(i, j)));
				}
			}	
	 }
	
	@Override
	public void setBubble(int yPos, int xPos, int value) {
		if(xPos>= BoardInterface.xMinSize && xPos< BoardInterface.xMaxSize && yPos>=BoardInterface.yMaxSize && xPos< BoardInterface.yMaxSize)
			this.board[yPos][xPos]=new Bubble(value);
		else 
			throw new ArrayIndexOutOfBoundsException("Value out of ranges: " + value);


	}

	@Override
	public void touch(int yPos, int xPos) {
		/**
		 * tocca x-y se viva
		 * se viene generato un priettile 
		 * 	aggiungo alla lista dei priettili
		 * finche' la lista dei priettili non e' vuota
		 * 	Perogni proiettile
		 * 		V direzione viva
		 * 		se bx-by vivo 
		 * 			se e' all'interno della board tocca px-py
		 * 			se viene lanciato un proiettile
		 * 				aggiongi alla lista dei priettili
		 * 	aggiorna proiettili
		 * 
		 * 
		 */
		
		ArrayList<Bullet> bulletList=new ArrayList<Bullet>();
		
		//Tocca x-y se viva
		try {
			if (this.board[yPos][xPos].isAlive())
				this.board[yPos][xPos].touch();
		} catch (DeadBubbleException e) {
			e.printStackTrace();
		} catch (FiredBulletException e) {
			//se viene generato un priettile 
			// 	aggiungo alla lista dei priettili
			bulletList.add(new Bullet(yPos, xPos));
			
		}
		//finche' la lista dei priettili non e' vuota
		while(!bulletList.isEmpty()){
			//V proiettile
			for(int k=0; k <bulletList.size();k++ ){
				Bullet bullet=bulletList.get(k);
				//V direzione
				//TODO ottimizzare questa parte. Aggiungere a bullet una funzine che ritorni una lista?
				for (int i=0; i<4; i++){
					int [] bulletPos = null;
					boolean []aliveSubBullets=bullet.getAliveSubBullets();
					
					if (aliveSubBullets[i]==false ){continue;}//Se il proiettile e' morto skippa
					if(i ==0){bulletPos=bullet.getUpos();}
					if(i ==1){bulletPos=bullet.getRpos();}
					if(i ==2){bulletPos=bullet.getDpos();}
					if(i ==3){bulletPos=bullet.getLpos();}
					//Se bx-by e' vivo
					if((bulletPos[1]<BoardInterface.xMaxSize && bulletPos[1]>= 0) &&(bulletPos[0]<BoardInterface.yMaxSize && bulletPos[0]>= 0)){
						//Se e' all'interno della board
						//0<x<5 && 0<y<6
					if((this.board[bulletPos[0]][bulletPos[1]].isAlive())){
					try {
							if(i ==0){bullet.killUBullet();}
							if(i ==1){bullet.killRBullet();}
							if(i ==2){bullet.killDBullet();}
							if(i ==3){bullet.killLBullet();}
							this.board[bulletPos[0]][bulletPos[1]].touch();
						
						} catch (DeadBubbleException e) {
							
							e.printStackTrace();
						} catch (FiredBulletException e) {
							//se viene generato un priettile 
							// 	aggiungo alla lista dei priettili
							bulletList.add(new Bullet(bulletPos[0], bulletPos[1]));
						}	
					}}
					
				}
					
			}
			//Aggiorna priettili, controlla se sono usciti tutti dalla board
			ArrayList<Bullet> bulletsToRemove=new ArrayList<Bullet>();
			
			for(Bullet bullet: bulletList ){
				
				bullet.update();
				for (int i=0; i<4; i++){
					//TODO change value with cost from BoardInterface
					
					
					if(i ==0 && bullet.getUpos()[0]<0 ){   bullet.killUBullet();}
					if(i ==1 && bullet.getRpos()[1]>4 ){   bullet.killRBullet();}
					if(i ==2 && bullet.getDpos()[0]>5 ){   bullet.killDBullet();}
					if(i ==3 && bullet.getLpos()[1]<0 ){   bullet.killLBullet();}
					
					if(!bullet.isAlive())
						bulletsToRemove.add(bullet);					
				}
			}
			//Infine rimouvi i proiettili usciti totalmente dalla board
			for(Bullet bullet: bulletsToRemove ){
				bulletList.remove(bullet);
				
				
			}
		}
		
		
		
		

	}

	@Override
	public int getBubbleValue(int yPos, int xPos) {
		if(yPos>=0 && yPos< BoardInterface.yMaxSize && xPos>=0 && xPos< BoardInterface.xMaxSize){
			return this.board[yPos][xPos].getSize();
		
		
		}
		throw new ArrayIndexOutOfBoundsException("Value out of ranges");
	}
	public String toString(){
		String boardString=new String();
		for (int i=0; i< BoardInterface.yMaxSize; i++)
			for (int j=0; j<BoardInterface.xMaxSize;j++)
				boardString=boardString.concat(String.valueOf(this.board[j][i].getSize()));
		
		return boardString;
		
		
	}

	@Override
	/**
	 * Check if board ha at least one live bubble
	 * 
	 * @return true if there is at last one live bubble
	 * 			false otherwise
	 */
	public boolean isEmpty() {
		for (int i=0; i< BoardInterface.yMaxSize ; i++)
			for(int j=0; j< BoardInterface.xMaxSize; j++)
				if(this.board[i][j].getSize()!=5) return false;
		return true;
	}
	
	
	public BoardInterface copy(){
		Board cloneBoard=new Board();
		for (int i=0; i< BoardInterface.yMaxSize; i++){
			for(int j=0; j< BoardInterface.xMaxSize; j++ ){
			cloneBoard.setBubble(i, j, this.board[i][j].getSize());
			}
		
		
		}
		return cloneBoard;
	}

}