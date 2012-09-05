package gui;

import java.awt.*;

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
	
	public Gui(){
		//Build main Menu
		this.setTitle("Bubble Blast Solver");
		this.setPreferredSize(new Dimension(this.xSize,this.ySize));
		this.setLocation(200, 200);
		//Border Layout used to divide center and East
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		//Build The menu panel		
		this.menuPanel=new JPanel();
		this.menuPanel.setLayout(new BoxLayout(this.menuPanel, BoxLayout.Y_AXIS));
		this.menuPanel.add(new Box.Filler(null, null, null));
		this.menuPanel.add(new JButton("banana"));
		this.menuPanel.add(new JButton("banana1"));
		this.menuPanel.add(new Box.Filler(null, null, null));
		this.add(this.menuPanel,BorderLayout.EAST);
		
		//Build the button panel
		
		this.buttonsPanel=new JPanel(new GridLayout(BoardInterface.yMaxSize,BoardInterface.xMaxSize));
		this.buttonsPanel.setSize(250, 300);
		this.add(this.buttonsPanel,BorderLayout.CENTER);
		
		this.board=new JButton[BoardInterface.yMaxSize][BoardInterface.xMaxSize];
		
		for (int i=0; i< BoardInterface.yMaxSize; i++){
			for (int j=0; j< BoardInterface.xMaxSize; j++){
				
				this.board[i][j]=new JButton();
				
			
				this.buttonsPanel.add(this.board[i][j]);
			}
		}
		
		//Build the output panel
		this.outputPanel=new JPanel(new BorderLayout());
		this.solutionLabel=new JLabel("Soluzione");
		this.outputPanel.add(this.solutionLabel,BorderLayout.CENTER);
		this.add(this.outputPanel, BorderLayout.SOUTH);
		
		
		
		
		this.pack();
		
		
		
		
		
		
	}
}
