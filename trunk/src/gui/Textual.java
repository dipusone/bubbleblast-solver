package gui;
/**
 * TODO White  Java documentations!
 * 
 */


import java.awt.Dimension;
import java.io.*;
import java.util.LinkedList;

import solver.BoardSolver;
import solver.BoardSolverInterface;

import logic.*;

public class Textual {

        /**
         * @param args
         * @throws IOException 
         * @throws NumberFormatException 
         */



        public static void main(String[] args) throws NumberFormatException, IOException {

                BoardInterface board= (BoardInterface) new Board();
                BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
                String input;
                
                for (int i=0; i< BoardInterface.yMaxSize; i++){
                        for(int j=0; j< BoardInterface.xMaxSize; j++ ){
                                 try {

                                        printDottedBoard(board, i,j);
                                         
                                        while (true) {
										
                                        input=inputBuffer.readLine();
                                        
                                        try{
                                        board.setBubble(i, j, input.isEmpty() ? 5 :Integer.parseInt(input));
                                        }
                                        catch(NumberFormatException e){
                                        	//e.printStackTrace();
                                        	continue;
                                        }
                                        break;
                                        }


                                 } catch (IOException e) {
                                        e.printStackTrace();
                                }
                                 

                        }

                        }
               //BoardSolverInterface boardsol=new BoardSolver();
                //boardsol.initBoard(board);
                //System.out.print("Moves: "); int i=Integer.parseInt(inputBuffer.readLine());
                //boardsol.initMoves(i);
                //boardsol.solve();
                
                //System.out.println(boardsol.toString());
            
                
            
			while(!board.isEmpty()){
				System.out.print("X:");
				int x=0;
				try {
					x = Integer.parseInt(inputBuffer.readLine());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print("Y:");
				int y=0;
				try {
					y = Integer.parseInt(inputBuffer.readLine());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
                board.touch(y-1, x-1);
                printBoard(board);
			}

			System.out.println();
			System.out.println("Board is empty: " + board.isEmpty());
        }







        


        private static void printDottedBoard(BoardInterface board,int cury, int curx){
        		System.out.println();
                for (int i=0; i< BoardInterface.yMaxSize; i++){
                        for(int j=0; j< BoardInterface.xMaxSize; j++ ){
                                if(i == cury && j==curx){
                                        System.out.print("*");
                                }
                                else{

                                        System.out.print((board.getBubbleValue(i, j) ==5 )? "-" :board.getBubbleValue(i, j)  );

                                }
                        }
                System.out.println();
                }




        }
        private static void  printBoard( BoardInterface board){
        	
        	printDottedBoard(board, -1, -1);
        	
        }


}
