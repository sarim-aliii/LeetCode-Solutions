// Given the head of a sorted linked list, delete all nodes that have
// duplicate numbers, leaving only distinct numbers from the original
// list. Return the linked list sorted as well.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,3,4,4,5]
//Output: [1,2,5]
//Example 2:
//
//
//Input: head = [1,1,1,2,3]
//Output: [2,3]
//
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 300].
//-100 <= Node.val <= 100
//The list is guaranteed to be sorted in ascending order.



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



// Approach 1
// class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         if(head == null || head.next == null){
//             return head;
//         }

//         ListNode prev = head;
//         ListNode curr = head.next;
//         while(curr != null){
//             if(prev.val == curr.val){
//                 prev = curr.next;
//             }
//             else{
//                 prev = curr;
//             }
//             curr = curr.next;
//         }
//         return head;
//     }
// }




// Approach 2
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        List<Integer> l = new ArrayList<>();
        while(head != null){
            l.add(head.val);
            head = head.next;
        }

        List<Integer> dups = new ArrayList<>();
        for(int i=0; i<l.size()-1; i++){
            if(l.get(i) == l.get(i+1) && !dups.contains(l.get(i))){
                dups.add(l.get(i));
            }
        }

        for(int num : dups){
            while(l.contains(num)){
                l.remove(Integer.valueOf(num));
            }
        }

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        for(int num  : l){
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        return ans.next;
    }
}