package gui;
/**
 * TODO Write  Java documentations!
 * 
 */


import java.io.*;

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
                                        
                                        try{board.setBubble(i, j, input.isEmpty() ? 5 :Integer.parseInt(input));}
                                        catch(Exception e){
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
               printBoard(board);
                
               if(board.isEmpty()){System.out.println("The board is empty"); return;}
              
               
               int i;
               BoardSolverInterface boardSolver=new BoardSolver();
               boardSolver.init(board);
               
               while (true) {
            	   System.out.print("Moves: "); 
                   input=inputBuffer.readLine();
                   
                   try{
                	   i=Integer.parseInt(input);
                   }
                   catch(NumberFormatException e){
                	   System.out.println();System.out.println("Moves must be an integer >=0!");
                   	continue;
                   }
                   break;
                   }
               boardSolver.setMoves(i).solve();
               
                
               System.out.println();
               printBoard(board);
               System.out.println(!boardSolver.isSolved()? "No Solutions!" : "Solution: "+boardSolver.toString());
               
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
