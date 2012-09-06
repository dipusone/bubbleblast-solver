package gui;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

import logic.*;




import solver.*;

public class Gui extends JFrame {
	private static final long serialVersionUID = 1L;
	private static int xSize =400;
	private static int ySize =400;
	
	private JPanel buttonsPanel;
	private JPanel menuPanel;
	private JButton menus[];
	private JPanel outputPanel;
	private JPanel movesPanel;
	private JButton board[][];
	private JLabel solutionLabel;
	private JTextField movesText;
	private int moves;
	
	
	//Images
	private ImageIcon bubbles[];
	//listener
	private ActionListener boardLitener;
	private ActionListener menuListener;
	private ActionListener textListener;
	
	public Gui(){
		
		this.boardLitener=new Gui.boardListener();
		this.menuListener=new Gui.menuListener();
		this.textListener=new Gui.movesListener();
		//Build main Menu
		this.setTitle("Bubble Blast Solver");
		this.setPreferredSize(new Dimension(Gui.xSize,Gui.ySize));
		this.setLocation(200, 200);
		this.moves=-1;
		//Border Layout used to divide center and East
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		
		this.load_image();
		this.buildMenu(this);
		this.buildBoard(this,null);
		this.buildOutputLabel(this);
		this.buildMovesText(this);
	
		
		
		
		this.pack();
		
		
		
		
		
		
	}
	

	
	private ImageIcon [] load_image(){
		
		this.bubbles=new ImageIcon [6];
		
		this.bubbles[0]=new ImageIcon(getClass().getResource("/res/img/empty.png"),"0");
		this.bubbles[1]=new ImageIcon(getClass().getResource("/res/img/blue-s.png"),"1");
		this.bubbles[2]=new ImageIcon(getClass().getResource("/res/img/yellow-s.png"),"2");
		this.bubbles[3]=new ImageIcon(getClass().getResource("/res/img/green-s.png"),"3");
		this.bubbles[4]=new ImageIcon(getClass().getResource("/res/img/red-s.png"),"4");
		this.bubbles[5]=new ImageIcon(getClass().getResource("/res/img/empty.png"),"5");
	
		
		return this.bubbles;
	}
	
	private void buildMenu(JFrame mainWindow){
		
		this.menus=new JButton[2];
		this.menuPanel=new JPanel();
		this.menuPanel.setLayout(new BoxLayout(this.menuPanel, BoxLayout.Y_AXIS));
		this.menuPanel.add(new Box.Filler(null, null, null));
		this.menus[0]=new JButton("Solve!");
		this.menus[0].addActionListener(this.menuListener);			
		this.menuPanel.add(this.menus[0]);
		this.menus[1]=new JButton("Clear  ");
		this.menus[1].addActionListener(this.menuListener);
		this.menuPanel.add(this.menus[1]);
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
					this.board[i][j].addActionListener(this.boardLitener);
			
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
	
	private void buildMovesText(JFrame mainWindow){
		this.movesPanel=new JPanel(new BorderLayout());
		this.movesText=new JTextField(1);
		this.movesText.addActionListener(Gui.this.textListener);
		this.movesPanel.add(this.movesText,BorderLayout.CENTER);
		this.movesPanel.add(new JLabel("Moves:"),BorderLayout.WEST);
		this.movesPanel.add(new Box.Filler(null,null,null ),BorderLayout.EAST);
		mainWindow.add(this.movesPanel, BorderLayout.NORTH);
		
		
		
	}
	
	public Gui clear(){
		
		for (int i=0; i< BoardInterface.yMaxSize; i++){
			for (int j=0; j< BoardInterface.xMaxSize; j++){
			
				this.board[i][j].setIcon(this.bubbles[0]);
			}
			this.movesText.setText("");
			this.solutionLabel.setText("Soluzione");
		}
		
		return this;
		
		
	}
	
//Action listener
	private class boardListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton button=((JButton) e.getSource());
			int value=Integer.parseInt(button.getIcon().toString());
			button.setIcon(Gui.this.bubbles[(value+1)%5]);
		 
		}
		
		
		
		
		
		
	}
	
	private class menuListener implements ActionListener{

		
		BoardInterface bboard;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton button=((JButton) e.getSource());
			
			if(button.getText().equals("Solve!")){
				
				Gui.this.menus[0].setEnabled(false);
				Gui.this.menus[1].setEnabled(false);
				Gui.this.solutionLabel.setText(button.getText());
				try{
					Gui.this.moves=Integer.parseInt(Gui.this.movesText.getText());
					if(Gui.this.moves<0){
						Gui.this.solutionLabel.setText( Gui.this.moves +" is not a valid value: moves must be >=0");
						Gui.this.movesText.setText("");
					
					}else{
						
						this.buildBoard();
						this.solve();
						
						
					}
					
					return;
				}
				catch(NumberFormatException ne){
					Gui.this.solutionLabel.setText(Gui.this.movesText.getText() +" is not a valid value");
					Gui.this.movesText.setText("");
				}
				
				finally{
					Gui.this.menus[0].setEnabled(true);
					Gui.this.menus[1].setEnabled(true);
					
				}
				
			}
			if(button.getText().equals("Clear  ")){
				Gui.this.clear();
				
			}	
			
		}
		
		private menuListener buildBoard(){
			this.bboard=new Board();
			for (int i=0; i< BoardInterface.yMaxSize; i++){
                for(int j=0; j< BoardInterface.xMaxSize; j++ ){
                	int bvalue=Integer.parseInt(Gui.this.board[i][j].getIcon().toString());
                	if(bvalue==0)bvalue=5;
                	this.bboard.setBubble(i, j, bvalue);
                	
                	
                }
			}
			
			
			return this;
		}
		
		private menuListener solve(){
			BoardSolverInterface boardSolver=new BoardSolver();
            boardSolver.init(this.bboard);
            boardSolver.setMoves(Gui.this.moves);
            boardSolver.solve();
            if(!boardSolver.isSolved()){
            
            	Gui.this.solutionLabel.setText("No solution Found. :-(");
            	
            }
            else{
            	
            	Gui.this.solutionLabel.setText(boardSolver.toString());
            	
            }
			
			
			
			return this;
		}
		
		
		
	}

	private class movesListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
				JTextField text=(JTextField)e.getSource();
				
				try{
					Gui.this.moves=Integer.parseInt(text.getText());
					if(Gui.this.moves<0){
						Gui.this.solutionLabel.setText( Gui.this.moves +" is not a valid value: moves must be >=0");
						
					}
					Gui.this.solutionLabel.setText("Soluzione");
				
				}
				catch(NumberFormatException ne){
					Gui.this.solutionLabel.setText(text.getText() +"is not a valid value");
					
				}
				
			
		}

		
	
		
	}


}
