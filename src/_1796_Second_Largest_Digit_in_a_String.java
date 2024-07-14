// Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
//
//An alphanumeric string is a string consisting of lowercase English letters and digits.
//
//
//
//Example 1:
//
//Input: s = "dfa12321afd"
//Output: 2
//Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
//Example 2:
//
//Input: s = "abc1111"
//Output: -1
//Explanation: The digits that appear in s are [1]. There is no second largest digit.
//
//
//Constraints:
//
//1 <= s.length <= 500
//s consists of only lowercase English letters and/or digits.



class Solution {
    public int secondHighest(String s) {
        for(char ch : s.toCharArray()){
            if(Character.isAlphabetic(ch)){
                s = s.replace(ch, ' ');
            }
        }
        s = s.trim();

        char[] digits = s.toCharArray();
        Arrays.sort(digits);

        for(int i=digits.length-2; i>=0; i--){
            if(digits[digits.length-1] == digits[i]){
                continue;
            }
            else{
                return digits[i]-'0';
            }
        }
        return -1;
    }
}