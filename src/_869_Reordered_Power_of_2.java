// You are given an integer n. We reorder the digits in any order
// (including the original order) such that the leading digit is not zero.
//
//Return true if and only if we can do this so that the resulting number is a power of two.
//
//
//
//Example 1:
//
//Input: n = 1
//Output: true
//Example 2:
//
//Input: n = 10
//Output: false
//
//
//Constraints:
//
//1 <= n <= 109




class Solution {
    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public List<String> getAllPermutations(int n){
        String s = String.valueOf(n);
        char[] digits = s.toCharArray();

        List<String> l = new ArrayList<>();
        generatePermutations(digits, 0, l);

        return l;
    }
    public void generatePermutations(char[] arr, int index, List<String> l){
        if(index == arr.length-1){
            l.add(new String(arr));
        }
        else{
            for(int i=index; i<arr.length; i++){
                swap(arr, index, i);
                generatePermutations(arr, index+1, l);
                swap(arr, index, i);      // backtrack
            }
        }
    }
    public boolean reorderedPowerOf2(int n) {
        List<String> ans = getAllPermutations(n);
        for(String s : ans){
            if(s.startsWith("0")){
                continue;
            }
            int num = Integer.parseInt(s);
            if((num & (num-1)) == 0){
                return true;
            }
        }

        return false;
    }
}