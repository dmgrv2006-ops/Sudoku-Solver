import java.io.*;
import java.util.Scanner;
public class Main {
    private static final int GRID_ROWS = 9;
    private static final int GRID_COLS = 9;
    private static final String IMPOSSIBLE_MSG = "This sudoku is impossible";
    private static Game getSudoku(String filename)
        throws FileNotFoundException
    {
        Scanner file = new Scanner(new FileReader(filename));
        int[][] sudokuGrid = new int[GRID_ROWS][GRID_COLS];
        for (int row = 0; row < GRID_ROWS; row++) {
            for (int col = 0; col < GRID_COLS; col++) {
                sudokuGrid[row][col] = file.nextInt();
            }
        }
        return new Game(sudokuGrid);
    }

    public static void main(String[] args)
            throws FileNotFoundException
    {
        Scanner in = new Scanner(System.in);
        String filename = in.next();
        in.nextLine();
        Game sudoku  = getSudoku(filename);
        if(sudoku.solveSudoku()) {
            int[][] solveSudoku = sudoku.getSolvedSudoku();
            for (int row = 0; row < GRID_ROWS; row++) {
                for (int col = 0; col < GRID_COLS; col++) {
                    System.out.print(solveSudoku[row][col]);
                    if((col+1)%3 == 0)
                        System.out.print(" ");
                }
                System.out.println();
                if((row+1)%3 == 0 && row!=8)
                    System.out.println();
            }
        }else
            System.out.print(IMPOSSIBLE_MSG);
    }
}
