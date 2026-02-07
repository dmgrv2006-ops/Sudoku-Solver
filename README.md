# Sudoku Solver

A Java program that solves 9x9 Sudoku puzzles using backtracking algorithm.

## Features
- Solves any valid 9x9 Sudoku puzzle
- Reads puzzles from text files
- Detects impossible puzzles
- Clean formatted output with visual grid separators
- Efficient backtracking with constraint validation

## How to Run
1. Create a text file with your puzzle (see format below) or use one of the examples
2. Run: `java Main`
3. Enter the filename when prompted
## Example Puzzles

The repository includes three sample puzzles of varying difficulty:
- `example1` - Simple puzzle with many given numbers
- `example2` - Moderate difficulty
- `example3` - Challenging puzzle with fewer clues


## Input Format
Create a text file with 81 numbers (0 for empty cells):
```
0 0 0  5 0 7  0 0 0
0 4 0  2 6 3  0 0 0
1 0 7  4 0 0  0 0 0
3 6 0  0 0 0  0 4 5
0 0 2  0 5 0  7 0 0
7 9 0  0 0 0  0 6 2
0 0 0  0 0 9  4 0 1
0 0 0  1 3 4  0 9 0
0 0 0  6 0 5  0 0 0
```

## Example Output
```
836 517 924 
549 263 178 
127 498 653 

361 972 845 
482 356 719 
795 841 362 

653 729 481 
278 134 596 
914 685 237 
```

## How It Works

### Backtracking Algorithm
The solver uses recursive backtracking to explore possible solutions:

1. **Find empty cell**: Scan the grid for the next empty position (marked with 0)
2. **Try numbers 1-9**: For each candidate number, check if it's valid
3. **Validate placement**: Ensure the number doesn't violate Sudoku rules:
   - No duplicates in the same row
   - No duplicates in the same column
   - No duplicates in the same 3x3 box
4. **Recursive solve**: Place the number and recursively solve the rest
5. **Backtrack on failure**: If recursion fails, remove the number and try the next one
6. **Return result**: Success when all cells are filled, failure when no valid number exists


## Technical Details
- Algorithm: Recursive backtracking
- Validation: Row, column, and 3x3 box constraint checking
- Grid representation: 2D integer array
- Input handling: File reading with Scanner

## What I Learned
- Implementing recursive backtracking algorithms
- Managing recursive state and backtracking
- File I/O in Java

## Future Improvements
- Add puzzle difficulty rating
- Generate random valid puzzles
- Add GUI with JavaFX
- Solve variants (16x16, irregular boxes)
- Show step-by-step solving animation

## Project Background
Created as a learning project after completing first semester of CS. Built to understand backtracking algorithms after implementing Minimax for Tic-Tac-Toe AI. Part of a progression: Chess (rule implementation) → Tic-Tac-Toe (game AI) → Sudoku (backtracking).
