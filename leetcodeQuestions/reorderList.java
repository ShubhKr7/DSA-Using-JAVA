/*
 143. Reorder List

You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 */

package leetcodeQuestions;
import java.util.*;
public class reorderList{

    //Creating class for ListNode
    class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val) {this.val=val;}
        ListNode(int val, ListNode next){this.val=val; this.next=next;}
    }

    //Creating a function for reordering list
    public void reOrder(ListNode head){
        ListNode p=head;
        ArrayList<Integer> arr=new ArrayList<>();

        //Adding elements of linked list into an array
        while(p!=null){
            arr.add(p.val);
            p=p.next;
        }

        //Taking the last index of arraylist to iterate from right as well
        int z=arr.size()-1;

        //Start iterating from left
        for(int i=0;i<=z;i+=1){

            //Inserting elements from left end
            head.val=arr.get(i);
            head=head.next;

            //Inserting elements from right end
            if(!(z<=i)){
            head.val=arr.get(z);
            head=head.next;
            z-=1;}
        }
    }

    //New Solution without extra space
    public static void newSol(ListNode head){
        ListNode slow=head;ListNode fast=head;

        //Dividing the list into two different halves
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //Take two pointers as head of two lists
        ListNode p=head;ListNode q=slow.next;

        //Disconnect the second list from the first
        slow.next=null;

        //Reverse the second half
        ListNode prev=null;ListNode current=q;ListNode next=null;

        //Reversing the second half of the list
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        
        //Setting the new head of the reversed list
        q=prev;
        
        //Creating the final list
        while(q!=null){
            ListNode a=p.next;ListNode b=q.next;
            p.next=q;
            q.next=a;
            p=a;
            q=b;   
        }
    }
    
    //Creating a function to display the list
    public static void display(ListNode head){
        while(head.next!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println(head.val);
    }

    public static void main(String[] args) {

        //Making object of parent class
        reorderList obj=  new reorderList();

        //Making object of subclass and assigning values to linked list
        ListNode list = obj.new ListNode(1, obj.new ListNode(2, obj.new ListNode(3, obj.new ListNode(4))));

        //Printing original list
        System.out.println("Original List:");
        display(list);

        //Reordering list
        // obj.reOrder(list);
        newSol(list);

        //Displaying new list
        System.out.println("Reordered List:");
        display(list);
    }
}