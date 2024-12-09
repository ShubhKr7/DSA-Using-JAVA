/*
 206. Reverse Linked List

 Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

package leetcodeQuestions;
import java.util.*;

public class reversedLinkedList {
    
    //Making a listnode class
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }

         //Function to reverse a Linked List
         public ListNode reverseList(ListNode head){
            ListNode dummyHead=new ListNode();
            ListNode tail=dummyHead;
            ArrayList<Integer> array = new ArrayList<>();
            while(head!=null){
                array.add(head.val);
                head=head.next;
            }
                for(int i=array.size()-1; i>=0;i-=1){
                ListNode newNode = new ListNode(array.get(i));
                tail.next=newNode;
                tail=tail.next;}
            ListNode res=dummyHead.next;
            dummyHead.next=null;
            return res;
         }

         //Function to display the list
         public void display(ListNode list){
            while(list.next!=null){
                System.out.print(list.val+"->");
                list=list.next;
            }
            System.out.println(list.val);
         }

         //Main function
         public static void main(String[] args) {

            //making an object of parent class
            reversedLinkedList obj = new reversedLinkedList();

            //Making an object of subclass ListNode and forming a linked list as well
            ListNode list = obj.new ListNode(1, obj.new ListNode(2, obj.new ListNode(3, obj.new ListNode(4, obj.new ListNode(5)))));
            // ListNode list=obj.new ListNode();

            //Printing the linked list
            System.out.println("Original Linked List is:");
            obj.display(list);

            //Reversing the linked List
            ListNode res=obj.reverseList(list);
            
            //Printing reversed Linked List
            System.out.println("List after reversing:");
            obj.display(res);
         }
}
