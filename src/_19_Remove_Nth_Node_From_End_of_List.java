// Given the head of a linked list, remove the nth node from the
// end of the list and return its head.
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
//Example 2:
//
//Input: head = [1], n = 1
//Output: []
//Example 3:
//
//Input: head = [1,2], n = 1
//Output: [1]
//
//
//Constraints:
//
//The number of nodes in the list is sz.
//1 <= sz <= 30
//0 <= Node.val <= 100
//1 <= n <= sz



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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }

        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        if(size == n){           // remove First
            return head.next;
        }

        int i = 1;
        int nodeFromStart = size-n+1;
        ListNode prev = head;
        while(i < nodeFromStart-1){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;

        return head;
    }
}