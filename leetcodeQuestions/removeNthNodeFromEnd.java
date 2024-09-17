/*
 19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]
 */

package leetcodeQuestions;

public class removeNthNodeFromEnd {

    //Making a ListNode class
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next){this.val=val; this.next=next;}
    }

    public ListNode remove(ListNode head, int n){
        
        if(head.next==null) {head=null; return head;}

        //Taking 2 pointers one node behind and one node ahead
        ListNode p=head;

        //Using r to find size of list
        ListNode r = head;
        
        //Romving last node
        if(n==1){
            while(p.next.next!=null)
            p=p.next;
            p.next=null;
            return head;
        }

         //Size will have index of last element that is length-1
         int size=0;
         while(r!=null){
             size+=1;
             r=r.next;
         }
        
        //Removing head
        if(n==size){
            //Return second node
            //This will work on leetcode but not while using display function here!
            return p.next;
        }
        
        //Finding position of node from start
        int node = size-n;
        
        //Removing middle node
            ListNode q=head.next.next;    
            while((node-1)!=0){
                p=p.next;
                q=q.next;
                node-=1;
            }
            p.next=q;

        return head;
    }

     //Creating a function to display the list
     public void display(ListNode head){
        // if(head==null) System.out.print(" Empty List found ");
        // else{
        while(head.next!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println(head.val);
    }
    // }

    //main Function
    public static void main(String[] args) {
        removeNthNodeFromEnd obj = new removeNthNodeFromEnd();
        // ListNode first = obj.new ListNode(1, obj.new ListNode(2, obj.new ListNode(3, obj.new ListNode(4, obj.new ListNode(5)))));
        ListNode first = obj.new ListNode(1, obj.new ListNode(2, obj.new ListNode(3)));
        // ListNode first = obj.new ListNode(1);
        ListNode head = first;
        int n=3;
        obj.remove(head,n);
        System.out.println("Final List:");
        obj.display(head);
    }
    
}
