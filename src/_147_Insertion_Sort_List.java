// Given the head of a singly linked list, sort the list using insertion sort,
// and return the sorted list's head.
//
//The steps of the insertion sort algorithm:
//
//Insertion sort iterates, consuming one input element each repetition and
// growing a sorted output list.
//At each iteration, insertion sort removes one element from the input data,
// finds the location it belongs within the sorted list and inserts it there.
//It repeats until no input elements remain.
//The following is a graphical example of the insertion sort algorithm.
// The partially sorted list (black) initially contains only the first element
// in the list. One element (red) is removed from the input data and inserted
// in-place into the sorted list with each iteration.
//
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
//
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 5000].
//-5000 <= Node.val <= 5000



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
     public ListNode insertionSortList(ListNode head) {
         return mergeSort(head);
     }
 }