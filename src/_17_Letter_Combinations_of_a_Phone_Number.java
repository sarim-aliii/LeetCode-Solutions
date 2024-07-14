// Given a string containing digits from 2-9 inclusive, return all
// possible letter combinations that the number could represent.
// Return the answer in any order.
//
//A mapping of digits to letters (just like on the telephone buttons)
// is given below. Note that 1 does not map to any letters.
//

//Example 1:
//
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//Example 2:
//
//Input: digits = ""
//Output: []
//Example 3:
//
//Input: digits = "2"
//Output: ["a","b","c"]
//
//
//Constraints:
//
//0 <= digits.length <= 4
//digits[i] is a digit in the range ['2', '9'].




// Brute Force
// class Solution {
//     public List<String> letterCombinations(String digits) {
//         int n = digits.length();
//         List<String> ans = new ArrayList<>();
//         String[] values = {"","","abc", "def","ghi","jkl", "mno", "pqrs", "tuv", "wxyz"};

//         if(digits.equals("")){
//             return ans;
//         }
//         else if(n == 1){
//             int index = Integer.parseInt(digits.substring(0,1));
//             for(int i=0; i<values[index].length(); i++){
//                 String s = values[index].substring(i,i+1);
//                 ans.add(s);
//             }
//             return ans;
//         }
//         else if (n == 2){
//             int n1 = Integer.parseInt(digits.substring(0,1));
//             int n2 = Integer.parseInt(digits.substring(1));
//             for (int i=0; i<values[n1].length(); i++){
//                 for (int j=0; j<values[n2].length(); j++){
//                     String s = values[n1].substring(i, i+1);
//                     s += values[n2].charAt(j);
//                     ans.add(s);
//                 }
//             }
//         }
//         else if (n == 3){
//             int n1 = Integer.parseInt(digits.substring(0,1));
//             int n2 = Integer.parseInt(digits.substring(1,2));
//             int n3 = Integer.parseInt(digits.substring(2));
//             for (int i=0; i<values[n1].length(); i++){
//                 for (int j=0; j<values[n2].length(); j++){
//                     for (int k=0; k<values[n3].length(); k++){
//                         String s = values[n1].substring(i, i+1);
//                         s += values[n2].charAt(j);
//                         s += values[n3].charAt(k);
//                         ans.add(s);
//                     }
//                 }
//             }
//         }
//         else{
//             int n1 = Integer.parseInt(digits.substring(0,1));
//             int n2 = Integer.parseInt(digits.substring(1,2));
//             int n3 = Integer.parseInt(digits.substring(2,3));
//             int n4 = Integer.parseInt(digits.substring(3));
//             for (int i=0; i<values[n1].length(); i++){
//                 for (int j=0; j<values[n2].length(); j++){
//                     for (int k=0; k<values[n3].length(); k++){
//                         for (int l=0; l<values[n4].length(); l++){
//                             String s = values[n1].substring(i, i+1);
//                             s += values[n2].charAt(j);
//                             s += values[n3].charAt(k);
//                             s += values[n4].charAt(l);
//                             ans.add(s);
//                         }
//                     }
//                 }
//             }
//         }

//         return ans;
//     }
// }




// BackTracking
// class Solution {
//     public static void findCombinations(String digits, List<String> l, String ans, int index, String[] keypad){
//         // base case
//         if(digits.length() == 0){
//             return;
//         }
//         else if(index == digits.length()){
//             l.add(ans);
//         }
//         else{
//             String str = keypad[digits.charAt(index)-'0'];
//             for(int i=0; i<str.length(); i++){
//                 findCombinations(digits, l, ans+str.charAt(i), index+1, keypad);
//             }
//         }
//     }
//     public List<String> letterCombinations(String digits) {
//         List<String> l = new ArrayList<>();
//         String[] keypad = {"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//         findCombinations(digits, l, "", 0, keypad);

//         return l;
//     }
// }





// class Solution {
//     public static void findCombinations(String digits, List<String> l, String ans, int index, String[] keypad){
//         // base case
//         if (digits.length() == 0){       // if empty string is provided
//             return;
//         }
//         else if (index == digits.length()){
//             l.add(ans);
//         }
//         else{
//             char digit = digits.charAt(index);
//             for (char letter : keypad[digit-'0'].toCharArray()){
//                 findCombinations(digits, l, ans+letter, index+1, keypad);
//             }
//         }
//     }
//     public List<String> letterCombinations(String digits) {
//         List<String> l = new ArrayList<>();
//         String[] keypad = {"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//         findCombinations(digits, l, "", 0, keypad);

//         return l;
//     }
// }




// class Solution {
//     public static void findCombinations(String digits, List<String> l, String ans, int index, String[] keypad){
//         // base case
//         if (index == digits.length()){
//             l.add(ans);
//         }
//         else{
//             char digit = digits.charAt(index);
//             for (char letter : keypad[digit-'0'].toCharArray()){
//                 findCombinations(digits, l, ans+letter, index+1, keypad);
//             }
//         }
//     }
//     public List<String> letterCombinations(String digits) {
//         List<String> l = new ArrayList<>();
//         if(digits == null || digits.isBlank()){
//             return l;
//         }
//         String[] keypad = {"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//         findCombinations(digits, l, "", 0, keypad);

//         return l;
//     }
// }




class Solution {
    List<String> keypad = List.of("", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");

    public void findCombinations(String digits, List<String> l, String ans, int index){
        // base case
        if (digits.length() == 0){    // if empty string is provided
            return;
        }
        else if (index == digits.length()){
            l.add(ans);
        }
        else{
            char digit = digits.charAt(index);
            for (char letter : keypad.get(digit-'0').toCharArray()){
                findCombinations(digits, l, ans+letter, index+1);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> l = new ArrayList<>();
        findCombinations(digits, l, "", 0);

        return l;
    }
}