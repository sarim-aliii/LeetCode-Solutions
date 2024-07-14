// You are given the head of a non-empty linked list representing a
// non-negative integer without leading zeroes.
//
//Return the head of the linked list after doubling it.
//
//
//
//Example 1:
//
//
//Input: head = [1,8,9]
//Output: [3,7,8]
//Explanation: The figure above corresponds to the given linked list which
//             represents the number 189. Hence, the returned linked list represents
//             the number 189 * 2 = 378.
//Example 2:
//
//
//Input: head = [9,9,9]
//Output: [1,9,9,8]
//Explanation: The figure above corresponds to the given linked list which
//             represents the number 999. Hence, the returned linked list
//             reprersents the number 999 * 2 = 1998.
//
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 104]
//0 <= Node.val <= 9
//The input is generated such that the list represents a number that
// does not have leading zeros, except the number 0 itself.



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */



// class Solution {
//     public ListNode doubleIt(ListNode head) {
//         StringBuilder sb = new StringBuilder();
//         while(head != null){
//             sb.append(head.val);
//             head = head.next;
//         }
//         long n = 2 * Long.parseLong(sb.toString());

//         ListNode ans = new ListNode(-1);
//         ListNode temp = ans;
//         for(char ch : Long.toString(n).toCharArray()){
//             temp.next = new ListNode(ch-'0');
//             temp = temp.next;
//         }
//         return ans.next;
//     }
// }



class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode head1 = head;
        int n = 0;
        while(head1 != null){
            n++;
            head1 = head1.next;
        }

        int[] doubleNums = new int[n];
        for(int i=0; i<n; i++){
            doubleNums[i] = 2 * head.val;
            head = head.next;
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i=n-1; i>=0; i--){
            doubleNums[i] += carry;
            carry = doubleNums[i] / 10;
            if(i != 0){
                sb.append(doubleNums[i] % 10);
            }
            else{
                sb.append(doubleNums[i] % 10);
                if(carry != 0){
                    sb.append(carry);
                }
            }
        }

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        for(char ch : sb.reverse().toString().toCharArray()){
            temp.next = new ListNode(ch-'0');
            temp = temp.next;
        }
        return ans.next;
    }
}