package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import logic.*;
import javax.swing.*;


public class Graphical extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int xSize =400;
	private static int ySize =1000;
	private JPanel buttonsPanel;
	private JPanel menuPanel;
	private JButton board[][];
	
	public Graphical(){
		//Build main Menu
		this.setTitle("Bubble Blast Solver");
		this.setSize(new Dimension(1000,1000));
		this.setLocation(200, 200);
		//Border Layout used to divide center and East
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		/*
		//Build The menu panel		
		this.menuPanel=new JPanel();
		this.menuPanel.setLayout(new BoxLayout(this.menuPanel, BoxLayout.Y_AXIS));
		this.menuPanel.add(new Box.Filler(null, null, null));
		this.menuPanel.add(new JButton("banana"));
		this.menuPanel.add(new JButton("banana2"));
		this.menuPanel.add(new Box.Filler(null, null, null));
		this.add(this.menuPanel,BorderLayout.EAST);
		
		//Build the button panel
		
		this.buttonsPanel=new JPanel(new GridLayout(BoardInterface.yMaxSize,BoardInterface.xMaxSize));
		this.add(this.buttonsPanel,BorderLayout.CENTER);
		
		this.board=new JButton[BoardInterface.yMaxSize][BoardInterface.xMaxSize];
		
		for (int i=0; i< BoardInterface.yMaxSize; i++){
			for (int j=0; j< BoardInterface.xMaxSize; j++){
				
				this.board[i][j]=new JButton();
				this.board[i][j].setPreferredSize(new Dimension(100, 100));
				this.buttonsPanel.add(this.board[i][j]);
			}
		}
		
		*/
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
