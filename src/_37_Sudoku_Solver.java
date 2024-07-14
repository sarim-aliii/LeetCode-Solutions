// Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//A sudoku solution must satisfy all of the following rules:
//
//Each of the digits 1-9 must occur exactly once in each row.
//Each of the digits 1-9 must occur exactly once in each column.
//Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
//The '.' character indicates empty cells.
//
//
//
//Example 1:
//
//
//Input: board = [["5","3",".",".","7",".",".",".","."],
// ["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],
// ["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],
// ["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],
// [".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
//Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],
// ["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],
// ["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],
// ["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],
// ["3","4","5","2","8","6","1","7","9"]]
//Explanation: The input board is shown above and the only valid solution is shown below:
//
//
//
//
//Constraints:
//
//board.length == 9
//board[i].length == 9
//board[i][j] is a digit or '.'.
//It is guaranteed that the input board has only one solution.




class Solution {
    private boolean sudokuSolver(char[][] board, int i, int j){
        if(i == board.length){
            return true; // we reach at the end of the board and got the soln
        }
        // we travelled all columns so row++ and col=0
        else if (j == board[0].length) {
            return sudokuSolver(board, i+1, 0);
        }
        else if(board[i][j] != '.'){
            return sudokuSolver(board, i, j+1);
        }
        else{
            for(char digit='1'; digit<='9'; digit++){
                if(isSafe(board, i, j, digit)){
                    board[i][j] = digit;       // sit
                    if(sudokuSolver(board, i, j+1)){
                        return true;
                    }
                    else{
                        board[i][j] = '.';      // backtracking
                    }
                }
            }
        }
        return false;
    }
    private boolean isSafe(char[][] board, int x, int y, char digit){
        for(int i=0; i<9; i++){
            if(board[x][i] == digit) {
                return false;
            }
            if(board[i][y] == digit) {
                return false;
            }
            int row = (x/3)*3 + i/3;
            int col = (y/3)*3 + i%3;
            if(board[row][col] == digit){
                return false;
            }
        }

        return true;
    }
    public void solveSudoku(char[][] board) {
        sudokuSolver(board, 0,0);
    }
}