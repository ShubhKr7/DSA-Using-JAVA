/*
 83. Remove Duplicates from Sorted List

 Given the head of a sorted linked list, delete all duplicates such that each element appears only once. 
Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */

package leetcodeQuestions;

import java.util.TreeSet;

public class removeDuplicatesFromSortedList {
    
    //Making a ListNode class
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next){this.val=val; this.next=next;}
    }

    //Function to remove duplicates
    public static ListNode update(ListNode head){

        //Creating a hashset as it is maintains order of elements in ascending order
        TreeSet<Integer> set = new TreeSet<>();
        ListNode p=head;

        //Iterating over the list
        while(p!=null){
            set.add(p.val);
            p=p.next;
        }

        //Creating a new Linked List to return the updated list
        removeDuplicatesFromSortedList obj = new removeDuplicatesFromSortedList();
        ListNode dummyHead = obj.new ListNode();
        ListNode tail=dummyHead;
        for(Integer element : set){
            ListNode newNode = obj.new ListNode(element);
            tail.next=newNode;
            tail=tail.next;
        }

        //Retruning result
        return dummyHead.next;
    }

    //Creating a function to display the list
    public static void display(ListNode head){
        while(head.next!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println(head.val);
    }

    //Main function
    public static void main(String[] args) {

        //Making necessary objects
        removeDuplicatesFromSortedList obj = new removeDuplicatesFromSortedList();

        //Creating list
        // ListNode first = obj.new ListNode(1, obj.new ListNode(1, obj.new ListNode(1, obj.new ListNode(4, obj.new ListNode(5)))));
        // ListNode first = obj.new ListNode();
        ListNode first = obj.new ListNode(1, obj.new ListNode(1));
        System.out.println("Original list:");
        display(first);

        System.out.println("Duplicates removed list:");
        ListNode res=update(first);
        display(res);
    }
}
