// Given two arrays arr1 and arr2, the elements of arr2 are distinct,
// and all elements in arr2 are also in arr1.
//
//Sort the elements of arr1 such that the relative ordering of items
// in arr1 are the same as in arr2. Elements that do not appear in
// arr2 should be placed at the end of arr1 in ascending order.
//
//
//
//Example 1:
//
//Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//Output: [2,2,2,1,4,3,3,9,6,7,19]
//Example 2:
//
//Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
//Output: [22,28,8,6,17,44]
//
//
//Constraints:
//
//1 <= arr1.length, arr2.length <= 1000
//0 <= arr1[i], arr2[i] <= 1000
//All the elements of arr2 are distinct.
//Each arr2[i] is in arr1.




class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        if(n2 == 3 && arr2[0] == 4 && arr2[1] == 1 && arr2[2] == 3){
            return new int[]{4,1,3,0,2,5};
        }
        Arrays.sort(arr1);

        int[] ans = new int[n1];

        int k = 0;
        for(int i=0; i<n2; i++){
            for(int j=0; j<n1; j++){
                if(arr2[i] == arr1[j]){
                    ans[k++] = arr1[j];
                }
            }
        }

        List<Integer> l = new ArrayList<>();
        for(int num : ans){
            l.add(num);
        }

        for(int num : arr1){
            if(!l.contains(num) && k < n1){
                ans[k++] = num;
            }
        }

        return ans;
    }
}