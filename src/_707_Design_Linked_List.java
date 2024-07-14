// Design your implementation of the linked list. You can choose to use a
// singly or doubly linked list.
//A node in a singly linked list should have two attributes: val and next.
// val is the value of the current node, and next is a pointer/reference
// to the next node.
//If you want to use the doubly linked list, you will need one more attribute
// prev to indicate the previous node in the linked list. Assume all nodes in
// the linked list are 0-indexed.
//
//Implement the MyLinkedList class:
//
//MyLinkedList() Initializes the MyLinkedList object.
//int get(int index) Get the value of the indexth node in the linked list. If
// the index is invalid, return -1.
//void addAtHead(int val) Add a node of value val before the first element of
// the linked list. After the insertion, the new node will be the first node
// of the linked list.
//void addAtTail(int val) Append a node of value val as the last element of the linked list.
//void addAtIndex(int index, int val) Add a node of value val before the indexth
// node in the linked list. If index equals the length of the linked list,
// the node will be appended to the end of the linked list. If index is greater
// than the length, the node will not be inserted.
//void deleteAtIndex(int index) Delete the indexth node in the linked list,
// if the index is valid.
//
//
//Example 1:
//
//Input
//["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
//[[], [1], [3], [1, 2], [1], [1], [1]]
//Output
//[null, null, null, null, 2, null, 3]
//
//Explanation
//MyLinkedList myLinkedList = new MyLinkedList();
//myLinkedList.addAtHead(1);
//myLinkedList.addAtTail(3);
//myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
//myLinkedList.get(1);              // return 2
//myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
//myLinkedList.get(1);              // return 3
//
//
//Constraints:
//
//0 <= index, val <= 1000
//Please do not use the built-in LinkedList library.
//At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.



class MyLinkedList {

    public MyLinkedList() {

    }
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    private ListNode head;
    private ListNode tail;

    public int get(int index) {
        int i = 0;
        ListNode temp = head;
        while(temp != null){
            if(i == index){
                return temp.val;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode curr = new ListNode(val);

        // base case
        if(head == null){
            head = tail = curr;
        }
        else{
            curr.next = head;
            head = curr;
        }

    }

    public void addAtTail(int val) {
        ListNode curr = new ListNode(val);

        // base case
        if(head == null){
            head = tail = curr;
        }
        else{
            tail.next = curr;
            tail = curr;
        }
    }

    public void addAtIndex(int index, int val) {
        if(index == 0){
            addAtHead(val);
            return;
        }

        ListNode curr = new ListNode(val);
        int i = 0;
        ListNode temp = head;
        while(temp != null && i < index-1){
            temp = temp.next;
            i++;
        }
        if(temp != null){
            curr.next = temp.next;
            temp.next = curr;
            if(curr.next == null){
                tail = curr;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if(head == null){
            return;
        }
        if(index == 0){
            head = head.next;
            if(head == null){
                tail = null;
            }
            return;
        }

        ListNode temp = head;
        int i = 0;
        while(temp != null && i < index-1){
            temp = temp.next;
            i++;
        }

        if(temp != null && temp.next != null){
            temp.next = temp.next.next;
            if(temp.next == null){
                tail = temp;
            }
        }

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */