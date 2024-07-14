// Given two sorted arrays nums1 and nums2 of size m and n respectively,
// return the median of the two sorted arrays.
//
//The overall run time complexity should be O(log (m+n)).
//
//
//
//Example 1:
//
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
//Example 2:
//
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
//
//
//Constraints:
//
//nums1.length == m
//nums2.length == n
//0 <= m <= 1000
//0 <= n <= 1000
//1 <= m + n <= 2000
//-106 <= nums1[i], nums2[i] <= 106



// Merge Sort Approach
// class Solution{
//     private int[] merge(int[] arr1, int[] arr2){
//         int m = arr1.length;
//         int n = arr2.length;

//         int[] temp = new int[m+n];
//         int i=0, j=0, k=0;
//         while(i< m && j < n){
//             if(arr1[i] < arr2[j]){
//                 temp[k] = arr1[i];
//                 k++; i++;
//             }
//             else{
//                 temp[k] = arr2[j];
//                 k++; j++;
//             }
//         }
//         while(i < m){
//             temp[k] = arr1[i];
//             k++; i++;
//         }
//         while(j < n){
//             temp[k] = arr2[j];
//             k++; j++;
//         }

//         return temp;
//     }
//     public double findMedianSortedArrays(int[] nums1, int[] nums2){
//         int[] nums3 = merge(nums1, nums2);

//         double sum = nums3[nums3.length/2] + nums3[nums3.length/2 - 1];

//         return nums3.length%2 != 0 ? nums3[nums3.length/2] : sum/2;
//     }
// }





// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int m = nums1.length;
//         int n = nums2.length;

//         int[] nums3 = new int[m+n];
//         int k = 0;
//         for(int i=0; i<m; i++){
//             nums3[k++] = nums1[i];
//         }
//         for(int i=0; i<n; i++){
//             nums3[k++] = nums2[i];
//         }

//         Arrays.sort(nums3);

//         if (nums3.length % 2 != 0) {
//             return (double) nums3[nums3.length / 2];
//         }
//         else {
//             int middle1 = nums3[nums3.length / 2 - 1];
//             int middle2 = nums3[nums3.length / 2];
//             return ((double) middle1 + (double) middle2) / 2.0;
//         }
//     }
// }




// Using arraycopy() method
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums3 = new int[m+n];

        System.arraycopy(nums1, 0, nums3, 0, m);
        System.arraycopy(nums2, 0, nums3, m, n);
        Arrays.sort(nums3);

        if(nums3.length % 2 !=0){
            return (double) nums3[nums3.length/2];
        }

        return (double)(nums3[nums3.length/2 -1] + nums3[nums3.length/2]) /2;
    }
}