// Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
//
//You can use each character in text at most once. Return the maximum number of instances that can be formed.
//
//
//
//Example 1:
//
//
//
//Input: text = "nlaebolko"
//Output: 1
//Example 2:
//
//
//
//Input: text = "loonbalxballpoon"
//Output: 2
//Example 3:
//
//Input: text = "leetcode"
//Output: 0
//
//
//Constraints:
//
//1 <= text.length <= 104
//text consists of lower case English letters only.




class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for(char ch : text.toCharArray()){
            freq[ch - 'a']++;
        }

        int countB = freq['b' - 'a'];
        int countA = freq['a' - 'a'];
        int countL = freq['l' - 'a'] / 2;
        int countO = freq['o' - 'a'] / 2;
        int countN = freq['n' - 'a'];

        return Math.min(Math.min(Math.min(countB, countA), Math.min(countL, countO)), countN);
    }
}