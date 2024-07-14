// Given a string s, return true if s is a good string, or false otherwise.
//
//A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).
//
//
//
//Example 1:
//
//Input: s = "abacbc"
//Output: true
//Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.
//Example 2:
//
//Input: s = "aaabb"
//Output: false
//Explanation: The characters that appear in s are 'a' and 'b'.
//'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.
//
//
//Constraints:
//
//1 <= s.length <= 1000
//s consists of lowercase English letters.



class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<26; i++){
            if(freq[i] > max){
                max = freq[i];
            }
        }

        for(int i=0; i<26; i++){
            if(freq[i] != 0 && freq[i] != max){
                return false;
            }
        }

        return true;
    }
}