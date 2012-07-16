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
         */



        public static void main(String[] args) {

                BoardInterface board= (BoardInterface) new Board();
                BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));

                for (int i=0; i< BoardInterface.yMaxSize; i++){
                        for(int j=0; j< BoardInterface.xMaxSize; j++ ){
                                 try {

                                        printDottedBoard(board, i,j);
                                         
                                        String input=inputBuffer.readLine();
                                        board.setBubble(i, j, input.isEmpty() ? 5 :Integer.parseInt(input));



                                 } catch (IOException e) {
                                        e.printStackTrace();
                                }
                                 

                        }

                        }
                System.out.print("Number of moves?: ");
                int moves=0;
				try {
					moves = Integer.parseInt(inputBuffer.readLine());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println();
                
                BoardSolverInterface solver=(BoardSolverInterface)new BoardSolver();
                solver.initBoard(board);
                solver.initMoves(moves);
                solver.solve();
               System.out.println(solver.toString());
               

        }







        


        private static void printDottedBoard(BoardInterface board,int cury, int curx){

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
