// You are given the head of a linked list with n nodes.
//
//For each node in the list, find the value of the next greater node.
// That is, for each node, find the value of the first node that is
// next to it and has a strictly larger value than it.
//
//Return an integer array answer where answer[i] is the value of the
// next greater node of the ith node (1-indexed). If the ith node does
// not have a next greater node, set answer[i] = 0.
//
//
//
//Example 1:
//
//
//Input: head = [2,1,5]
//Output: [5,5,0]
//Example 2:
//
//
//Input: head = [2,7,4,3,5]
//Output: [7,0,5,5,0]
//
//
//Constraints:
//
//The number of nodes in the list is n.
//1 <= n <= 104
//1 <= Node.val <= 109



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
class Solution {                 // O(n^2)
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> l = new ArrayList<>();
        while(head != null){
            l.add(head.val);
            head = head.next;
        }

        int[] answer = new int[l.size()];
        for(int i=0; i<l.size(); i++){
            for(int j=i+1; j<l.size(); j++){
                if(l.get(j) > l.get(i)){
                    answer[i] = l.get(j);
                    break;
                }
            }
        }

        return answer;
    }
}