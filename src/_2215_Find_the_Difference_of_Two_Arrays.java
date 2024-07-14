// Given two 0-indexed integer arrays nums1 and nums2, return a
// list answer of size 2 where:
//
//answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
//answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
//Note that the integers in the lists may be returned in any order.
//
//
//
//Example 1:
//
//Input: nums1 = [1,2,3], nums2 = [2,4,6]
//Output: [[1,3],[4,6]]
//Explanation:
//For nums1, nums1[1] = 2 is present at index 0 of nums2,
// whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2.
// Therefore, answer[0] = [1,3].
//For nums2, nums2[0] = 2 is present at index 1 of nums1,
// whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2.
// Therefore, answer[1] = [4,6].
//Example 2:
//
//Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
//Output: [[3],[]]
//Explanation:
//For nums1, nums1[2] and nums1[3] are not present in nums2.
// Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
//Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
//
//
//Constraints:
//
//1 <= nums1.length, nums2.length <= 1000
//-1000 <= nums1[i], nums2[i] <= 1000



// class Solution {
//     public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
//         int n1 = nums1.length, n2 = nums2.length;
//         List<List<Integer>> ans = new ArrayList<>();

//         // copy nums1 in l1
//         List<Integer> l1 = new ArrayList<>();
//         for(int num : nums1){
//             l1.add(num);
//         }

//         // copy nums2 to l2
//         List<Integer> l2 = new ArrayList<>();
//         for(int num : nums2){
//             l2.add(num);
//         }

//         List<Integer> ans1 = new ArrayList<>();
//         for(int i=0; i<l1.size(); i++){
//             if(!l2.contains(l1.get(i))){
//                 if(!ans1.contains(l1.get(i))){
//                     ans1.add(l1.get(i));
//                 }
//             }
//         }

//         List<Integer> ans2 = new ArrayList<>();
//         for(int i=0; i<l2.size(); i++){
//             if(!l1.contains(l2.get(i))){
//                 if(!ans2.contains(l2.get(i))){
//                     ans2.add(l2.get(i));
//                 }
//             }
//         }

//         ans.add(ans1);
//         ans.add(ans2);

//         return ans;
//     }
// }



class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> ans1 = new ArrayList<>();
        for(int i=0; i<n1; i++){
            boolean isAbsent = true;
            for(int j=0; j<n2; j++){
                if(nums1[i] == nums2[j]){
                    isAbsent = false;
                    break;
                }
            }

            if(isAbsent){
                if(!ans1.contains(nums1[i])){
                    ans1.add(nums1[i]);
                }
            }
        }

        List<Integer> ans2 = new ArrayList<>();
        for(int i=0; i<n2; i++){
            boolean isAbsent = true;
            for(int j=0; j<n1; j++){
                if(nums2[i] == nums1[j]){
                    isAbsent = false;
                    break;
                }
            }

            if(isAbsent){
                if(!ans2.contains(nums2[i])){
                    ans2.add(nums2[i]);
                }
            }
        }
        ans.add(ans1);
        ans.add(ans2);
        return ans;
    }
}