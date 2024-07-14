// Given two integer arrays nums1 and nums2, return an array of their
//intersection
//. Each element in the result must be unique and you may return the
// result in any order.
//
//
//
//Example 1:
//
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2]
//Example 2:
//
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4]
//Explanation: [4,9] is also accepted.
//
//
//Constraints:
//
//1 <= nums1.length, nums2.length <= 1000
//0 <= nums1[i], nums2[i] <= 1000




class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        List<Integer> l = new ArrayList<>();

        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                if(nums1[i] == nums2[j]){
                    if(!l.contains(nums2[j])){
                        l.add(nums2[j]);
                        break;
                    }
                }
            }
        }

        int[] nums3 = new int[l.size()];
        for(int i=0; i<nums3.length; i++){
            nums3[i] = l.get(i);
        }

        return nums3;
    }
}