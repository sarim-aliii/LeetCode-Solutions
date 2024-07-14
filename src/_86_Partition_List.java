// Given the head of a linked list and a value x, partition it
// such that all nodes
// less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of
// the two partitions.
//

//Example 1:
//Input: head = [1,4,3,2,5,2], x = 3
//Output: [1,2,2,4,3,5]
//Example 2:
//
//Input: head = [2,1], x = 2
//Output: [1,2]
//
//Constraints:
//The number of nodes in the list is in the range [0, 200].
//-100 <= Node.val <= 100
//-200 <= x <= 200



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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }

        List<Integer> l = new ArrayList<>();
        while(head != null){
            l.add(head.val);
            head = head.next;
        }

        List<Integer> smaller = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();
        for(int num : l){
            if(num < x){
                smaller.add(num);
            }
            else{
                larger.add(num);
            }
        }

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        for(int num : smaller){
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        for(int num : larger){
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        return ans.next;
    }
}
