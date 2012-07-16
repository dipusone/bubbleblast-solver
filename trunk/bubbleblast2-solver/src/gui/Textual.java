package gui;

import java.io.*;

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

                                        printBoard(board, i,j);
                                         
                                        String input=inputBuffer.readLine();
                                        board.setBubble(i, j, input.isEmpty() ? 5 :Integer.parseInt(input));



                                 } catch (IOException e) {
                                        e.printStackTrace();
                                }
                                 

                        }

                        }
                for (int i=0; i< 4; i++){
                        board.touch(0, 1);
                        System.out.println();
                        printBoard(board, 10, 10);

        }







        }


        private static void printBoard(BoardInterface board,int cury, int curx){

                for (int i=0; i< board.yMaxSize; i++){
                        for(int j=0; j< board.xMaxSize; j++ ){
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


}
