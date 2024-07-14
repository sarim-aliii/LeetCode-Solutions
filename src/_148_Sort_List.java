// Given the head of a linked list, return the list after sorting it in ascending order.
//
//
//
//Example 1:
//
//
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
//Example 2:
//
//
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
//Example 3:
//
//Input: head = []
//Output: []
//
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 5 * 104].
//-105 <= Node.val <= 105



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
    public ListNode findMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode mergeSort(ListNode head){
        // base case
        if(head == null || head.next == null){
            return head;
        }

        ListNode midNode = findMidNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        ListNode head1 = mergeSort(head);
        ListNode head2 = mergeSort(rightHead);

        return merge(head1, head2);
    }
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode mergedLL = new ListNode(-1);
        ListNode temp = mergedLL;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}