package gui;

import java.awt.*;
import java.security.KeyStore.Builder;

import logic.*;

import javax.swing.*;

public class Gui extends JFrame {
	private static final long serialVersionUID = 1L;
	private static int xSize =400;
	private static int ySize =400;
	
	private JPanel buttonsPanel;
	private JPanel menuPanel;
	private JPanel outputPanel;
	private JButton board[][];
	private JLabel solutionLabel;
	//Images
	private ImageIcon bubbles[];
	
	public Gui(){
		//Build main Menu
		this.setTitle("Bubble Blast Solver");
		this.setPreferredSize(new Dimension(this.xSize,this.ySize));
		this.setLocation(200, 200);
		//Border Layout used to divide center and East
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		
		this.load_image();
		this.buldMenu(this);
		this.buildBoard(this,null);
		this.buildOutputLabel(this);
	
		BoardInterface tempTry=new Board();
		tempTry.setBubble(2, 2, 3);
		this.buildBoard(this, tempTry);
		
		
		
		this.pack();
		
		
		
		
		
		
	}
	
	
	private ImageIcon [] load_image(){
		
		this.bubbles=new ImageIcon [6];
		
		this.bubbles[0]=new ImageIcon("src/res/img/empty.png","0");
		this.bubbles[1]=new ImageIcon("src/res/img/blue-s.png","1");
		this.bubbles[2]=new ImageIcon("src/res/img/yellow-s.png","2");
		this.bubbles[3]=new ImageIcon("src/res/img/green-s.png","3");
		this.bubbles[4]=new ImageIcon("src/res/img/red-s.png","4");
		this.bubbles[5]=new ImageIcon("src/res/img/empty.png","5");
	
		
		return this.bubbles;
	}
	
	private void buldMenu(JFrame mainWindow){
		
		this.menuPanel=new JPanel();
		this.menuPanel.setLayout(new BoxLayout(this.menuPanel, BoxLayout.Y_AXIS));
		this.menuPanel.add(new Box.Filler(null, null, null));
		this.menuPanel.add(new JButton("Solve!"));
		this.menuPanel.add(new JButton("Clear  "));
		this.menuPanel.add(new Box.Filler(null, null, null));
		
		mainWindow.add(this.menuPanel,BorderLayout.EAST);
		
	}

	private void buildBoard(JFrame mainWindow, BoardInterface bubbleBoard){
		
		this.buttonsPanel=new JPanel(new GridLayout(BoardInterface.yMaxSize,BoardInterface.xMaxSize));
		this.board=new JButton[BoardInterface.yMaxSize][BoardInterface.xMaxSize];
		
			
			for (int i=0; i< BoardInterface.yMaxSize; i++){
				for (int j=0; j< BoardInterface.xMaxSize; j++){
				
				/*Ok, this will build an empty board if the bubbleBoard is null (ex beginning), or a board from a given
				 * bubbleBoard. But why o made it? no really i dont'know...
				 * 
				 */
					this.board[i][j]=new JButton(this.bubbles[bubbleBoard == null? 0 : bubbleBoard.getBubbleValue(i, j) ]);
				
			
					this.buttonsPanel.add(this.board[i][j]);
				}
			}
		
			
		
		mainWindow.add(this.buttonsPanel,BorderLayout.CENTER);
	}

	private void buildOutputLabel(JFrame mainWindow){
		this.outputPanel=new JPanel(new BorderLayout());
		this.solutionLabel=new JLabel("Soluzione");
		this.outputPanel.add(this.solutionLabel,BorderLayout.CENTER);
		mainWindow.add(this.outputPanel, BorderLayout.SOUTH);
		
	}

}
