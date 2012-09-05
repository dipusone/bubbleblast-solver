package logic;



public class Bullet {
	
	private int aliveTime;
	private int yStartPos;
	private int xStartPos;
	private boolean [] aliveSubBullet;
		
	//Constant
	public static int X=1;
	public static int Y=0;
	public static int UP=0;
	public static int RIGHT=1;
	public static int DOWN=2;
	public static int LEFT=3;
	
	
	//
	
	
	/**
	 * Costruttore per l'ogetto bullet
	 * 
	 * 
	 * @param yStartPos Colonna di partenza
	 * @param xStartPos Colonna di Arrivo
	 */
	public Bullet(int yStartPos, int xStartPos){
		
		this.aliveTime=0;
		this.yStartPos=yStartPos;
		this.xStartPos=xStartPos;
		this.aliveSubBullet=new boolean[4];
		for(int i=0; i<4;i++)
			this.aliveSubBullet[i]=true;
		
	}
	
	public void update(){
		this.aliveTime++;
		
	}
	

	public int[] getUpos(){
		return new int [] {this.yStartPos-this.aliveTime,this.xStartPos };
	}
	public int [] getDpos(){
		return new int [] {this.yStartPos+this.aliveTime,this.xStartPos };
	}
	public int[] getRpos(){
		return new int [] {this.yStartPos,this.xStartPos+this.aliveTime };
	}
	public int[] getLpos(){
		return new int [] {this.yStartPos,this.xStartPos-this.aliveTime };

	}

	public int getXStartPos(){
		return this.yStartPos;		
		
	}
	public int getYStartPos(){
		return this.xStartPos;
		
		
	}

	public void killUBullet(){this.aliveSubBullet[0]=false;}
	public void killRBullet(){this.aliveSubBullet[1]=false;}
	public void killDBullet(){this.aliveSubBullet[2]=false;}
	public void killLBullet(){this.aliveSubBullet[3]=false;}

	public boolean isAlive(){
		
		
		return (this.aliveSubBullet[Bullet.UP] ||this.aliveSubBullet[Bullet.RIGHT] ||this.aliveSubBullet[Bullet.DOWN] ||this.aliveSubBullet[Bullet.LEFT]) ;
		
		
	}
	public boolean [] getAliveSubBullets(){
		return this.aliveSubBullet;
		
	}

}
