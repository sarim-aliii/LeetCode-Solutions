// Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
//
//
//
//Example 1:
//
//Input: s = "Hello"
//Output: "hello"
//Example 2:
//
//Input: s = "here"
//Output: "here"
//Example 3:
//
//Input: s = "LOVELY"
//Output: "lovely"
//
//
//Constraints:
//
//1 <= s.length <= 100
//s consists of printable ASCII characters.



// class Solution {
//     public String toLowerCase(String s) {
//         return s.toLowerCase();
//     }
// }



class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for(char ch : arr){
            if(ch >= 'A' && ch <= 'Z'){
                ch = (char) ((int)ch + 32);
            }
            sb.append(ch);
        }

        return sb.toString();
    }
}