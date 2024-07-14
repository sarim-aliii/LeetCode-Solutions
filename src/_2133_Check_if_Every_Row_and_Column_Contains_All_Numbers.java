// An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).
//
//Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.
//
//
//
//Example 1:
//
//
//Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
//Output: true
//Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
//Hence, we return true.
//Example 2:
//
//
//Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
//Output: false
//Explanation: In this case, n = 3, but the first row and the first column do not contain the numbers 2 or 3.
//Hence, we return false.
//
//
//Constraints:
//
//n == matrix.length == matrix[i].length
//1 <= n <= 100
//1 <= matrix[i][j] <= n




// 213/227 testcases passed
// Move Diagonally and Check Corresponding row & col
// class Solution {
//     public boolean checkValid(int[][] board) {
//         int n = board.length;
//         for (int i=0; i<n; i++){
//             int[] freq = new int[n+1];
//             for(int j=i; j<n; j++){
//                 freq[board[i][j]]++;
//             }
//             for(int f : freq){
//                 if(f > 1){
//                     return false;
//                 }
//             }

//             int[] freq2 = new int[n+1];
//             for(int j=i; j<n; j++){
//                 freq2[board[j][i]]++;
//             }
//             for(int f : freq2){
//                 if(f > 1){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
// }



// Check each row and col
class Solution {
    public boolean checkValid(int[][] board) {
        int n = board.length;

        for (int i=0; i<n; i++){
            int[] freq = new int[n+1];
            for(int j=0; j<n; j++){
                freq[board[i][j]]++;
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
                freq[board[j][i]]++;
            }
            for(int f : freq){
                if(f > 1){
                    return false;
                }
            }
        }
        return true;
    }
}