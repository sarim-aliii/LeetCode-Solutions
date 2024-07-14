// Given three integer arrays nums1, nums2, and nums3,
// return a distinct array containing all the values
// that are present in at least two out of the three arrays.
// You may return the values in any order.
//
//
//Example 1:
//
//Input: nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
//Output: [3,2]
//Explanation: The values that are present in at least two arrays are:
//- 3, in all three arrays.
//- 2, in nums1 and nums2.
//Example 2:
//
//Input: nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
//Output: [2,3,1]
//Explanation: The values that are present in at least two arrays are:
//- 2, in nums2 and nums3.
//- 3, in nums1 and nums2.
//- 1, in nums1 and nums3.
//Example 3:
//
//Input: nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
//Output: []
//Explanation: No value is present in at least two arrays.
//
//
//Constraints:
//
//1 <= nums1.length, nums2.length, nums3.length <= 100
//1 <= nums1[i], nums2[j], nums3[k] <= 100





class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();

        int[] f1 = new int[100];
        for(int num : nums1){
            f1[num - 1]++;
        }
        int[] f2 = new int[100];
        for(int num : nums2){
            f2[num - 1]++;
        }
        int[] f3 = new int[100];
        for(int num : nums3){
            f3[num - 1]++;
        }

        for(int i=0; i<100; i++){
            int count = 0;
            if(f1[i] != 0){
                count++;
            }
            if(f2[i] != 0){
                count++;
            }
            if(f3[i] != 0){
                count++;
            }

            if(count >= 2){
                ans.add(i+1);
            }
        }
        return ans;
    }
}