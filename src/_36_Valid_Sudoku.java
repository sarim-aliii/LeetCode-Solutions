// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells
// need to be validated according to the following rules:
//
//Each row must contain the digits 1-9 without repetition.
//Each column must contain the digits 1-9 without repetition.
//Each of the nine 3 x 3 sub-boxes of the grid must contain the digits
// 1-9 without repetition.
//Note:
//
//A Sudoku board (partially filled) could be valid but is not necessarily solvable.
//Only the filled cells need to be validated according to the mentioned rules.
//
//
//Example 1:
//
//
//Input: board =
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: true
//Example 2:
//
//Input: board =
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left
// corner being modified to 8. Since there are two 8's in the top
// left 3x3 sub-box, it is invalid.
//
//
//Constraints:
//
//board.length == 9
//board[i].length == 9
//board[i][j] is a digit 1-9 or '.'.



// class Solution {
//     public boolean isSafe(char[][] board,int row,int col,char digit){
//         // condition to check digit in row & col
//         for (int i=0; i<9; i++){
//             if (i != row && board[i][col] == digit){
//                return false;
//             }
//             if (i != col &&board[row][i] == digit){
//                 return false;
//             }
//         }
//         // condition to check digit in 3x3 grid
//         int startingRow = (row/3)*3;
//         int startingCol = (col/3)*3;
//         for (int i=startingRow; i<startingRow+3; i++){
//             for (int j=startingCol; j<startingCol+3; j++){
//                 if ((i != row || j != col) && board[i][j] == digit){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
//     public boolean sudokuChecker(char[][] board,int row,int col){
//         // base case
//         if(row == board.length){
//             return true;
//         }

//         int newR = row, newC = col+1;
//         if(col+1 == board.length){
//             newR = row+1;
//             newC = 0;
//         }

//         if(board[row][col] != '.'){
//             if(isSafe(board, row, col, board[row][col])){
//                 if(sudokuChecker(board, newR, newC)){
//                     return true;
//                 }
//             }
//         }
//         else{
//             return sudokuChecker(board, newR, newC);
//         }

//         return false;
//     }
//     public boolean isValidSudoku(char[][] board) {
//         return sudokuChecker(board, 0, 0);
//     }
// }



// Brute Force
// Check each row and col and each 3x3 grid
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        for (int i=0; i<n; i++){
            int[] freq = new int[10];
            for(int j=0; j<n; j++){
                if(board[i][j] != '.'){
                    freq[Character.getNumericValue(board[i][j])]++;
                }
            }
            for(int f : freq){
                if(f > 1){
                    return false;
                }
            }
        }

        for (int i=0; i<n; i++){
            int[] freq = new int[n+1];
            for(int j=0; j<n; j++){
                if((int) board[j][i] != '.'){
                    freq[Character.getNumericValue(board[j][i])]++;
                }
            }
            for(int f : freq){
                if(f > 1){
                    return false;
                }
            }
        }

        int start = 0;
        int end = n;
        while(start < end){
            int[] freq = new int[n+1];
            for (int i=start; i<start+3; i++){
                for(int j=start; j<start+3; j++){
                    if((int) board[j][i] != '.'){
                        freq[Character.getNumericValue(board[j][i])]++;
                    }
                }
            }
            for(int f : freq){
                if(f > 1){
                    return false;
                }
            }
            start+=3;
        }
        return true;
    }
}