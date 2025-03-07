/*
 82. Remove Duplicates from Sorted List II

 Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */

package leetcodeQuestions;
import java.util.HashMap;
class removeDuplicatesFromSortedListII{
    //Creating class for ListNode
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val) {this.val=val;}
        ListNode(int val, ListNode next){this.val=val; this.next=next;}
    }

     //Creating a function to display the list
     public static void display(ListNode head){
        while(head.next!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println(head.val);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer,Integer> map=new HashMap<>();
        ListNode p=head;
        while(p!=null){
            if(map.containsKey(p.val))
            map.put(p.val,map.get(p.val)+1);
            else map.put(p.val,1);
            p=p.next;
        }
        ListNode dummyHead=new ListNode(0);
        ListNode tail=dummyHead;
        ListNode ptr=head;
        while(ptr!=null){
            if(map.get(ptr.val)==1){
            ListNode node=new ListNode(ptr.val);
            tail.next=node;
            tail=tail.next;}
            ptr=ptr.next;}
        return dummyHead.next;
    }

    //Main Function
    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(4))));
        System.out.println("Original List:");
        display(list);
        System.out.println("After removing duplicates:");
        list=deleteDuplicates(list);
        display(list);

    }
}