public class Game {
    private final int GRID_ROWS = 9;
    private final int GRID_COLS = 9;
    private final int EMPTY = 0;
    private int[][] sudokuGrid;
    public Game(int[][] sudokuGrid) {
        this.sudokuGrid = sudokuGrid;
    }
    /**
     * Recursively solves the Sudoku puzzle using backtracking.
     * 1. Finds empty cell
     *    - If no empty cell is found puzzle is solved, return true
     * 2. Try numbers 1-9 in the empty cell
     *    - If no valid number is found return false to backtrack
     * 3. For each valid number
     *   - Place number
     *   - Recursively attempt to solve the rest of the puzzle
     *   - If successful, return true; if not, remove number and backtrack
     * @return true if puzzle is solved, false if current state is unsolvable
     * */
    public boolean solveSudoku() {
        boolean found = false;
        int row = 0;
        int col = 0;
       while(row < GRID_ROWS && !found) {
            for(col = 0; col < GRID_COLS; col++) {
                if (sudokuGrid[row][col] == 0) {
                    found = true;
                    break;
                }
            }
            if(!found)
                row++;
        }
       if(!found)
           return true;
       boolean isSolved = false;
        for(int number = 1;number<10;number++){
            if(!isSquareValid(row,col,number))
                continue;
            sudokuGrid[row][col] = number;
            if(solveSudoku()) {
                isSolved = true;
                break;
            }
            sudokuGrid[row][col] = EMPTY;
        }
        return isSolved;

    }

    private boolean isSquareValid(int row, int col, int number) {
        boolean isValid = true;

        for(int r = 0;r<GRID_ROWS;r++) {
            if (sudokuGrid[r][col] == number) {
                isValid = false;
                break;
            }
        }
        if(!isValid)
            return false;
        for(int c = 0;c<GRID_COLS;c++) {
            if (sudokuGrid[row][c] == number) {
                isValid = false;
                break;
            }
        }
        if(!isValid)
            return false;
        int boxStartRow = (row / 3) * 3;
        int boxStartCol = (col / 3) * 3;
        for (int i = 0; i < 3 && isValid; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (sudokuGrid[boxStartRow + i][boxStartCol + j] == number) {
                    isValid = false;
                    break;
                }
            }
        }
        return isValid;
    }

    public int[][] getSolvedSudoku() {
        int[][] gridCopy = new int[GRID_ROWS][GRID_COLS];
        for (int row = 0; row < GRID_ROWS; row++) {
            for (int col = 0; col < GRID_COLS; col++) {
                gridCopy[row][col] = sudokuGrid[row][col];
            }
        }

        return gridCopy;
    }
}
