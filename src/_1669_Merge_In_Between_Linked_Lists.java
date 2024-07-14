// You are given two linked lists: list1 and list2 of sizes n and m respectively.
//
//Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
//
//The blue edges and nodes in the following figure indicate the result:
//
//
//Build the result list and return its head.
//
//
//
//Example 1:
//
//
//Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
//Output: [10,1,13,1000000,1000001,1000002,5]
//Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place.
// The blue edges and nodes in the above figure indicate the result.
//Example 2:
//
//
//Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
//Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
//Explanation: The blue edges and nodes in the above figure indicate the result.
//
//
//Constraints:
//
//3 <= list1.length <= 104
//1 <= a <= b < list1.length - 1
//1 <= list2.length <= 104



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



// class Solution {
//     public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
//         List<Integer> l = new ArrayList<>();
//         while(list1 != null){
//             l.add(list1.val);
//             list1 = list1.next;
//         }

//         List<Integer> deletedElement = new ArrayList<>();
//         for(int i=a; i<=b; i++){
//             deletedElement.add(l.get(i));
//         }

//         for(int num : deletedElement){
//             l.remove(Integer.valueOf(num));
//         }

//         while(list2 != null){
//             l.add(a++, list2.val);
//             list2 = list2.next;
//         }

//         ListNode ans = new ListNode(-1);
//         ListNode temp = ans;
//         for(int num : l){
//             temp.next = new ListNode(num);
//             temp = temp.next;
//         }

//         return ans.next;
//     }
// }


class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int i = 0;
        ListNode temp = list1;

        // find the node just before the ath node
        while(i < a-1){
            i++;
            temp = temp.next;
        }

        // save the curr node i.e. just before a to link later
        ListNode nodeJustBeforeA = temp;

        // move towards bth node
        while(i <= b){
            i++;
            temp = temp.next;
        }

        // save the curr node i.e. after b to link later
        ListNode nodeJustAfterB = temp.next;

        // linking
        nodeJustBeforeA.next = list2;

        ListNode temp2 = list2;
        while(temp2.next != null){
            temp2 = temp2.next;
        }

        temp2.next = nodeJustAfterB;

        return list1;
    }
}