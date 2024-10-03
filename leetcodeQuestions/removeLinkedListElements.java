/*
 203. Remove Linked List Elements

Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:
Input: head = [], val = 1
Output: []

Example 3:
Input: head = [7,7,7,7], val = 7
Output: []

Constraints:
The number of nodes in the list is in the range [0, 10^4].
1 <= Node.val <= 50
0 <= val <= 50
 */

package leetcodeQuestions;
public class removeLinkedListElements {

    //Making a ListNode class
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next){this.val=val; this.next=next;}
    }

    //Function to remove desired values from the linked list
    public static ListNode del(ListNode head, int val){

        //If no list is passed then return null head
        if(head==null) return head;

        //Make a head node for a new linkedList
        ListNode dummyHead=new ListNode();
        ListNode tail=dummyHead;
        ListNode p=head;

        //Iterate till list end is not reached
        while(p!=null){

            //If the value exists in the list then just update p pointer
            if(p.val==val) p=p.next;

            //If not, then add a new node to the new linked list and update p pointer
            else {
                ListNode newNode=new ListNode();
                newNode.val=p.val;
                tail.next=newNode;
                tail=tail.next;
                p=p.next;
            }
        }

        //Return the new linked list 
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
        // ListNode first = new ListNode(5, new ListNode(2, new ListNode(5, new ListNode(4, new ListNode(5)))));
        ListNode first = new ListNode();
        int val=5;
        System.out.println("Original lists:");
        display(first);

        System.out.println("After deletion:");
        ListNode res=del(first,val);
        display(res);
    }
}
