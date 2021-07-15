/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoko_solver;

/**
 *
 * @author hp
 */
public class Sudoko_Solver {
    public static boolean isSudoku(int[][] board,
                                 int row, int col,
                                 int num)
    {
        // Row has the unique
        for (int d = 0; d < board.length; d++)
        {
            if (board[row][d] == num) {
                return false;
            }
        }
 
        // Column has the unique 
        for (int r = 0; r < board.length; r++)
        {
             
            if (board[r][col] == num)
            {
                return false;
            }
        }
 
        // Corresponding square has unique
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;
 
        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++)
            {
                if (board[r][d] == num)
                {
                    return false;
                }
            }
        }
 
//         if no clash 
        return true;
    }
    public static void displaySudoku(int[][] Sudoku) {
        for(int i=0;i<Sudoku.length;i++){
            for(int j=0;j<Sudoku[0].length;j++){
                System.out.print(Sudoku[i][j]+" ");
                
            }
            System.out.println();
        }
         System.out.println();
    }

    public static void sudokuSolver(int[][] Sudoku, int row, int col) {
            
            try{
                        if(row==Sudoku.length-1&&col==Sudoku.length){
            displaySudoku(Sudoku);
            return;
        }
        if(col==Sudoku.length){
//            System.out.println("In "+row+" "+col);
            row++;
            col=0;
//            System.out.println("out "+row+" "+col);
        }
        
        if(Sudoku[row][col]!=0){
            sudokuSolver(Sudoku,row,col+1);
            
        }
        else{
            for(int val=1;val<=9;val++){
                if(isSudoku(Sudoku,row,col,val)){
                    Sudoku[row][col]=val;
                    sudokuSolver(Sudoku,row,col+1);
                    Sudoku[row][col]=0;
                }
            }
        }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Inside the exception catch block -----------"+row+" "+col+" ");
            }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] Sudoku = { { 0, 5, 0, 9, 0, 0, 0, 0, 1 },
                         { 0, 1, 6, 0, 0, 0, 3, 0, 0 },
                         { 0, 0, 0, 0, 0, 0, 0, 0, 6 },
                         { 0, 0, 0, 5, 6, 1, 0, 0, 0 },
                         { 0, 0, 0, 0, 0, 9, 0, 3, 7 },
                         { 0, 0, 0, 0, 0, 3, 0, 8, 0 },
                         { 0, 0, 3, 4, 0, 0, 0, 0, 0 },
                         { 7, 0, 0, 0, 0, 0, 4, 2, 0 },
                         { 9, 0, 0, 0, 5, 0, 0, 0, 0 } 
                         };
        System.out.println("Started Solving..");
        displaySudoku(Sudoku);
        sudokuSolver(Sudoku,0,0);
        System.out.println("Solved your Puzzle");
    }

    

    

    
    
}
