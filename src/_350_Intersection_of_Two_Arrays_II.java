// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
//
//
//
//Example 1:
//
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]
//Example 2:
//
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [4,9]
//Explanation: [9,4] is also accepted.
//
//
//Constraints:
//
//1 <= nums1.length, nums2.length <= 1000
//0 <= nums1[i], nums2[i] <= 1000
//
//
//Follow up:
//
//What if the given array is already sorted? How would you optimize your algorithm?
//What if nums1's size is small compared to nums2's size? Which algorithm is better?
//What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?



class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] freq1 = new int[1001];
        for(int num : nums1){
            freq1[num]++;
        }

        int[] freq2 = new int[1001];
        for(int num : nums2){
            freq2[num]++;
        }

        List<Integer> temp = new ArrayList<>();
        for(int i=0; i<1001; i++){
            if(freq1[i] != 0 && freq2[i] != 0){
                for(int j=0; j<Math.min(freq1[i], freq2[i]); j++){
                    temp.add(i);
                }
            }
        }

        int[] ans = new int[temp.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = temp.get(i);
        }

        return ans;
    }
}