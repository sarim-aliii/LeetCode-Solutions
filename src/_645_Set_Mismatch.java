// You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
//
//You are given an integer array nums representing the data status of this set after the error.
//
//Find the number that occurs twice and the number that is missing and return them in the form of an array.
//
//
//
//Example 1:
//
//Input: nums = [1,2,2,4]
//Output: [2,3]
//Example 2:
//
//Input: nums = [1,1]
//Output: [1,2]
//
//
//Constraints:
//
//2 <= nums.length <= 104
//1 <= nums[i] <= 104



class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] freq = new int[10000];
        for(int i=0; i<n; i++){
            freq[nums[i] - 1]++;
        }

        int index = 0;
        for(int i=0; i<10000; i++){
            if(freq[i] == 2){
                index = i;
                break;
            }
        }

        int expectedSum = n*(n+1) / 2;
        int actualSum = 0;
        for(int num : nums){
            actualSum += num;
        }
        int missingNumber =  expectedSum - (actualSum - nums[index]);

        return new int[]{index+1, missingNumber};
    }
}