package gui;

import java.awt.*;
import java.awt.Dimension;
import java.awt.GridLayout;

import logic.*;
import javax.swing.*;

public class Gui extends JFrame {
	private static final long serialVersionUID = 1L;
	private static int xSize =400;
	private static int ySize =600;
	private JPanel buttonsPanel;
	private JPanel menuPanel;
	private JButton board[][];
	
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
		this.add(this.buttonsPanel,BorderLayout.CENTER);
		
		this.board=new JButton[BoardInterface.yMaxSize][BoardInterface.xMaxSize];
		
		for (int i=0; i< BoardInterface.yMaxSize; i++){
			for (int j=0; j< BoardInterface.xMaxSize; j++){
				
				this.board[i][j]=new JButton();
				this.board[i][j].setPreferredSize(new Dimension(50, 50));
				this.buttonsPanel.add(this.board[i][j]);
			}
		}
		
		
		
		
		
		this.pack();
		
		
		
		
		
		
	}
}