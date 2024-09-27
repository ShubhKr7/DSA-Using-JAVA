/*
 141. Linked List Cycle

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

Constraints:
The number of the nodes in the list is in the range [0, 10^4].
-10^5 <= Node.val <= 10^5
pos is -1 or a valid index in the linked-list.
 */

package leetcodeQuestions;

public class linkedListCycle {

    //Making a ListNode class
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next){this.val=val; this.next=next;}
    }

    //Solution Function
    public static boolean hasCycle(ListNode head){

        //If a null head or only single element is passed then return false as no loop can exist
        if(head==null||head.next==null) return false;

        //Take two pointers p and q which are atleast 1 node apart
        ListNode p=head; ListNode q=head.next.next;

        //Iterate till q reaches end or surpasses it
        while(q!=null){

            //If a loop will exist then at some point p and q will become equal
            if(p==q) return true;

            //Else update p to next
            p=p.next;

            //If q has no node next to it then there exists no loop
            if(q.next==null) return false;

            //Else update q as well
            q=q.next.next;
        }

        //If no statement is exexuted then return default false
        return false;
    }

    //Creating a function to display the list
    public void display(ListNode head){
        while(head.next!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println(head.val);
    }


    //Main Function
    public static void main(String[] args) {

        //Creating necessary objects
        linkedListCycle obj = new linkedListCycle();
        // ListNode first = obj.new ListNode(1, obj.new ListNode(2, obj.new ListNode(3, obj.new ListNode(4, obj.new ListNode(5)))));
        // ListNode first = obj.new ListNode(1, obj.new ListNode(2));

        //Creating a cyclic Linked List
        // ListNode third = obj.new ListNode(3);
        // ListNode second = obj.new ListNode(2, third);
        // ListNode first = obj.new ListNode(1,second);
        // third.next=first;

        //One node cyclic linked list
        ListNode first = obj.new ListNode(1);
        first.next=first;

        //Calling function and printing result
        System.out.println(hasCycle(first));

    }
}
