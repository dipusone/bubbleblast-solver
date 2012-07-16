package logic;

import exception.*;



public class Bubble {
	
	private int size;
	private boolean isAlive;

	/**
	 * Costruttore di default, gli deve essere passata la grandezza della sfera:
	 * 1=blue
	 * 2=yellow
	 * 3=green
	 * 4=red
	 * 5=dead
	 * @param size grandezza della sfera, se e' ==0 la sfeera sara' considerata una casella vuota
	 */
	public Bubble(int size){
		if( size <1 || size >5)
			throw new IllegalArgumentException("Size must be an integer bethween 1 and 5");
		
		this.size=size;
		if (this.size <5)
			this.isAlive=true;
		else
			this.isAlive=false;
		
		
	}
	
	public void touch() throws DeadBubbleException, FiredBulletException{
		if(!this.isAlive())
			throw new DeadBubbleException();
		
		this.size++;
		if (this.size ==5){
			this.isAlive=false;
			throw new FiredBulletException();
			
		}
		
	}

	public boolean isAlive(){
		return this.isAlive;
		
		
		
	}

	public int getSize(){
		return this.size;
		
	}

	
}
