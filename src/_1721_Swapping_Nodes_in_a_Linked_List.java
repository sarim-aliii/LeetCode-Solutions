// You are given the head of a linked list, and an integer k.
//
//Return the head of the linked list after swapping the values of the
// kth node from the beginning and the kth node from the end (the list is 1-indexed).
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], k = 2
//Output: [1,4,3,2,5]
//Example 2:
//
//Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
//Output: [7,9,6,6,8,7,3,0,9,5]
//
//
//Constraints:
//
//The number of nodes in the list is n.
//1 <= k <= n <= 105
//0 <= Node.val <= 100



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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        int n = 0;
        while(temp != null){
            n++;
            temp = temp.next;
        }

        int[] nums = new int[n];
        temp = head;
        int j = 0;
        while(temp != null){
            nums[j++] = temp.val;
            temp = temp.next;
        }

        int t = nums[k-1];
        nums[k-1] = nums[n-k];
        nums[n-k] = t;

        ListNode ans = new ListNode(-1);
        ListNode temp2 = ans;
        for(int num : nums){
            temp2.next = new ListNode(num);
            temp2 = temp2.next;
        }

        return ans.next;
    }
}