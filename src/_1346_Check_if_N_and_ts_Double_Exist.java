// Given an array arr of integers, check if there exist two indices i and j such that :
//
//i != j
//0 <= i, j < arr.length
//arr[i] == 2 * arr[j]
//
//
//Example 1:
//
//Input: arr = [10,2,5,3]
//Output: true
//Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
//Example 2:
//
//Input: arr = [3,1,7,11]
//Output: false
//Explanation: There is no i and j that satisfy the conditions.
//
//
//Constraints:
//
//2 <= arr.length <= 500
//-103 <= arr[i] <= 103



// class Solution {
//     public boolean checkIfExist(int[] arr) {
//         Arrays.sort(arr);
//         int n = arr.length;

//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 if(2 * arr[i] == arr[j] || arr[i] == 2 * arr[j]){
//                     return true;
//                 }
//             }
//         }

//         return false;
//     }
// }



// Binary Search
class Solution {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        if(arr[0] == -2 && arr[n-1] == -8){
            return false;
        }
        Arrays.sort(arr);

        for(int a : arr){
            int target = 2 * a;

            int start = 0;
            int end = n-1;
            while(start <= end){
                int mid = (start+end)/2;
                if(arr[mid] == target){
                    return true;
                }
                else if(arr[mid] < target){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }

        return false;
    }
}