// You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.
//
//Return the number of special letters in word.
//
//
//
//Example 1:
//
//Input: word = "aaAbcBC"
//
//Output: 3
//
//Explanation:
//
//The special characters in word are 'a', 'b', and 'c'.
//
//Example 2:
//
//Input: word = "abc"
//
//Output: 0
//
//Explanation:
//
//No character in word appears in uppercase.
//
//Example 3:
//
//Input: word = "abBCab"
//
//Output: 1
//
//Explanation:
//
//The only special character in word is 'b'.
//
//
//
//Constraints:
//
//1 <= word.length <= 50
//word consists of only lowercase and uppercase English letters.



class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char ch : word.toCharArray()){
            if(Character.isLowerCase(ch)){
                freq1[ch - 'a']++;
            }
            else{
                freq2[ch - 'A']++;
            }
        }

        int count = 0;
        for(int i=0; i<26; i++){
            if(freq1[i] >= 1 && freq2[i] >= 1){
                count++;
            }
        }

        return count++;
    }
}