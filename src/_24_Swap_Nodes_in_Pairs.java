// Given a linked list, swap every two adjacent nodes and
// return its head. You must solve the problem without modifying
// the values in the list's nodes (i.e., only nodes themselves may be changed.)
//
//Example 1:
//
//
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
//Example 2:
//
//Input: head = []
//Output: []
//Example 3:
//
//Input: head = [1]
//Output: [1]
//
//
//Constraints:
//The number of nodes in the list is in the range [0, 100].
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
    public ListNode swapPairs(ListNode head) {
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

        for(int i=0; i<nums.length-1; i+=2){
            int t = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = t;
        }

        ListNode ans = new ListNode(-1);
        ListNode temp2 = ans;
        for(int num : nums){
            temp2.next = new ListNode(num);
            temp2 = temp2.next;
        }

        return ans.next;
    }
}