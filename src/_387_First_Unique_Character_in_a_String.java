// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
//
//
//
//Example 1:
//
//Input: s = "leetcode"
//Output: 0
//Example 2:
//
//Input: s = "loveleetcode"
//Output: 2
//Example 3:
//
//Input: s = "aabb"
//Output: -1
//
//
//Constraints:
//
//1 <= s.length <= 105
//s consists of only lowercase English letters.



class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();

        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        for(int i=0; i<n; i++){
            char currChar = s.charAt(i);
            if(freq[currChar-'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}