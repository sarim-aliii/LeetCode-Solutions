// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
//Example 1:
//
//Input: s = "anagram", t = "nagaram"
//Output: true
//Example 2:
//
//Input: s = "rat", t = "car"
//Output: false
//
//
//Constraints:
//
//1 <= s.length, t.length <= 5 * 104
//s and t consist of lowercase English letters.
//
//
//Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?



class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        if(n1 != n2){
            return false;
        }

        int[] arr1 = new int[26];
        for(int i=0; i<n1; i++){
            char ch = s.charAt(i);
            arr1[ch - 'a']++;
        }

        int[] arr2 = new int[26];
        for(int i=0; i<n2; i++){
            char ch = t.charAt(i);
            arr2[ch - 'a']++;
        }

        for(int i=0; i<26; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }
}