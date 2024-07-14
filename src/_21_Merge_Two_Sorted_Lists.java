// You are given the heads of two sorted linked lists list1 and list2.
//
//Merge the two lists into one sorted list. The list should be made by
// splicing together the nodes of the first two lists.
//
//Return the head of the merged linked list.
//
//Example 1:
//
//
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//Example 2:
//
//Input: list1 = [], list2 = []
//Output: []
//Example 3:
//
//Input: list1 = [], list2 = [0]
//Output: [0]
//
//
//Constraints:
//
//The number of nodes in both lists is in the range [0, 50].
//-100 <= Node.val <= 100
//Both list1 and list2 are sorted in non-decreasing order.



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


// Approach 1 - Using Extra Space
//class Solution {
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode mergedLL = new ListNode(-1);
//        ListNode temp = mergedLL;
//        while(list1 != null && list2 != null){
//            if(list1.val <= list2.val){
//                temp.next = list1;
//                list1 = list1.next;
//                temp = temp.next;
//            }
//            else{
//                temp.next = list2;
//                list2 = list2.next;
//                temp = temp.next;
//            }
//        }
//        while(list1 != null){
//            temp.next = list1;
//            list1 = list1.next;
//            temp = temp.next;
//        }
//        while(list2 != null){
//            temp.next = list2;
//            list2 = list2.next;
//            temp = temp.next;
//        }
//
//        return mergedLL.next;
//    }
//}



// Approach 2 - Without Using Extra Space
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        if(list1 == null){
            temp.next = list2;
        }
        else{
            temp.next = list1;
        }

        return ans.next;
    }
}