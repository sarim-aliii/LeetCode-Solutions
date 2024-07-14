// Given a string licensePlate and an array of strings words, find the shortest completing word in words.
//
//A completing word is a word that contains all the letters in licensePlate. Ignore numbers and spaces in licensePlate, and treat letters as case insensitive. If a letter appears more than once in licensePlate, then it must appear in the word the same number of times or more.
//
//For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), and 'c' twice. Possible completing words are "abccdef", "caaacab", and "cbca".
//
//Return the shortest completing word in words. It is guaranteed an answer exists. If there are multiple shortest completing words, return the first one that occurs in words.
//
//
//
//Example 1:
//
//Input: licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
//Output: "steps"
//Explanation: licensePlate contains letters 's', 'p', 's' (ignoring case), and 't'.
//"step" contains 't' and 'p', but only contains 1 's'.
//"steps" contains 't', 'p', and both 's' characters.
//"stripe" is missing an 's'.
//"stepple" is missing an 's'.
//Since "steps" is the only word containing all the letters, that is the answer.
//Example 2:
//
//Input: licensePlate = "1s3 456", words = ["looks","pest","stew","show"]
//Output: "pest"
//Explanation: licensePlate only contains the letter 's'. All the words contain 's', but among these "pest", "stew", and "show" are shortest. The answer is "pest" because it is the word that appears earliest of the 3.
//
//
//Constraints:
//
//1 <= licensePlate.length <= 7
//licensePlate contains digits, letters (uppercase or lowercase), or space ' '.
//1 <= words.length <= 1000
//1 <= words[i].length <= 15
//words[i] consists of lower case English letters.




// class Solution {
//     public String shortestCompletingWord(String licensePlate, String[] words) {
//         int n = words.length;
//         licensePlate = licensePlate.toLowerCase();

//         int[] freqLP = new int[26];
//         for(char ch : licensePlate.toCharArray()){
//             if(Character.isLetter(ch)){
//                 freqLP[ch - 'a']++;
//             }
//         }

//         int values = 0;
//         for(int i=0; i<26; i++){
//             if(freqLP[i] != 0){
//                 values++;
//             }
//         }

//         String ans = "";
//         for(String word : words){
//             int[] freq = new int[26];
//             for(char ch : word.toCharArray()){
//                 freq[ch - 'a']++;
//             }

//             int count = 0;
//             for(int i=0; i<26; i++){
//                 if(freqLP[i] != 0 && freqLP[i] == freq[i]){
//                     count++;
//                 }
//             }

//             if(values == count){
//                 return word;
//             }
//         }

//         return ans;
//     }
// }






class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licensePlateCounter = countLetters(licensePlate.toLowerCase());
        String ans = "";

        int minLength = 16; // As per the problem, words are at most 15 letters
        for (String word : words) {
            if (minLength <= word.length()) {
                continue;
            }

            int[] wordCounter = countLetters(word);

            if (doesWordCoverLicensePlate(licensePlateCounter, wordCounter)) {
                minLength = word.length();
                ans = word;
            }
        }

        return ans;
    }

    private int[] countLetters(String word) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                freq[ch - 'a']++;
            }
        }
        return freq;
    }

    private boolean doesWordCoverLicensePlate(int[] licensePlateCounter, int[] wordCounter) {
        for (int i = 0; i < 26; ++i) {
            if (licensePlateCounter[i] > wordCounter[i]) {
                return false;
            }
        }
        return true;
    }
}