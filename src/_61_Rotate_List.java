// Given the head of a linked list, rotate the list to the right by k places.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
//Example 2:
//
//
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
//
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 500].
//-100 <= Node.val <= 100
//0 <= k <= 2 * 109



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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        List<Integer> l = new ArrayList<>();
        while(head != null){
            l.add(head.val);
            head = head.next;
        }
        int n = l.size();
        k = k % n;          // if k > size of list

        int[] nums = new int[n];
        for(int i=0; i<k; i++){
            nums[i] = l.get(n-k+i);
        }
        int idx = 0;
        for(int i=k; i<n; i++){
            nums[i] = l.get(idx++);
        }

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        for(int num  : nums){
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        return ans.next;
    }
}