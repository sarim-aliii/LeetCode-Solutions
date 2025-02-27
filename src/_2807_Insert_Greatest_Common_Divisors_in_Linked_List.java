// Given the head of a linked list head, in which each node
// contains an integer value.
//
//Between every pair of adjacent nodes, insert a new node with a value equal
// to the greatest common divisor of them.
//
//Return the linked list after insertion.
//
//The greatest common divisor of two numbers is the largest positive
// integer that evenly divides both numbers.
//
//
//
//Example 1:
//
//
//Input: head = [18,6,10,3]
//Output: [18,6,6,2,10,1,3]
//Explanation: The 1st diagram denotes the initial linked list and
// the 2nd diagram denotes the linked list after inserting the new
// nodes (nodes in blue are the inserted nodes).
//- We insert the greatest common divisor of 18 and 6 = 6 between the 1st and the 2nd nodes.
//- We insert the greatest common divisor of 6 and 10 = 2 between the 2nd and the 3rd nodes.
//- We insert the greatest common divisor of 10 and 3 = 1 between the 3rd and the 4th nodes.
//There are no more adjacent nodes, so we return the linked list.
//Example 2:
//
//
//Input: head = [7]
//Output: [7]
//Explanation: The 1st diagram denotes the initial linked list and
// the 2nd diagram denotes the linked list after inserting the new nodes.
//There are no pairs of adjacent nodes, so we return the initial linked list.
//
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 5000].
//1 <= Node.val <= 1000



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


class Solution {            // O(n^2)
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        List<Integer> l = new ArrayList<>();
        while(temp != null){
            l.add(temp.val);
            temp = temp.next;
        }

        List<Integer> gcd = new ArrayList<>();
        for(int i=0; i<l.size()-1; i++){
            int divisor = 1;
            for(int j=2; j<=Math.min(l.get(i), l.get(i+1)); j++){
                if(l.get(i) % j == 0 && l.get(i+1) % j == 0){
                    divisor = Math.max(divisor, j);
                }
            }
            gcd.add(divisor);
        }

        int[] arr = new int[l.size() + gcd.size()];

        int j = 0, i = 0;
        while(j < l.size()){
            arr[i] = l.get(j++);
            i+=2;
        }

        i = 1, j = 0;
        while(j < gcd.size()){
            arr[i] = gcd.get(j++);
            i+=2;
        }


        ListNode ans = new ListNode(-1);
        ListNode temp2 = ans;
        for(int num : arr){
            temp2.next = new ListNode(num);
            temp2 = temp2.next;
        }

        return ans.next;
    }
}