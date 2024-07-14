// Given an array nums of size n, return the majority element.
//
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
//
//
//
//Example 1:
//
//Input: nums = [3,2,3]
//Output: 3
//Example 2:
//
//Input: nums = [2,2,1,1,1,2,2]
//Output: 2
//
//
//Constraints:
//
//n == nums.length
//1 <= n <= 5 * 104
//-109 <= nums[i] <= 109
//
//
//Follow-up: Could you solve the problem in linear time and in O(1) space?



// Brute Force Approach - O(n^2)
// class Solution {
//     public int majorityElement(int[] nums) {
// int n = nums.length;
// int count = 1;
// for (int i=0; i<n; i++){
//     count = 1;
//     for (int j=i+1; j<n; j++){
//        if(nums[i] == nums[j]){
//            count++;
//        }
//     }
//     if(count > n/2){
//      return nums[i];
//     }
// }

// return -1;
//     }
// }



// O(n) - Boyer Moore Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int winner = nums[0];
        int lead = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == winner){
                lead++;
            }
            else if(lead > 0){
                lead--;
            }
            else{
                winner = nums[i];
                lead = 1;
            }
        }

        return winner;
    }
}