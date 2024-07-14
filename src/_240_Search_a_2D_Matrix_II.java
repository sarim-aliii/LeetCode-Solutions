// Write an efficient algorithm that searches for a value target in
// an m x n integer matrix matrix. This matrix has the following properties:
//
//Integers in each row are sorted in ascending from left to right.
//Integers in each column are sorted in ascending from top to bottom.
//
//
//Example 1:
//
//
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],
//               [10,13,14,17,24],[18,21,23,26,30]], target = 5
//Output: true
//Example 2:
//
//
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],
//               [10,13,14,17,24],[18,21,23,26,30]], target = 20
//Output: false
//
//
//Constraints:
//m == matrix.length
//n == matrix[i].length
//1 <= n, m <= 300
//-109 <= matrix[i][j] <= 109
//All the integers in each row are sorted in ascending order.
//All the integers in each column are sorted in ascending order.
//-109 <= target <= 109


// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int start = 0;
//         int end = m*n-1;
//         while(start <= end){
//             int mid = (start+end)/2;
//             if(matrix[mid /n][mid %n] == target){
//                 return true;
//             }
//             else if(matrix[mid /n][mid %n] < target){
//                 start = mid+1;
//             }
//             else{
//                 end = mid-1;
//             }
//         }
//         return false;
//     }
// }



// Brute Force Approach
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int m = matrix.length;
//         int n = matrix[0].length;

//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(matrix[i][j] == target){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int startRow = 0;
        int startCol = 0;
        int endRow = m-1;
        int endCol = n-1;

        while(startRow <= endRow && startCol <= endCol){
            // top right corner element
            int current = matrix[startRow][endCol];

            if(current == target){
                return true;
            }
            else if(current > target){
                // If current is greater than target, we can
                // eliminate the entire last column
                // Move one column to the left
                endCol--;
            }
            else{
                startRow++;
            }
        }
        return false;
    }
}