// Given the head of a singly linked list and two integers left
// and right where left <= right, reverse the nodes of the list
// from position left to position right, and return the reversed list.
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
//Example 2:
//
//Input: head = [5], left = 1, right = 1
//Output: [5]
//
//
//Constraints:
//
//The number of nodes in the list is n.
//1 <= n <= 500
//-500 <= Node.val <= 500
//1 <= left <= right <= n



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
     public ListNode reverseBetween(ListNode head, int left, int right) {
         // base case
         if(head == null || head.next == null){
             return head;
         }

         int n = 0;
         ListNode temp = head;
         while(temp != null){
             n++;
             temp = temp.next;
         }

         int[] nums = new int[n];
         for(int i=0; i<n; i++){
             nums[i] = head.val;
             head = head.next;
         }

         List<Integer> l = new ArrayList<>();
         for(int num : nums){
             l.add(num);
         }

         int j = left-1;
         for(int i=right-1; i>=left-1; i--){
             nums[i] = l.get(j++);
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