/*
 25. Reverse Nodes in k-Group

 Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 */

package leetcodeQuestions;

import java.util.ArrayList;

public class reverseNodesInKGroups {

    //ListNode class
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next){this.val=val; this.next=next;}
    }

    //Function to reverse the list
    public static ListNode reverse(ListNode head, int k){

        //Creating necessary object
        reverseNodesInKGroups obj = new reverseNodesInKGroups();
            ListNode dummyHead = obj.new ListNode();

            //Making a resulting linked list
            ListNode tail = dummyHead;
            ListNode p = head; int size=0;

            //Finding size of the list
            while(p!=null){
                size+=1; p=p.next;
            }

            //A pointer to iterate over the list
            ListNode q = head;

            //iterating till no nodes or nodes less than k are left
            while(size>=k){

                //Taking two indexes
                int z=1,m=1;

                //An ArrayList to push k nodes at a time
                ArrayList<Integer> list = new ArrayList<>();

                //Adding k nodes value to arraylist
                while(z!=k+1){
                    list.add(q.val);
                    q=q.next;
                    z+=1;
                }

                //Storing last index of arraylist
                int l=list.size();

                //Reversing the nodes and making a new linked list
                while(m!=k+1){
                    ListNode newNode=  obj.new ListNode(list.get(l-1));
                    tail.next=newNode;
                    tail=tail.next;
                    head=head.next;
                    l-=1;
                    m+=1;
                }

                //Updating size variable
                size-=k;
            }

            //Adding any leftover nodes
            while(size>0){
                ListNode newNode=  obj.new ListNode(head.val);
                head=head.next;
                    tail.next=newNode;
                    tail=tail.next;
                    size-=1;
            }

            //Returning resulting linked list
            return dummyHead.next;
    }


    //Function to display the linked list
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
        reverseNodesInKGroups obj = new reverseNodesInKGroups();

        //Creating a linked list
        ListNode first = obj.new ListNode(1, obj.new ListNode(2, obj.new ListNode(3, obj.new ListNode(4, obj.new ListNode(5)))));

        //Performing the necessary task
        System.out.println("List before:");
        display(first);
        ListNode head = first;
        ListNode res = reverse(head,3);
        display(res);
    }
    
}
