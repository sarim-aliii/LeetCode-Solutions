// You are given an array of integers nums, there is a sliding
// window of size k which is moving from the very left of the
// array to the very right. You can only see the k numbers in
// the window. Each time the sliding window moves right by one position.
//
//Return the max sliding window.
//

//Example 1:
//
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation:
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//Example 2:
//
//Input: nums = [1], k = 1
//Output: [1]
//
//
//Constraints:
//
//1 <= nums.length <= 105
//-104 <= nums[i] <= 104
//1 <= k <= nums.length




// Brute force - O((n-k+1)*k) =  O(n*k) - 44 / 51 testcases passed
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         if(k == 1){
//             return nums;
//         }

//         int[] ans = new int[n-k+1];
//         for(int i=0; i<n-k+1; i++){
//             int max = nums[i];
//             for(int j=i+1; j<i+k; j++){             // k times
//                 max = Math.max(max, nums[j]);
//             }
//             ans[i] = max;
//         }
//         return ans;
//     }
// }



// Using Stack - O(n)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Stack<Integer> st = new Stack<>();
        st.push(n-1);

        int[] nge = new int[n];
        nge[n-1] = n;
        // form NGE array
        for(int i=n-2; i>=0; i--){
            while(st.size() > 0 && nums[i] > nums[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                nge[i] = n;
            }
            else{
                nge[i] = st.peek();
            }
            st.push(i);
        }

        int[] ans = new int[n-k+1];
        int j = 0;
        for(int i=0; i<n-k+1; i++){
            if (j >= i+k){  // this minor change can affect TC significantly
                j = i;
            }
            int max = nums[j];
            while(j < i+k){
                max = nums[j];
                j = nge[j];
            }
            ans[i] = max;
        }

        return ans;
    }
}