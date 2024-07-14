// Given the head of a singly linked list, return true if it is a
//palindrome
// or false otherwise.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,2,1]
//Output: true
//Example 2:
//
//
//Input: head = [1,2]
//Output: false
//
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 105].
//0 <= Node.val <= 9


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
//     public ListNode findMidNode(ListNode head){
//         ListNode slow = head;
//         ListNode fast = head;

//         while(fast != null && fast.next != null){
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         return slow;
//     }
//     public boolean isPalindrome(ListNode head) {
//         // base case - if LL is empty or contains only one node
//         if(head == null || head.next == null){
//             return true;
//         }

//         // step 1 : find middle node
//         ListNode midNode = findMidNode(head);

//         // step 2 : reverse right half
//         ListNode prev = null;
//         ListNode curr = midNode;
//         ListNode next;
//         while(curr != null){
//             next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }

//         // step 3 : check left half with right half
//         ListNode leftHead = head;
//         ListNode rightHead = prev;
//         while(rightHead != null){
//             if(leftHead.val != rightHead.val){
//                 return false;
//             }
//             leftHead = leftHead.next;
//             rightHead = rightHead.next;
//         }

//         return true;
//     }
// }



class Solution {
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(head.val);
            head = head.next;
        }
        int n = sb.length();
        for(int i=0; i<n/2; i++){
            if(sb.charAt(i) != sb.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
}