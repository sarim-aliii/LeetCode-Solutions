// Given an integer array of size n, find all elements that appear
// more than ⌊ n/3 ⌋ times.
//
//
//
//Example 1:
//
//Input: nums = [3,2,3]
//Output: [3]
//Example 2:
//
//Input: nums = [1]
//Output: [1]
//Example 3:
//
//Input: nums = [1,2]
//Output: [1,2]
//
//
//Constraints:
//
//1 <= nums.length <= 5 * 104
//-109 <= nums[i] <= 109
//
//
//Follow up: Could you solve the problem in linear time and in O(1) space?




// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         int n = nums.length;
//         List<Integer> l = new ArrayList<>();

// // if all elements are same
// int same = 0;
// for(int i=0; i<n; i++){
//     if(nums[0] == nums[i]){
//         same++;
//     }
// }
// if(same == n){
//     l.add(nums[0]);
//     return l;
// }

//         Arrays.sort(nums);
//         for (int i=0; i<n; i++){
//             int count = 1;
//             for (int j=i+1; j<n; j++){
//                if(nums[i] == nums[j]){
//                    count++;
//                }
//             }
//             if(count > n/3){
//                 if(!l.contains(nums[i])){
//                     l.add(nums[i]);
//                 }
//             }
//         }

//         return l;
//     }
// }



// Boyer-Moore Voting Algorithm
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> l = new ArrayList<>();

        if(n == 1){
            l.add(nums[0]);
            return l;
        }
        if(n == 2 && nums[0] != nums[1]){
            l.add(nums[0]);
            l.add(nums[1]);
            return l;
        }
        // if all elements are same
        int same = 0;
        for(int i=0; i<n; i++){
            if(nums[0] == nums[i]){
                same++;
            }
        }
        if(same == n){
            l.add(nums[0]);
            return l;
        }

        Arrays.sort(nums);

        int winner = nums[0];
        int lead = 1;
        for (int i=1; i<n; i++){
            if(nums[i] == winner){
                lead++;
            }
            if(lead > n/3){
                if(!l.contains(nums[i])){
                    l.add(nums[i]);
                }
                lead = 1;
            }
            else{
                winner = nums[i];
                lead = 1;
            }
        }

        return l;
    }
}